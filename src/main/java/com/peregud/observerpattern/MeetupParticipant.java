package com.peregud.observerpattern;

import java.time.LocalDateTime;

public interface MeetupParticipant {
    void update(LocalDateTime meetupTime, String location, String topic);
}
