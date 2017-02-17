package com.jns.party.jpa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "constituency")
public class AssemblyConstituency {

	private Integer constituencyID;

	private String constituencyName;

	private Set<PartyMember> members;

	public AssemblyConstituency() {

	}

	public AssemblyConstituency(String constituencyName) {
		this.constituencyName = constituencyName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getConstituencyID() {
		return constituencyID;
	}

	public void setConstituencyID(Integer constituencyID) {
		this.constituencyID = constituencyID;
	}

	@Column(name = "consti_name")
	public String getConstituencyName() {
		return constituencyName;
	}

	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}

	//http://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
	@OneToMany(mappedBy = "constituency", cascade = CascadeType.ALL)
	@JsonManagedReference
	public Set<PartyMember> getMembers() {
		return members;
	}

	public void setMembers(Set<PartyMember> members) {
		this.members = members;
	}

}
