package com.samal.greenstone.tree.api.dto;

import com.samal.greenstone.tree.domain.Operation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NoteDto {
    private Long id;
    private Operation operation;
}
