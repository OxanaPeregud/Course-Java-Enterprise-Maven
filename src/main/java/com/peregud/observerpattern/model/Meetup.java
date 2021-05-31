package com.peregud.observerpattern.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "meetup")
@Table(name = "meetup")
public class Meetup implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meetup_id", unique = true)
    private int meetupId;

    @Column(name = "meetup_time")
    private LocalDateTime meetupTime;

    @Column
    private String location;

    @Column
    private String topic;
}
