package com.samal.greenstone.tree.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@NoArgsConstructor
@Getter
@Setter
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
