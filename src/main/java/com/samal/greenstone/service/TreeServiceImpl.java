package com.samal.greenstone.service;

import com.samal.greenstone.dao.TreeRepository;
import com.samal.greenstone.domain.Tree;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TreeServiceImpl implements TreeService {
    private final TreeRepository treeRepository;

    public TreeServiceImpl(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public Optional<Tree> findById(Long id) {
        return treeRepository.findById(id);
    }

    @Override
    public Tree save(Tree tree) {
        return treeRepository.save(tree);
    }

    @Override
    public Iterable<Tree> findAll() {
        return treeRepository.findAll();
    }
}
