package ru.bellintegrator;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Stateless
public class PollYahoo {

    private static final String APP_ID = "kYAIGJ64";
    private static final String CONSUMER_KEY = "dj0yJmk9YUNnMjZIellNYTRXJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PWE3";
    private static final String CONSUMER_SECRET = "23081a84d99662043bded37ead72a8b4ab919ae2";
    private static final String URL = "https://weather-ydn-yql.media.yahoo.com/forecastrss";

    public String get(String city) {
        long timestamp = new Date().getTime() / 1000;
        byte[] nonce = new byte[32];
        Random rand = new Random();
        rand.nextBytes(nonce);
        String oauthNonce = new String(nonce).replaceAll("\\W", "");

        List<String> parameters = new ArrayList<>();
        parameters.add("oauth_consumer_key=" + CONSUMER_KEY);
        parameters.add("oauth_nonce=" + oauthNonce);
        parameters.add("oauth_signature_method=HMAC-SHA1");
        parameters.add("oauth_timestamp=" + timestamp);
        parameters.add("oauth_version=1.0");
        parameters.add("location=" + encodeToUtf8(city));
        parameters.add("format=json");
        Collections.sort(parameters);

        StringBuffer parametersList = new StringBuffer();
        for (int i = 0; i < parameters.size(); i++) {
            parametersList.append(((i > 0) ? "&" : "") + parameters.get(i));
        }

        String signatureString = "GET&" + encodeToUtf8(URL) + "&" + encodeToUtf8(parametersList.toString());

        String signature = null;
        try {
            SecretKeySpec signingKey = new SecretKeySpec((CONSUMER_SECRET + "&").getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHMAC = mac.doFinal(signatureString.getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            signature = encoder.encodeToString(rawHMAC);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Create signature error", e);
        }

        String authorizationLine = "OAuth " + "oauth_consumer_key=\"" + CONSUMER_KEY + "\", "
                + "oauth_nonce=\"" + oauthNonce + "\", " + "oauth_timestamp=\"" + timestamp + "\", "
                + "oauth_signature_method=\"HMAC-SHA1\", " + "oauth_signature=\"" + signature + "\", "
                + "oauth_version=\"1.0\"";

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authorizationLine);
        headers.add("Yahoo-App-Id", APP_ID);
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity httpEntity = new HttpEntity(headers);
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> response = restTemplate.exchange(URL + "?location=" + city + "&format=json", HttpMethod.GET, httpEntity, String.class);

        return response.getBody();
    }

    private String encodeToUtf8(String str) {
        String result;
        try {
            result = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("String converting to utf8 error", e);
        }
        return result;
    }
}
