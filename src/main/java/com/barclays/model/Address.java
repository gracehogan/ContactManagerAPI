package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "address_seq")
    @SequenceGenerator(
            name= "address_seq",
            sequenceName = "address_seq",
            initialValue = 1,
            allocationSize = 1
    )
    Long id;

    private String lineOne;
    private String lineTwo;
    private String state;
    private String postalCode;
    private String country;
}
