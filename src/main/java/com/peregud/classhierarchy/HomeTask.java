package com.peregud.classhierarchy;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "home_task")
@DiscriminatorValue("H")
@DynamicInsert
@DynamicUpdate
public class HomeTask extends Task {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Embedded
    private Address address;
}
