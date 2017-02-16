package com.jns.party.controller;

import java.util.List;

import com.jns.party.UserAlreadyExistsException;
import com.jns.party.jpa.model.PartyMember;

public interface MemberService {

	PartyMember save(PartyMember member) throws UserAlreadyExistsException;
	
	List<PartyMember> getPartyMembers();
	
	PartyMember getPartyMember(Integer id);

}
