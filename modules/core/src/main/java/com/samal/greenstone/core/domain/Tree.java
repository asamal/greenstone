package com.samal.greenstone.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuid;
    private String desc;
    @OneToMany
    private Collection<Note> notes = new HashSet<>();
}
