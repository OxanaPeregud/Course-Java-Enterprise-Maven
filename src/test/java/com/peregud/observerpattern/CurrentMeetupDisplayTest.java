package com.peregud.observerpattern;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CurrentMeetupDisplayTest {
    MeetupData meetupData = new MeetupData();
    CurrentMeetupDisplay currentMeetupDisplay = new CurrentMeetupDisplay(meetupData);

    @Test
    void update() {
        LocalDateTime meetupTime = LocalDateTime.of(2021, 5, 29, 10, 0, 0);
        currentMeetupDisplay.update(meetupTime, "Location", "Topic");
        assertEquals(meetupTime, currentMeetupDisplay.getMeetupTime());
        assertEquals("Location", currentMeetupDisplay.getLocation());
        assertEquals("Topic", currentMeetupDisplay.getTopic());
    }
}
