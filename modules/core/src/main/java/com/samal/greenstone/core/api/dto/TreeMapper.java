package com.samal.greenstone.core.api.dto;

import com.samal.greenstone.core.domain.Tree;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TreeMapper {
    @Mappings({
            @Mapping(target = "description", source = "desc")
    })
    Tree dtoToEntity(TreeDto dto);

    @Mappings({
            @Mapping(target = "desc", source = "description")
    })
    TreeDto entityToDto(Tree entity);
}
