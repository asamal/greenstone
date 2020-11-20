package com.samal.greenstone.service;

import com.samal.greenstone.domain.Tree;

import java.util.Optional;

public interface TreeService {
    Optional<Tree> findById(Long id);

    Tree save(Tree tree);

    Iterable<Tree> findAll();
}
