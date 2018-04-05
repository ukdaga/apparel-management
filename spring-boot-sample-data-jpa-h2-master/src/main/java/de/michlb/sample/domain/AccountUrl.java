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
@Table(name="account_url")
public class AccountUrl extends ResourceSupport {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "ID")
	 private Long urlId;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "ACCOUNT_ID", nullable = false)
	 @JsonIgnore
	 private Account account;
	 
	 private String originalUrl;
	 
	 private String shortUrl;
	 
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
