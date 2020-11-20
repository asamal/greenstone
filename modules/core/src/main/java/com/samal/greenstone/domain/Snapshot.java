package com.samal.greenstone.domain;

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
    // private Location location;
    private Double size;
    private TreeStatus status;
}
