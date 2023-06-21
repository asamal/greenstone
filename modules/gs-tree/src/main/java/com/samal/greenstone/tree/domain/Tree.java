package com.samal.greenstone.tree.domain;

import lombok.*;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuid;
    private String description;
    @OneToMany
    private Collection<Note> notes = new HashSet<>();
    private String upperCaseDesc;
    private String lowerCaseDesc;
}
