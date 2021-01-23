package com.samal.greenstone.tree.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public class NodeEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private UUID userUuid;
    private ZonedDateTime dateTime;
    private NoteAction action;
    @ManyToOne
    private Note note;
}
