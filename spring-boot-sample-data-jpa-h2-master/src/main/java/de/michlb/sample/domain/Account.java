package de.michlb.sample.domain;

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
(name="account" ,
uniqueConstraints = {@UniqueConstraint(columnNames = {"REF_NAME"})})
public class Account extends ResourceSupport {

	@Id
	@Column(name = "ID")
	private Long accountId;
	
	@Column(name = "REF_NAME")
	private String refName;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "VERSION")
	@JsonIgnore
	@Version
	private int version;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "account")
	@JsonIgnore
	private Set<AccountUrl> accountUrls = new HashSet<>();

	
	public Account()
	{
		
	}
}
