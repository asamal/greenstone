package com.samal.greenstone.core.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Tree tree;
    private Operation operation;
    @OneToOne
    private Snapshot snapshot;
    @OneToMany
    private Collection<NodeEvent> nodeEvents = new HashSet<>();
}
