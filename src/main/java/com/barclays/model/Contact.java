package com.barclays.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Data
public abstract class Contact {

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

    @OneToMany(mappedBy = "contact")
    private List<PhoneNumber> phoneNumbers;

    @Enumerated (EnumType.STRING)
    private Type type;

    public String getType() {
        if (this.type == null) {
            return null;
        }
        return this.type.name();
    }

}
