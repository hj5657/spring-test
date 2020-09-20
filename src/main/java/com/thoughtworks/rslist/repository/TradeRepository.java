package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.dto.TradeDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Create by 木水 on 2020/9/20.
 */
public interface TradeRepository extends CrudRepository<TradeDto,Integer> {
    @Query(value = "select * from trade where rank =:rank order by amount desc ;",nativeQuery = true)
    List<TradeDto> findByRank(int rank);
}
