package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Personal extends Contact{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "personal_seq")
    @SequenceGenerator(
            name= "personal_seq",
            sequenceName = "personal_seq",
            initialValue = 1,
            allocationSize = 1
    )
    Long id;

    public Personal() {
        this.setType(Type.PERSONAL);
    }
}

