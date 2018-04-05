package de.michlb.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="apparel_sku")
public class ApparelSku extends ResourceSupport {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")
	 private Long skuId;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "APPAREL_ID", nullable = false)
	 @JsonIgnore
	 private Apparel apparel;
	 
	 @Column(name="ATTRIBUTES")
	 private String attributes;

	public ApparelSku(String attributes , Apparel apparel) {
		this.attributes = attributes;
		this.apparel = apparel;
	}
	
	public ApparelSku()
	{
		
	}

	

	public Apparel getApparel() {
		return apparel;
	}

	public void setApparel(Apparel apparel) {
		this.apparel = apparel;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public Long getSkuId() {
		return skuId;
	}

	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}

}	
