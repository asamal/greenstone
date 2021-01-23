package com.samal.greenstone.tree.api.dto;

import com.samal.greenstone.tree.domain.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note dtoToEntity(NoteDto dto);

    NoteDto entityToDto(Note entity);
}
