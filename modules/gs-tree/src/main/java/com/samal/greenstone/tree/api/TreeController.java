package com.samal.greenstone.tree.api;

import com.samal.greenstone.tree.api.dto.TreeDto;
import com.samal.greenstone.tree.api.dto.TreeMapper;
import com.samal.greenstone.tree.domain.Tree;
import com.samal.greenstone.tree.service.TreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/trees", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class TreeController {
    private final TreeService treeService;
    private final TreeMapper treeMapper;

    public TreeController(TreeService service, TreeMapper treeMapper) {
        this.treeService = service;
        this.treeMapper = treeMapper;
    }

    @GetMapping(value = "/{id}")
    public TreeDto findOne(@PathVariable Long id) {
        Tree tree = treeService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return treeMapper.entityToDto(tree);
    }

    @PutMapping
    public TreeDto create(@RequestBody @Valid TreeDto treeDto) {
        Tree tree = treeService.save(treeMapper.dtoToEntity(treeDto));
        return treeMapper.entityToDto(tree);
    }

    @GetMapping
    public Collection<TreeDto> findAll() {
        Iterable<Tree> trees = this.treeService.findAll();
        List<TreeDto> treeDtos = new ArrayList<>();
        trees.forEach(p -> treeDtos.add(treeMapper.entityToDto(p)));
        return treeDtos;
    }

}
