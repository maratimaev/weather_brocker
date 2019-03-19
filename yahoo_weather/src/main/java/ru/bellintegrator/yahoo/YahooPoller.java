package ru.bellintegrator.yahoo;

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

/**
 * Запрос погодных данных с сайта yahoo.com
 */
@Stateless
public class YahooPoller {
    /**
     * ID приложения на сайте yahoo.com
     */
    private final static String APP_ID="kYAIGJ64";
    /**
     * ключ пользователя
     */
    private final static String CONSUMER_KEY="dj0yJmk9YUNnMjZIellNYTRXJnM9Y29uc3VtZXJzZWNyZXQmc3Y9MCZ4PWE3";
    /**
     * пароль пользователя
     */
    private final static String CONSUMER_SECRET="23081a84d99662043bded37ead72a8b4ab919ae2";
    /**
     * адрес api yahoo.com
     */
    private final static String URL="https://weather-ydn-yql.media.yahoo.com/forecastrss";

    /** Запрос прогноза по определенному городу
     * @param city название города, для которого запрашивается прогноз
     * @return json прогноза погоды
     */
    public String getWeatherFromYahoo(String city) {
        long timestamp = new Date().getTime() / 1000;
        byte[] nonce = new byte[32];
        Random rand = new Random();
        rand.nextBytes(nonce);
        String oauthNonce = new String(nonce).replaceAll("\\W", "");

        String parameters = "GET&" + encodeToUtf8(URL) + "&" + encodeToUtf8(getParameters(city, timestamp, oauthNonce));

        String signature = createSignature(parameters);

        String authorizationLine = createAuthorizationLine(signature, timestamp, oauthNonce);

        final HttpEntity httpEntity = new HttpEntity(createHeaders(authorizationLine));
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<String> response = restTemplate.exchange(URL + "?location=" + city + "&format=json", HttpMethod.GET, httpEntity, String.class);

        return response.getBody();
    }

    private HttpHeaders createHeaders(String authorizationLine) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationLine);
        headers.set("Yahoo-App-Id", APP_ID);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private String encodeToUtf8(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("String converting to utf8 error", e);
        }
    }

    private String getParameters(String city, long timestamp, String oauthNonce){
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
        return parametersList.toString();
    }

    private String createSignature(String parameters){
        String signature = null;
        try {
            SecretKeySpec signingKey = new SecretKeySpec((CONSUMER_SECRET + "&").getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHMAC = mac.doFinal(parameters.getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            signature = encoder.encodeToString(rawHMAC);
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Create signature error", e);
        }
        return signature;
    }

    private String createAuthorizationLine(String signature, long timestamp, String oauthNonce){
        return "OAuth " + "oauth_consumer_key=\"" + CONSUMER_KEY + "\", "
                + "oauth_nonce=\"" + oauthNonce + "\", " + "oauth_timestamp=\"" + timestamp + "\", "
                + "oauth_signature_method=\"HMAC-SHA1\", " + "oauth_signature=\"" + signature + "\", "
                + "oauth_version=\"1.0\"";
    }
}
