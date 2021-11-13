package com.erp.school.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.school.lov.repository.DisciplineRepository;
import com.erp.school.lov.repository.InstitutionTypeRepository;
import com.erp.school.lov.repository.UserTypeRepository;
import com.erp.school.repository.WeekdaysRepository;
import com.etpl.common.exception.RecordNotFoundException;

@Transactional
@Service
public class LookupViewService {
	
	@Autowired
	private InstitutionTypeRepository instTypeRepo;
	
	@Autowired
	private UserTypeRepository userTypeRepo;
	
	@Autowired
	private DisciplineRepository disciplineRepo;
	
	@Autowired
	private WeekdaysRepository weekdaysRepo;

	public List<?> getAllInstitutionTypes() {
		return  (List<?>) Optional.ofNullable(instTypeRepo.findAll())
				.orElseThrow(() -> new RecordNotFoundException("No records found!"));
	}

	public List<?> getAllUserTypes() {
		return  (List<?>) Optional.ofNullable(userTypeRepo.findAll())
				.orElseThrow(() -> new RecordNotFoundException("No records found!"));
	}
	
	public List<?> getAllDiscipline() {
		return  (List<?>) Optional.ofNullable(disciplineRepo.findAll())
				.orElseThrow(() -> new RecordNotFoundException("No records found!"));
	}

	public List<?> getAllWeekdays() {
		return  (List<?>) Optional.ofNullable(weekdaysRepo.findAllDays())
				.orElseThrow(() -> new RecordNotFoundException("No records found!"));
	}

}
