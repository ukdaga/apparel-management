package org.ukdaga.urlshortener.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;
import org.ukdaga.urlshortener.controller.ApparelController;
import org.ukdaga.urlshortener.domain.Apparel;
import org.ukdaga.urlshortener.domain.ApparelSku;
import org.ukdaga.urlshortener.repository.ApparelRepository;
import org.ukdaga.urlshortener.repository.ApparelSkuRepository;


@Service
@EnableJpaRepositories
public class ApparelService {
	
	@Autowired
	ApparelRepository apparelRepository;
	
	@Autowired
	ApparelSkuRepository apparelSkuRepository;
	
	public void addApparel(Apparel apparel)
	{
		Apparel entity = apparelRepository.saveAndFlush(apparel);
	}
	
	public void updateApparel(Apparel newApparel, String apparelId)
	{
		Apparel savedEntity = apparelRepository.findOne(Long.parseLong(apparelId));
		savedEntity.setApparelType(newApparel.getApparelType());
		savedEntity.setRefName(newApparel.getRefName());
		savedEntity.setType(newApparel.getType());
		apparelRepository.saveAndFlush(savedEntity);
	}
	
	public List<Apparel> findAllApparel()
	{
		List<Apparel> apparelList=  apparelRepository.findAll();
		if (apparelList == null || apparelList.size()==0)
			return null;
		for (Apparel apparel : apparelList)
		{
			prepareApparelLinks(apparel);
		}
		return apparelList;
	}
	
	public Apparel findApparelById(String apparelId)
	{
		Apparel apparel = apparelRepository.findOne(Long.parseLong(apparelId));
			if(apparel==null)
				return null;
		prepareApparelLinks(apparel);
		return apparel;
	}
	
	public String deleteApparelById(String apparelId)
	{
		apparelRepository.delete(Long.parseLong(apparelId));
		return "apparel successfully deleted";
		
	}
	
	public String addSku(String attributes, String apparelId) {
		Apparel apparelEntity = apparelRepository.findOne(Long.parseLong(apparelId));
		if(apparelEntity==null)
		{
			return "Apparel Resource Not found";
		}
		ApparelSku apparelSku = new ApparelSku(attributes , apparelEntity);
		apparelSku.setApparel(apparelEntity);
		apparelEntity.getApparelsku().add(apparelSku);
		apparelSkuRepository.save(apparelSku);
		apparelEntity = apparelRepository.saveAndFlush(apparelEntity);
		return "Apparel sku added successfully";
	}
	
	public void updateApparelSku(ApparelSku newApparelSku, String apparelIdSkuId)
	{
		ApparelSku savedEntity = apparelSkuRepository.findOne(Long.parseLong(apparelIdSkuId));
		savedEntity.setAttributes(newApparelSku.getAttributes());
		apparelSkuRepository.saveAndFlush(savedEntity);
	}
	
	public ApparelSku findApparelSkuById(String apparelSkuId)
	{
		ApparelSku apparelSku = apparelSkuRepository.findOne(Long.parseLong(apparelSkuId));
		if(apparelSku == null)
			return null;
		prepareApparelSkuLinks(apparelSku.getApparel().getApparelId().toString(), apparelSku);
		return apparelSku;
	}
	
	public String deleteApparelSkuById(String apparelSkuId)
	{
		apparelSkuRepository.delete(Long.parseLong(apparelSkuId));
		return "apparel sku successfully deleted";
		
	}
	
	public Set<ApparelSku> getApparelSkuList(String apparelId) {
		Apparel entity = apparelRepository.findOne(Long.parseLong(apparelId));
		
		if (entity.getApparelsku() == null || entity.getApparelsku().size()==0)
			return null;
		for (ApparelSku apparelSku : entity.getApparelsku())
		{
			prepareApparelSkuLinks(apparelId, apparelSku);
		}
		return entity.getApparelsku();
	}
	
	private void prepareApparelLinks(Apparel apparel) {
		Apparel selfLinkBuilder = 
				  ControllerLinkBuilder.methodOn(ApparelController.class).getApparelDetails(apparel.getApparelId().toString());
		        Link selfLink = ControllerLinkBuilder.linkTo(selfLinkBuilder).withRel("view | update | delete apparel");
		apparel.add(selfLink);
		
		CharSequence addSkuBuilder = 
				  ControllerLinkBuilder.methodOn(ApparelController.class).addSku("dummy attribute", apparel.getApparelId().toString());
		        Link addSkuLink = ControllerLinkBuilder.linkTo(addSkuBuilder).withRel("Add sku [POST]");
		apparel.add(addSkuLink);
		  
		  if(apparel.getApparelsku().size()>0)
		  {
			  Set<ApparelSku> methodLinkBuilder = 
					  ControllerLinkBuilder.methodOn(ApparelController.class).getApparelSkuList(apparel.getApparelId().toString());
		            Link skusLink = ControllerLinkBuilder.linkTo(methodLinkBuilder).withRel("list Skus");
		            apparel.add(skusLink);
		  }
	}
	
	private void prepareApparelSkuLinks(String apparelId, ApparelSku apparelSku) {
		ApparelSku selfLinkBuilder = 
				  ControllerLinkBuilder.methodOn(ApparelController.class).getApparelSkuDetails(apparelId, apparelSku.getSkuId().toString() );
		        Link selfLink = ControllerLinkBuilder.linkTo(selfLinkBuilder).withRel(" view | update | delete sku");
		        apparelSku.add(selfLink);
		
		    
	}

}
