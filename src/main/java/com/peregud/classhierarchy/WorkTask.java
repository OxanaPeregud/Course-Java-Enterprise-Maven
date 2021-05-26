package com.peregud.classhierarchy;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "work_task")
@DiscriminatorValue("W")
@DynamicInsert
@DynamicUpdate
public class WorkTask extends Task {
    private double cost;
}
