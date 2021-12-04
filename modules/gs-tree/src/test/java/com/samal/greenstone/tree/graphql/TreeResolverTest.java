package com.samal.greenstone.tree.graphql;

import com.samal.greenstone.tree.domain.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeResolverTest {
    @Test
    void tree() {
        long id = 1L;
        Tree tree = new TreeResolver().tree(id);
        assertEquals(id, tree.getId());
        assertEquals("Mock tree", tree.getDescription());
    }
}