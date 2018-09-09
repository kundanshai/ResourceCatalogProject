package com.equant.flip.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.equant.flip.dao.ResourceCatalogDao;
import com.equant.flip.entity.ResourceCatalogDetails;

@RestController
//@RequestMapping("/resourceCatalog/{resourceCatalogId}")
public class ResourceCatalog {

	@Autowired
	ResourceCatalogDao resourceCatalogDao;
	
@GetMapping("/resourceCatalog/{resourceCatalogId}")
public ResponseEntity <List<ResourceCatalogDetails>> getAllPartDetails(@PathVariable String resourceCatalogId,
		@QueryParam("revision") String revision) {
	List<ResourceCatalogDetails> detailsList=resourceCatalogDao.getResourceCatalogDetails(resourceCatalogId, revision);
	/*List<ResourceCatalogDetails> detailsList=new ArrayList();
	ResourceCatalogDetails resourceCatalogDetails=new ResourceCatalogDetails();
	resourceCatalogDetails.setObjId(resourceCatalogId);
	resourceCatalogDetails.setPartNum("Abc123");
	resourceCatalogDetails.setRevision("index!@#");*/
	
	//detailsList.add(resourceCatalogDetails);
	return ResponseEntity.ok().body(detailsList);
}
}
