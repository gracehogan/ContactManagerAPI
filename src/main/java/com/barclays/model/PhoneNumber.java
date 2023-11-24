package com.barclays.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "contact_id")
    Contact contact;
}
