package com.samal.greenstone.tree.service;

import com.samal.greenstone.tree.domain.Tree;

import java.util.Optional;

public interface TreeService {
    Optional<Tree> findById(Long id);

    Tree save(Tree tree);

    Iterable<Tree> findAll();
}
