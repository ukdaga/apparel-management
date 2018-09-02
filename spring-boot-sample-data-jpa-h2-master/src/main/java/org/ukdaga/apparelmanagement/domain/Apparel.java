package org.ukdaga.apparelmanagement.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
(name="apparel" ,
uniqueConstraints = {@UniqueConstraint(columnNames = {"REF_NAME"})})
public class Apparel extends ResourceSupport {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long apparelId;
	
	@Column(name = "REF_NAME")
	private String refName;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "VERSION")
	@JsonIgnore
	@Version
	private int version;
	
	@Column(name = "APPAREL_TYPE")
	private String apparelType;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "apparel")
	@JsonIgnore
	private Set<ApparelSku> apparelsku = new HashSet<>();

	public Long getApparelId() {
		return apparelId;
	}
	public void setApparelId(Long apparelId) {
		this.apparelId = apparelId;
	}
	public String getRefName() {
		return refName;
	}
	public void setRefName(String refName) {
		this.refName = refName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getApparelType() {
		return apparelType;
	}
	public void setApparelType(String apparelType) {
		this.apparelType = apparelType;
	}
	
	public Set<ApparelSku> getApparelsku() {
		return apparelsku;
	}
	public void setApparelsku(Set<ApparelSku> apparelsku) {
		this.apparelsku = apparelsku;
	}
	public Apparel(String refName, String type, int version, String apparelType) {
		this.refName = refName;
		this.type = type;
		this.apparelType = apparelType;
	}
	
	public Apparel()
	{
		
	}
}
