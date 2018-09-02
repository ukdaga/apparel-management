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
(name="account" ,
uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})})
public class Account extends ResourceSupport {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Long accountId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "VERSION")
	@JsonIgnore
	@Version
	private int version;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "account")
	@JsonIgnore
	private Set<AccountUrl> accountUrls = new HashSet<>();

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<AccountUrl> getAccountUrls() {
		return accountUrls;
	}

	public void setAccountUrls(Set<AccountUrl> accountUrls) {
		this.accountUrls = accountUrls;
	}

}
