package com.samal.greenstone.tree.dao;

import com.samal.greenstone.tree.domain.Tree;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TreeRepository extends PagingAndSortingRepository<Tree, Long>, CrudRepository<Tree, Long> {
}
