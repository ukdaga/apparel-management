package de.michlb.sample.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.michlb.sample.domain.Apparel;
import de.michlb.sample.domain.ApparelSku;
import de.michlb.sample.repositories.ApparelRepository;
import de.michlb.sample.service.ApparelService;

@RestController
public class ApparelController {
	
	@Autowired
	ApparelService apparelService;
	
	@RequestMapping(value = "apparels" , method = RequestMethod.GET)
	@ResponseBody
	public List<Apparel> getApparelList()
	{
		return apparelService.findAllApparel();
	}
	
	@RequestMapping(value = "apparels" , method = RequestMethod.POST)
	@ResponseBody
	public String addApparel(@RequestBody Apparel apparel)
	{
		apparelService.addApparel(apparel);
		return "Apparel added Successfully";
	}
	
	@RequestMapping(value = "apparels/{apparelId}" , method = RequestMethod.GET)
	@ResponseBody
	public Apparel getApparelDetails(@PathVariable String apparelId)
	{
/*		 EntityTag etag = new EntityTag(UserDatabase.getLastModifiedById(id).hashCode()+"");*/
		return apparelService.findApparelById(apparelId);
	}
	
	@RequestMapping(value = "apparels/{apparelId}" , method = RequestMethod.PUT)
	@ResponseBody
	public String updateApparelDetails(@PathVariable String apparelId, @RequestBody Apparel newApparelDetails)
	{
		 apparelService.updateApparel(newApparelDetails, apparelId);
		 return "apparel successfully updated";
	}
	
	@RequestMapping(value = "apparels/{apparelId}" , method = RequestMethod.DELETE)
	@ResponseBody
	public String removeApparel(@PathVariable String apparelId)
	{
		return apparelService.deleteApparelById(apparelId);
	}
	
	@RequestMapping(value = "apparels/{apparelId}/skus" , method = RequestMethod.GET)
	@ResponseBody
	public Set<ApparelSku> getApparelSkuList(@PathVariable String apparelId)
	{
		return apparelService.getApparelSkuList(apparelId);
	}
	
	@RequestMapping(value = "apparels/{apparelId}/skus" , method = RequestMethod.POST)
	@ResponseBody
	public CharSequence addSku(@RequestBody String attributes , @PathVariable String apparelId)
	{
		return apparelService.addSku(attributes, apparelId);
	}
	
	
	@RequestMapping(value = "apparels/{apparelId}/skus/{skuId}" , method = RequestMethod.GET)
	@ResponseBody
	public ApparelSku getApparelSkuDetails(@PathVariable String apparelId, @PathVariable String skuId)
	{
		return apparelService.findApparelSkuById(skuId);
	}
	
	@RequestMapping(value = "apparels/{apparelId}/skus/{skuId}" , method = RequestMethod.PUT)
	@ResponseBody
	public String updateApparelSkuDetails(@PathVariable String skuId, @RequestBody ApparelSku newApparelSkuDetails)
	{
		 apparelService.updateApparelSku(newApparelSkuDetails, skuId);
		 return "apparel sku successfully updated";
	}
	
	@RequestMapping(value = "apparels/{apparelId}/skus/{skuId}" , method = RequestMethod.DELETE)
	@ResponseBody
	public String removeApparelSku(@PathVariable String apparelId, @PathVariable String skuId)
	{
		return apparelService.deleteApparelSkuById(skuId);
	}

	
}
