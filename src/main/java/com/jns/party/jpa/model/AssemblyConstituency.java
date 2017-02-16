package com.jns.party.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "assembly_constituency")
public class AssemblyConstituency {

	private Integer constituencyID;

	private String constituencyName;

	private PartyMember member;

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

	@OneToOne(mappedBy = "constituency")
	public PartyMember getMember() {
		return member;
	}

	public void setMember(PartyMember member) {
		this.member = member;
	}

}
