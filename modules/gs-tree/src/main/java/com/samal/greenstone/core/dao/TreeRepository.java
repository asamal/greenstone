package com.samal.greenstone.core.dao;

import com.samal.greenstone.core.domain.Tree;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TreeRepository extends PagingAndSortingRepository<Tree, Long> {
}
