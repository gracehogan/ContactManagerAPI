package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@MappedSuperclass
@NoArgsConstructor
@Data
public abstract class Contact {

    private String name;

    private String email;

    private Address address;

    @OneToMany(mappedBy =  "contact")
    private List<PhoneNumber> phoneNumbers;

    @Enumerated (EnumType.STRING)
    private Type type;


}
