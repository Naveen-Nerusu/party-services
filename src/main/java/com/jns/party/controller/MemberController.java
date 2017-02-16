package com.jns.party.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jns.party.UserAlreadyExistsException;
import com.jns.party.jpa.model.PartyMember;

@RestController
public class MemberController {

	private MemberService memberService;

	@Inject
	public MemberController(final MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public PartyMember createMember(@RequestBody @Valid final PartyMember member) throws UserAlreadyExistsException {
		return memberService.save(member);
	}

	@RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
	public PartyMember getPartyMember(@Valid @PathVariable final Integer id) {
		return memberService.getPartyMember(id);
	}

	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public List<PartyMember> getPartyMembers() {
		return memberService.getPartyMembers();
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.CONFLICT)
	public String handleUserAlreadyExistsException(UserAlreadyExistsException e) {
		return e.getMessage();
	}

}
