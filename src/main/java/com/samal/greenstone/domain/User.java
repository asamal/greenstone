package com.samal.greenstone.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
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

