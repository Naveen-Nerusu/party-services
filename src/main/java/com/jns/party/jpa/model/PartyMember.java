package com.jns.party.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PartyMember {

	private int id;

	private String name;

	private String phoneNumber;

	private String emailId;

	private AssemblyConstituency constituency;
	
	public PartyMember() {

	}

	public PartyMember(String name, String phoneNumber, String emailId, AssemblyConstituency constituency) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.constituency = constituency;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "constituencyID")
	@JsonBackReference
	public AssemblyConstituency getConstituency() {
		return constituency;
	}

	public void setConstituency(AssemblyConstituency constituency) {
		this.constituency = constituency;
	}

	@Column(name = "member_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "member_phone")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "member_email")
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
