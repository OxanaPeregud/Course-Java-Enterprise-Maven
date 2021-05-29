package com.peregud.observerpattern;

import com.peregud.observerpattern.observers.MeetupParticipant;
import com.peregud.observerpattern.observers.ProductManager;
import com.peregud.observerpattern.observers.Programmer;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetupDataTest {
    MeetupData meetupData = new MeetupData();
    MeetupParticipant meetupParticipant1 = new ProductManager();
    MeetupParticipant meetupParticipant2 = new Programmer();

    @Test
    void registerMeetupParticipant_success() {
        meetupData.registerMeetupParticipant(meetupParticipant1);
        meetupData.registerMeetupParticipant(meetupParticipant2);
        assertEquals(List.of(meetupParticipant1, meetupParticipant2), meetupData.getMeetupParticipants());
    }

    @Test
    void registerMeetupParticipant_fail() {
        meetupData.registerMeetupParticipant(meetupParticipant1);
        meetupData.registerMeetupParticipant(meetupParticipant2);
        assertNotEquals(List.of(meetupParticipant1), meetupData.getMeetupParticipants());
    }

    @Test
    void removeMeetupParticipant_success() {
        meetupData.registerMeetupParticipant(meetupParticipant1);
        meetupData.registerMeetupParticipant(meetupParticipant2);
        meetupData.removeMeetupParticipant(meetupParticipant2);
        assertEquals(List.of(meetupParticipant1), meetupData.getMeetupParticipants());
    }

    @Test
    void removeMeetupParticipant_fail() {
        meetupData.registerMeetupParticipant(meetupParticipant1);
        meetupData.registerMeetupParticipant(meetupParticipant2);
        meetupData.removeMeetupParticipant(meetupParticipant2);
        assertNotEquals(List.of(meetupParticipant1, meetupParticipant2), meetupData.getMeetupParticipants());
    }

    @Test
    void setMeetupAndNotifyMeetupParticipants() {
        meetupData.notifyMeetupParticipants();
        LocalDateTime meetupTime = LocalDateTime.of(2021, 5, 29, 10, 0, 0);
        meetupData.setMeetup(meetupTime, "Location", "Topic");
        assertEquals(meetupTime, meetupData.getMeetupTime());
        assertEquals("Location", meetupData.getLocation());
        assertEquals("Topic", meetupData.getTopic());
    }

    @Test
    void meetupDataChanged() {
        meetupData.meetupDataChanged();
        LocalDateTime meetupTime = LocalDateTime.of(2021, 5, 29, 10, 0, 0);
        meetupData.setMeetup(meetupTime, "Location", "Topic");
        assertEquals(meetupTime, meetupData.getMeetupTime());
        assertEquals("Location", meetupData.getLocation());
        assertEquals("Topic", meetupData.getTopic());
    }
}
