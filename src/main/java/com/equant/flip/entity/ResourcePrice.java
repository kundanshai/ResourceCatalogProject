package com.equant.flip.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ResourcePrice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "price_Id", updatable = false, nullable = false)
	public String priceId;
	@Column(name = "price_rate")
	public String priceRate;
	@Column(name = "price_revision")
	public String priceRevision;
	@ManyToOne
	@JoinColumn(name="resourceCatalogDetails_id")
	ResourceCatalogDetails resourceCatalogDetails;
	
	public String getPriceId() {
		return priceId;
	}
	public void setPriceId(String priceId) {
		this.priceId = priceId;
	}
	public String getPriceRate() {
		return priceRate;
	}
	public void setPriceRate(String priceRate) {
		this.priceRate = priceRate;
	}
	public String getPriceRevision() {
		return priceRevision;
	}
	public void setPriceRevision(String priceRevision) {
		this.priceRevision = priceRevision;
	}
	
	
}
