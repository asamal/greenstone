package com.samal.greenstone.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class NodeEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private User user;
    private ZonedDateTime dateTime;
    private NoteAction action;
    @ManyToOne
    private Note note;
}
