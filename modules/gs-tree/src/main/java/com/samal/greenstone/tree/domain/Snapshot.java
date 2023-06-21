package com.samal.greenstone.tree.domain;

import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@NoArgsConstructor
public class Snapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private TreeType type;
    private Double size;
    private TreeStatus status;
}
