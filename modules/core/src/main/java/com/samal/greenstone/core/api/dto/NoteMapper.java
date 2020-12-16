package com.samal.greenstone.core.api.dto;

import com.samal.greenstone.core.domain.Note;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note dtoToEntity(NoteDto dto);

    NoteDto entityToDto(Note entity);
}
