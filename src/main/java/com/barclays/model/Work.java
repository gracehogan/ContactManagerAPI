package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Work extends Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "work_seq")
    @SequenceGenerator(
            name = "work_seq",
            sequenceName = "work_seq",
            initialValue = 1,
            allocationSize = 1
    )
    Long id;

    public Work() {
        this.setType(Type.WORK);
    }
}