package com.samal.greenstone.tree.api.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@NoArgsConstructor
@Getter
@Setter
public class TreeDto {
    private long id;
    @NotEmpty
    private String desc;
    private Collection<NoteDto> notes;
    private String upperCaseDesc;
    private String lowerCaseDesc;
}
