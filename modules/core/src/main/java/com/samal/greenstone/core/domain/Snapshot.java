package com.samal.greenstone.core.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
