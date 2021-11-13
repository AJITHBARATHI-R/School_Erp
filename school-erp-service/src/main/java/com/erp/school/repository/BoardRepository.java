package com.erp.school.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.erp.school.entity.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

	Board findById(long disciplineId);

	List<Board> findByRefInstId(long refInstId);

}
