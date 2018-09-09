package com.equant.flip.dao;

import java.util.List;

import com.equant.flip.entity.ResourceCatalogDetails;

public interface ResourceCatalogDao {
	public List<ResourceCatalogDetails> getResourceCatalogDetails(String resourceCatalogId,String revision);

}
