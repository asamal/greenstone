package com.samal.greenstone.core.service;

import com.samal.greenstone.core.domain.Tree;

import java.util.Optional;

public interface TreeService {
    Optional<Tree> findById(Long id);

    Tree save(Tree tree);

    Iterable<Tree> findAll();
}
