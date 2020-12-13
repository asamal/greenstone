package com.samal.greenstone.core.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Tree {

    public Tree(Long id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID uuid;
    @Column(name = "description")
    private String desc;
    @OneToMany
    private Collection<Note> notes = new HashSet<>();
}
