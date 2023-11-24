package com.barclays.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@NoArgsConstructor
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "contact_seq")
    @SequenceGenerator(
            name= "contact_seq",
            sequenceName = "contact_seq",
            initialValue = 1,
            allocationSize = 1
    )
    Long id;

    private String name;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @JsonManagedReference
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhoneNumber> phoneNumbers;

    @Enumerated (EnumType.STRING)
    private ContactType contactType;

    public String getContactType() {
        if (this.contactType == null) {
            return null;
        }
        return this.contactType.name();
    }

}
