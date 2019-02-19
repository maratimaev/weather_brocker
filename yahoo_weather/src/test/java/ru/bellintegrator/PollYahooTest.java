package ru.bellintegrator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PollYahooTest {
    @Test
    public void whenPollYahooThenGetWeather() {
        PollYahoo pollYahoo = new PollYahoo();
        assertThat(pollYahoo.poll("Ufa").contains("Bashkortostan Republic"), is(true));
    }
}
