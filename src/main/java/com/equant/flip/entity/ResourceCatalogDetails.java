package com.equant.flip.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="resource_catalog_details")
@NamedNativeQuery(
		 name="query_find_all_users", 
		 query = "select obj_id, part_num, revision from resource_catalog_details where obj_id=:obj_id", 
		 resultClass = ResourceCatalogDetails.class)

//@NamedQuery(query = "select u.objId,u.partNum from ResourceCatalogDetails u", name = "query_find_all_users")
public class ResourceCatalogDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "obj_Id", updatable = false, nullable = false)
	public String objId;
	@Column(name = "part_Num")
	public String partNum;
	
	public String revision;
	
	@OneToMany(targetEntity=ResourcePrice.class,cascade=CascadeType.ALL)
	List<ResourcePrice> resourcePrice;
	//@JoinColumn(name="details_id",referencedColumnName="objId")
	
	public String getObjId() {
		return objId;
	}
	public void setObjId(String objId) {
		this.objId = objId;
	}
	public String getPartNum() {
		return partNum;
	}
	public void setPartNum(String partNum) {
		this.partNum = partNum;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public List<ResourcePrice> getResourcePrice() {
		return resourcePrice;
	}
	public void setResourcePrice(List<ResourcePrice> resourcePrice) {
		this.resourcePrice = resourcePrice;
	}
	

}
