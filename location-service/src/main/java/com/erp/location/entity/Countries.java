package com.erp.location.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.location.TableLogger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "countries")
@Getter
@Setter
@NoArgsConstructor
public class Countries extends TableLogger implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "iso3")
	private String iso3;
	
	@Column(name = "numeric_code")
	private String numericCode;
	
	@Column(name = "iso2")
	private String iso2;
	
	@Column(name = "phonecode")
	private String phonecode;
	
	@Column(name = "capital")
	private String capital;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name = "currency_symbol")
	private String currencySymbol;
	
	@Column(name = "tld")
	private String tld;
	
	@Column(name = "native")
	private String native_path;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "subregion")
	private String subregion;
	
	@Column(name = "timezones")
	private String timezones;
	
	@Column(name = "translations")
	private String translations;
	
	@Column(name = "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "emoji")
	private String emoji;
	
	@Column(name = "emojiu")
	private String emojiu;
	
	@Column(name = "wikidataid")
	private String wikidataid;
	
	

}
