package com.thoughtworks.rslist.repository;

import com.thoughtworks.rslist.dto.RsEventDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RsEventRepository extends CrudRepository<RsEventDto, Integer> {
    @Override
    @Query(value = "select * from rs_event order by voteNum desc ",nativeQuery = true)
    List<RsEventDto> findAll();

    @Transactional
    void deleteAllByUserId(int userId);

    @Transactional
    @Modifying
    @Query(value = "update rs_event set rank =:rank where id =:id",nativeQuery = true)
    void updateById(int id,int rank);
}
