package com.samal.greenstone.core.api.dto;

import com.samal.greenstone.core.domain.Note;
import com.samal.greenstone.core.domain.Operation;
import com.samal.greenstone.core.domain.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class TreeMapperTest {
    TreeMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = Mappers.getMapper(TreeMapper.class);
    }

    @Test
    void dtoToEntity() {
        Long treeId = 1L;
        String desc = "Desc";
        TreeDto treeDto = new TreeDto();
        treeDto.setId(treeId);
        treeDto.setDesc(desc);
        NoteDto noteDto = new NoteDto();
        long noteId = 2L;
        noteDto.setId(noteId);
        Operation operation = Operation.POST;
        noteDto.setOperation(operation);
        treeDto.setNotes(Collections.singletonList(noteDto));

        Tree tree = mapper.dtoToEntity(treeDto);

        assertThat(tree.getId()).isEqualTo(treeId);
        assertThat(tree.getDescription()).isEqualTo(desc);
        assertThat(tree.getNotes()).anyMatch(note -> note.getId() == noteId);
    }

    @Test
    void entityToDto() {
        Long treeId = 1L;
        String desc = "Desc";
        Tree tree = new Tree();
        tree.setId(treeId);
        tree.setDescription(desc);
        Note note = new Note();
        long noteId = 2L;
        note.setId(noteId);
        Operation operation = Operation.POST;
        note.setOperation(operation);
        tree.setNotes(Collections.singletonList(note));

        TreeDto treeDto = mapper.entityToDto(tree);

        assertThat(treeDto.getId()).isEqualTo(treeId);
        assertThat(treeDto.getDesc()).isEqualTo(desc);
        assertThat(treeDto.getNotes()).anyMatch(noteDto -> noteDto.getId() == noteId);
    }
}
