package com.samal.greenstone.tree.graphql;

import com.samal.greenstone.tree.domain.Tree;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TreeResolver implements GraphQLQueryResolver {
    public Tree tree(long id) {
        log.info("Retrieving Tree by id: {}", id);
        return Tree.builder().id(id).description("Mock tree").build();
    }
}
