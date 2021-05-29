package com.peregud.observerpattern.observers;

import java.time.LocalDateTime;

public interface MeetupParticipant {
    void update(LocalDateTime meetupTime, String location, String topic);
}
