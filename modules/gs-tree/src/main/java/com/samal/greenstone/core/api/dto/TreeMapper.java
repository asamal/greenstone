package com.samal.greenstone.core.api.dto;

import com.samal.greenstone.core.domain.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CaseConverter.class}, imports = {StringChecker.class})
public interface TreeMapper {
    @Mappings({
            @Mapping(target = "description",
                    expression = "java(StringChecker.withLengthLimit(dto.getDesc(), \"Description\", 2, 7))"),
            @Mapping(target = "lowerCaseDesc", qualifiedBy = LowerCase.class),
            @Mapping(target = "upperCaseDesc", qualifiedBy = UpperCase.class)
    })
    Tree dtoToEntity(TreeDto dto);

    @Mappings({
            @Mapping(target = "desc", expression = "java(StringChecker.withLengthLimit(entity.getDescription(), \"Description\", 2, 7))")
    })
    TreeDto entityToDto(Tree entity);
}
