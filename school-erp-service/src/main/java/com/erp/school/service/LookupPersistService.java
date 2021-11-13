package com.erp.school.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.erp.school.lov.entity.LovDiscipline;
import com.erp.school.lov.entity.LovInstitutionType;
import com.erp.school.lov.entity.LovUserType;
import com.erp.school.lov.entity.Weekdays;
import com.etpl.common.exception.DAOPersistanceException;

@Transactional
@Service
public class LookupPersistService {

	@PersistenceContext
	private EntityManager emBean;

	public void newInstitutionType(LovInstitutionType reqObj) {
		try {
			emBean.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateInstitutionType(LovInstitutionType reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void newUserType(LovUserType reqObj) {
		try {
			emBean.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateUserType(LovUserType reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void newDiscipline(LovDiscipline reqObj) {
		try {
			emBean.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateDiscipline(LovDiscipline reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void newWeekdays(Weekdays reqObj) {
		try {
			emBean.persist(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}

	public void updateWeekdays(Weekdays reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
}
