package com.samal.greenstone.core.api.dto;

import com.samal.greenstone.core.domain.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {CaseConverter.class})
public interface TreeMapper {
    @Mappings({
            @Mapping(target = "description", source = "desc"),
            @Mapping(target = "lowerCaseDesc", qualifiedBy = LowerCase.class),
            @Mapping(target = "upperCaseDesc", qualifiedBy = UpperCase.class)
    })
    Tree dtoToEntity(TreeDto dto);

    @Mappings({
            @Mapping(target = "desc", source = "description")
    })
    TreeDto entityToDto(Tree entity);
}
