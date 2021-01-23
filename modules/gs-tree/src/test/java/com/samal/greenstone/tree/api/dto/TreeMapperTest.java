package com.samal.greenstone.tree.api.dto;

import com.samal.greenstone.tree.api.FieldTooLongException;
import com.samal.greenstone.tree.api.FieldTooShortException;
import com.samal.greenstone.tree.domain.Note;
import com.samal.greenstone.tree.domain.Operation;
import com.samal.greenstone.tree.domain.Tree;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(classes = {TreeMapperImpl.class, CaseConverter.class})
class TreeMapperTest {
    @Autowired
    TreeMapper mapper;

    @Nested
    class dtoToEntity {

        @Test
        void dtoToEntity() {
            Long treeId = 1L;
            String desc = "Desc";
            TreeDto treeDto = new TreeDto();
            treeDto.setId(treeId);
            treeDto.setDesc(desc);
            treeDto.setLowerCaseDesc("Ff");
            treeDto.setUpperCaseDesc("Ff");
            NoteDto noteDto = new NoteDto();
            long noteId = 2L;
            noteDto.setId(noteId);
            Operation operation = Operation.POST;
            noteDto.setOperation(operation);
            treeDto.setNotes(Collections.singletonList(noteDto));

            Tree tree = mapper.dtoToEntity(treeDto);

            assertThat(tree.getId()).isEqualTo(treeId);
            assertThat(tree.getDescription()).isEqualTo(desc);
            assertThat(tree.getLowerCaseDesc()).isEqualTo("ff");
            assertThat(tree.getUpperCaseDesc()).isEqualTo("FF");
            assertThat(tree.getNotes()).anyMatch(note -> note.getId() == noteId);
        }

        @Test
        void dtoToEntity_tooShort() {
            Long treeId = 1L;
            String desc = "1";
            TreeDto treeDto = new TreeDto();
            treeDto.setId(treeId);
            treeDto.setDesc(desc);
            treeDto.setLowerCaseDesc("Ff");
            treeDto.setUpperCaseDesc("Ff");
            NoteDto noteDto = new NoteDto();
            long noteId = 2L;
            noteDto.setId(noteId);
            Operation operation = Operation.POST;
            noteDto.setOperation(operation);
            treeDto.setNotes(Collections.singletonList(noteDto));

            FieldTooShortException ex = assertThrows(FieldTooShortException.class, () -> mapper.dtoToEntity(treeDto));
            assertEquals("Description length should be more than 2", ex.getMessage());
        }

        @Test
        void dtoToEntity_tooLong() {
            Long treeId = 1L;
            String desc = "1234567890";
            TreeDto treeDto = new TreeDto();
            treeDto.setId(treeId);
            treeDto.setDesc(desc);
            treeDto.setLowerCaseDesc("Ff");
            treeDto.setUpperCaseDesc("Ff");
            NoteDto noteDto = new NoteDto();
            long noteId = 2L;
            noteDto.setId(noteId);
            Operation operation = Operation.POST;
            noteDto.setOperation(operation);
            treeDto.setNotes(Collections.singletonList(noteDto));

            FieldTooLongException ex = assertThrows(FieldTooLongException.class, () -> mapper.dtoToEntity(treeDto));
            assertEquals("Description length should be less than 7", ex.getMessage());
        }
    }

    @Nested
    class entityToDto {

        @Test
        void entityToDto() {
            Long treeId = 1L;
            String desc = "Desc";
            Tree tree = new Tree();
            tree.setId(treeId);
            tree.setDescription(desc);
            tree.setLowerCaseDesc("Ff");
            tree.setUpperCaseDesc("Ff");
            Note note = new Note();
            long noteId = 2L;
            note.setId(noteId);
            Operation operation = Operation.POST;
            note.setOperation(operation);
            tree.setNotes(Collections.singletonList(note));

            TreeDto treeDto = mapper.entityToDto(tree);

            assertThat(treeDto.getId()).isEqualTo(treeId);
            assertThat(treeDto.getDesc()).isEqualTo(desc);
            assertThat(tree.getLowerCaseDesc()).isEqualTo("Ff");
            assertThat(tree.getUpperCaseDesc()).isEqualTo("Ff");
            assertThat(treeDto.getNotes()).anyMatch(noteDto -> noteDto.getId() == noteId);
        }


        @Test
        void entityToDto_tooShort() {
            Long treeId = 1L;
            String desc = "1";
            Tree tree = new Tree();
            tree.setId(treeId);
            tree.setDescription(desc);
            tree.setLowerCaseDesc("Ff");
            tree.setUpperCaseDesc("Ff");
            Note note = new Note();
            long noteId = 2L;
            note.setId(noteId);
            Operation operation = Operation.POST;
            note.setOperation(operation);
            tree.setNotes(Collections.singletonList(note));

            FieldTooShortException ex = assertThrows(FieldTooShortException.class, () -> mapper.entityToDto(tree));
            assertEquals("Description length should be more than 2", ex.getMessage());
        }

        @Test
        void entityToDto_tooLong() {
            Long treeId = 1L;
            String desc = "1234567890";
            Tree tree = new Tree();
            tree.setId(treeId);
            tree.setDescription(desc);
            tree.setLowerCaseDesc("Ff");
            tree.setUpperCaseDesc("Ff");
            Note note = new Note();
            long noteId = 2L;
            note.setId(noteId);
            Operation operation = Operation.POST;
            note.setOperation(operation);
            tree.setNotes(Collections.singletonList(note));

            FieldTooLongException ex = assertThrows(FieldTooLongException.class, () -> mapper.entityToDto(tree));
            assertEquals("Description length should be less than 7", ex.getMessage());
        }
    }
}
