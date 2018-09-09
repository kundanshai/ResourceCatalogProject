package com.equant.flip.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.equant.flip.dao.ResourceCatalogDao;
import com.equant.flip.entity.ResourceCatalogDetails;
import com.equant.flip.entity.ResourcePrice;
import com.equant.flip.repository.ResourceCatalogRepository;

@Service
@Repository
public class ResourceCatalogImpl implements ResourceCatalogDao {

	@Autowired
	EntityManager entityManager;
	@Autowired
	ResourceCatalogRepository resourceCatalogRepository;

	
	@Override
	public List<ResourceCatalogDetails> getResourceCatalogDetails(String resourceCatalogId, String revision) {
		List<ResourceCatalogDetails> list12=null;
		//List simp=new ArrayList();
		//List<Object[]> listt=new ArrayList();
		List<ResourceCatalogDetails> listSet=new ArrayList();
		TypedQuery<ResourceCatalogDetails> query = entityManager.createNamedQuery("query_find_all_users",ResourceCatalogDetails.class).setParameter("obj_id", resourceCatalogId);
				//.createQuery("select objId, partNum, revision from ResourceCatalogDetails where partNum=:partNum")
				//.setParameter("partNum", resourceCatalogId);		
			//Query query=entityManager.createQuery("select objId, partNum from ResourceCatalogDetails");
	
			 /*listt = query.getResultList();
				for(Object[] list1:listt)
				{
					//ResourceCatalogDetails resourceCatalogDetails=new ResourceCatalogDetails();
					simp.add(list1[0]);
					simp.add(list1[1]);
				}*/
		
		list12= query.getResultList();
		//list12 = resourceCatalogRepository.getResourceCatalogDetails();
		List<ResourcePrice> priceList=new ArrayList();
		for(ResourceCatalogDetails ss:list12)
		{
			
			ResourceCatalogDetails resourceCatalogDetails=new ResourceCatalogDetails();
			resourceCatalogDetails.setObjId(ss.getObjId());
			resourceCatalogDetails.setPartNum(ss.getPartNum());
			//resourceCatalogDetails.setRevision(ss.getRevision());
			//for(ResourcePrice price:ss.getResourcePrice())
			
				ResourcePrice pricee=new ResourcePrice();
				pricee.setPriceRate("56");
				pricee.setPriceRevision("kun");
				priceList.add(pricee);
			
			resourceCatalogDetails.setResourcePrice(priceList);
			listSet.add(resourceCatalogDetails);
		}
		
		return listSet;
	}

}
