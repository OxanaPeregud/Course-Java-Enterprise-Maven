package com.peregud.observerpattern.observers;

import java.time.LocalDateTime;

@FunctionalInterface
public interface MeetupParticipant {
    void update(LocalDateTime meetupTime, String location, String topic);
}
