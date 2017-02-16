package com.jns.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jns.party.jpa.model.PartyMember;

public interface PartyMemberRepo extends JpaRepository<PartyMember, Integer> {

}
