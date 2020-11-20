package com.samal.greenstone.dao;

import com.samal.greenstone.domain.Tree;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TreeRepository extends PagingAndSortingRepository<Tree, Long> {
}
