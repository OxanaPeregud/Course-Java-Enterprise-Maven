package com.peregud.manytomany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "meeting")
public class Meeting implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id", unique = true)
    private Long meetingId;

    @Column
    private String subject;

    @Column
    private LocalDate startDate;

    @ManyToMany(mappedBy = "meetings")
    private Set<Employee> employees = new HashSet<>();
}
