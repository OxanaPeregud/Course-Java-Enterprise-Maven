package com.peregud.observerpattern;

import com.peregud.observerpattern.observers.MeetupParticipant;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CurrentMeetupDisplay implements MeetupParticipant, DisplayElement {
    private LocalDateTime meetupTime;
    private String location;
    private String topic;

    public CurrentMeetupDisplay(Meetup meetup) {
        meetup.registerMeetupParticipant(this);
    }

    @Override
    public void update(LocalDateTime meetupTime, String location, String topic) {
        this.meetupTime = meetupTime;
        this.location = location;
        this.topic = topic;
        display();
    }

    @Override
    public void display() {
        System.out.println("Meetup time: " + meetupTime + ", location: " + location + ", topic: " + topic);
    }
}
