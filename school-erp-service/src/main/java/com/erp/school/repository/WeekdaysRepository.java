package com.erp.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.erp.school.lov.entity.Weekdays;

public interface WeekdaysRepository extends CrudRepository<Weekdays, Long> {

	@Query("select w from Weekdays w order by daysOrder")
	List<Weekdays> findAllDays();

}
