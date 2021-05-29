package com.peregud.observerpattern;

public interface Meetup {

    void registerMeetupParticipant(MeetupParticipant meetupParticipant);

    void removeMeetupParticipant(MeetupParticipant meetupParticipant);

    void notifyMeetupParticipants();
}

