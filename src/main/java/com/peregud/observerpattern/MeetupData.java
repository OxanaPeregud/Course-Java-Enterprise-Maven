package com.peregud.observerpattern;

import com.peregud.observerpattern.observers.MeetupParticipant;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MeetupData implements Meetup {
    private final List<MeetupParticipant> meetupParticipants;
    private LocalDateTime meetupTime;
    private String location;
    private String topic;

    public MeetupData() {
        meetupParticipants = new ArrayList<>();
    }

    @Override
    public void registerMeetupParticipant(MeetupParticipant meetupParticipant) {
        meetupParticipants.add(meetupParticipant);
    }

    @Override
    public void removeMeetupParticipant(MeetupParticipant meetupParticipant) {
        int i = meetupParticipants.indexOf(meetupParticipant);
        if (i >= 0) {
            meetupParticipants.remove(i);
        }
    }

    @Override
    public void notifyMeetupParticipants() {
        meetupParticipants.forEach(meetupParticipant -> meetupParticipant.update(meetupTime, location, topic));
    }

    public void meetupDataChanged() {
        notifyMeetupParticipants();
    }

    public void setMeetup(LocalDateTime meetupTime, String location, String topic) {
        this.meetupTime = meetupTime;
        this.location = location;
        this.topic = topic;
        meetupDataChanged();
    }
}
