package com.techincaltest.ecommerce.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="merchandise")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MerchandiseModel {
	@Id
	@SequenceGenerator(
            name = "merchandise_id_sequence",
            sequenceName = "merchandise_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "merchandise_id_sequence"
    )
	@Column(name="merchandise_id")
	private long merchandiseId;
	
	@Column(name="merchandise_name")
	private String merchandiseName;
	
	@Column(name="merchandise_description")
	private String merchandiseDescription;
	
	@Column(name="merchandise_price")
	private double merchandisePrice;
	
	@Column(name="merchandise_image")
	private String merchandiseImage;
	
	public MerchandiseModel() {
	}

	public MerchandiseModel(String merchandiseName, String merchandiseDescription, double merchandisePrice, String merchandiseImage) {
		super();
		this.merchandiseName = merchandiseName;
		this.merchandiseDescription = merchandiseDescription;
		this.merchandisePrice = merchandisePrice;
		this.merchandiseImage = merchandiseImage;
	}

	public long getMerchandiseId() {
		return merchandiseId;
	}

	public void setMerchandiseId(long merchandiseId) {
		this.merchandiseId = merchandiseId;
	}

	public String getMerchandiseName() {
		return merchandiseName;
	}

	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}

	public String getMerchandiseDescription() {
		return merchandiseDescription;
	}

	public void setMerchandiseDescription(String merchandiseDescription) {
		this.merchandiseDescription = merchandiseDescription;
	}

	public double getMerchandisePrice() {
		return merchandisePrice;
	}

	public void setMerchandisePrice(double merchandisePrice) {
		this.merchandisePrice = merchandisePrice;
	}

	public String getMerchandiseImage() {
		return merchandiseImage;
	}

	public void setMerchandiseImage(String merchandiseImage) {
		this.merchandiseImage = merchandiseImage;
	}
}
