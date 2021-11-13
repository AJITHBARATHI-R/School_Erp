package com.erp.location.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.erp.location.entity.Cities;
import com.erp.location.entity.Countries;
import com.erp.location.entity.States;
import com.etpl.common.exception.DAOPersistanceException;

@Transactional
@Service
public class LocationService {

	@PersistenceContext
	private EntityManager emBean;

	public Countries newCountry(Countries reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
	
	public void updateCountries(Countries reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
	
	public States newState(States reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
	
	public void updateStates(States reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
	
	public Cities newCities(Cities reqObj) {
		try {
			emBean.persist(reqObj);
			return reqObj;
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
	
	public void updateCities(Cities reqObj) {
		try {
			emBean.merge(reqObj);
		} catch (Exception e) {
			throw new DAOPersistanceException(e.getMessage(), e.getCause());
		}
	}
}
