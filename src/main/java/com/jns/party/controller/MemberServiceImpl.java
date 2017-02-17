package com.jns.party.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jns.party.UserAlreadyExistsException;
import com.jns.party.jpa.model.PartyMember;
import com.jns.party.repository.PartyMemberRepo;

@Service
public class MemberServiceImpl implements MemberService {

	private final PartyMemberRepo memberRepository;

	@Inject
	public MemberServiceImpl(final PartyMemberRepo memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Override
	public PartyMember save(PartyMember member) throws UserAlreadyExistsException {

		PartyMember existing = memberRepository.findOne(member.getId());
		if (existing != null) {
			throw new UserAlreadyExistsException(
					String.format("There already exists a member with id=%s", member.getId()));
		}
		return memberRepository.save(member);
	}

	@Override
	public List<PartyMember> getPartyMembers() {
		List<PartyMember> members = memberRepository.findAll();
		return members;
	}

	@Override
	public PartyMember getPartyMember(Integer id) {
		PartyMember user = memberRepository.findOne(id);
		
		System.out.println(user.getConstituency());
		return user;
	}

}
