package com.peregud.observerpattern.observers;

import java.time.LocalDateTime;

public class Programmer implements MeetupParticipant {

    @Override
    public void update(LocalDateTime meetupTime, String location, String topic) {
    }
}
