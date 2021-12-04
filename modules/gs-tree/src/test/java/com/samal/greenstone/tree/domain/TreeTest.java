package com.samal.greenstone.tree.domain;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TreeTest {

    @Test
    void builder() {
        long id = 1L;
        String description = "description";
        String lowerCaseDesc = "lowerCaseDesc";
        String upperCaseDesc = "upperCaseDesc";
        UUID uuid = UUID.randomUUID();

        Tree tree = Tree.builder()
                .id(id)
                .description(description)
                .lowerCaseDesc(lowerCaseDesc)
                .upperCaseDesc(upperCaseDesc)
                .uuid(uuid)
                .build();

        assertEquals(id, tree.getId());
        assertEquals(description, tree.getDescription());
        assertEquals(lowerCaseDesc, tree.getLowerCaseDesc());
        assertEquals(upperCaseDesc, tree.getUpperCaseDesc());
        assertEquals(uuid, tree.getUuid());
    }
}