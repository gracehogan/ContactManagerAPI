package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "phone_number_seq")
    @SequenceGenerator(
            name= "phone_number_seq",
            sequenceName = "phone_number_seq",
            initialValue = 1,
            allocationSize = 1
    )
    Long id;

    private String countryCode;
    private String number;

    @ManyToOne
    Contact contact;
}
