package com.peregud.observerpattern;

import com.peregud.observerpattern.observers.MeetupParticipant;

public interface Meetup {

    void registerMeetupParticipant(MeetupParticipant meetupParticipant);

    void removeMeetupParticipant(MeetupParticipant meetupParticipant);

    void notifyMeetupParticipants();
}

