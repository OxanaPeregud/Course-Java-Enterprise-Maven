package com.peregud.observerpattern;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class MeetupDBTest {

    @Test
    void getMeetupTime() {
        MeetupDB meetupDB = mock(MeetupDB.class);
        LocalDateTime meetupTime = LocalDateTime.of(2021, 5, 29, 10, 0, 0);
        when(meetupDB.getMeetupTime(any(Integer.class))).thenReturn(meetupTime);
        assertEquals(meetupTime, meetupDB.getMeetupTime(1));
    }

    @Test
    void getLocation() {
        MeetupDB meetupDB = mock(MeetupDB.class);
        String location = "Location";
        when(meetupDB.getLocation(any(Integer.class))).thenReturn(location);
        assertEquals(location, meetupDB.getLocation(1));
    }

    @Test
    void getTopic() {
        MeetupDB meetupDB = mock(MeetupDB.class);
        String topic = "Topic";
        when(meetupDB.getLocation(any(Integer.class))).thenReturn(topic);
        assertEquals(topic, meetupDB.getLocation(1));
    }
}
