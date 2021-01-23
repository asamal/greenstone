package com.samal.greenstone.tree.api.dto;

import com.samal.greenstone.tree.domain.Note;
import com.samal.greenstone.tree.domain.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class NoteMapperTest {
    NoteMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(NoteMapper.class);
    }


    @Test
    void dtoToEntity() {
        NoteDto noteDto = new NoteDto();
        long noteId = 1L;
        noteDto.setId(noteId);
        Operation operation = Operation.POST;
        noteDto.setOperation(operation);

        Note note = mapper.dtoToEntity(noteDto);

        assertThat(note.getId()).isEqualTo(noteId);
        assertThat(note.getOperation()).isEqualTo(operation);
    }

    @Test
    void entityToDto() {
        Note note = new Note();
        long noteId = 1L;
        note.setId(noteId);
        Operation operation = Operation.POST;
        note.setOperation(operation);

        NoteDto noteDto = mapper.entityToDto(note);

        assertThat(noteDto.getId()).isEqualTo(noteId);
        assertThat(noteDto.getOperation()).isEqualTo(operation);
    }
}