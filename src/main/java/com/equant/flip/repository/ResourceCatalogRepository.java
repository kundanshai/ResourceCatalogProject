package com.equant.flip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.equant.flip.entity.ResourceCatalogDetails;



public interface ResourceCatalogRepository extends CrudRepository<ResourceCatalogDetails,Integer>{
	   @Query("select u.objId,u.partNum from ResourceCatalogDetails u" )
	public List<ResourceCatalogDetails> getResourceCatalogDetails();

}
