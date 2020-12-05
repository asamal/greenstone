package com.samal.greenstone.core.api;

import com.samal.greenstone.core.domain.Tree;
import com.samal.greenstone.core.service.TreeService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/trees", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
public class TreeController {
    private final TreeService treeService;

    public TreeController(TreeService service) {
        this.treeService = service;
    }

    @GetMapping(value = "/{id}")
    public TreeDto findOne(@PathVariable Long id) {
        Tree entity = treeService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @PutMapping
    public TreeDto create(@RequestBody @Valid TreeDto treeDto) {
        Tree entity = treeService.save(convertToEntity(treeDto));
        return convertToDto(entity);
    }

    @GetMapping
    public Collection<TreeDto> findAll() {
        Iterable<Tree> foos = this.treeService.findAll();
        List<TreeDto> treeDtos = new ArrayList<>();
        foos.forEach(p -> treeDtos.add(convertToDto(p)));
        return treeDtos;
    }

    protected TreeDto convertToDto(Tree entity) {
        TreeDto dto = new TreeDto(entity.getId(), entity.getDesc());
        return dto;
    }

    protected Tree convertToEntity(TreeDto dto) {
        Tree tree = new Tree(dto.getId(), dto.getDesc());
        return tree;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class TreeDto {

        private long id;
        @NotEmpty
        private String desc;
    }
}
