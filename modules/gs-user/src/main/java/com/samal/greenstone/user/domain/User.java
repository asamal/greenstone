package com.samal.greenstone.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "gs_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuid;
    private String name;
    private String email;

    public User(String firstName, String lastName) {
        this.name = firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Use[id=%d, name='%s']",
                id, name);
    }
}

