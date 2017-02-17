package com.jns.party;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.jns.party.jpa.model.AssemblyConstituency;
import com.jns.party.jpa.model.PartyMember;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.jns.party")
public class Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Transactional
	public void run(String... strings) throws Exception {
		final AssemblyConstituency vijayawada = new AssemblyConstituency("Vijayawada");
		Set<PartyMember> members = new HashSet<PartyMember>() {
			private static final long serialVersionUID = 1L;

			{
				add(new PartyMember("Member 1", "970-270-7046", "naveen.nerusu@gmail.com", vijayawada));
				add(new PartyMember("Member 2", "970-270-7046", "naveen.nerusu@gmail.com", vijayawada));
				add(new PartyMember("Member 3", "970-270-7046", "naveen.nerusu@gmail.com", vijayawada));
			}
		};
		vijayawada.setMembers(members);
		
	}
}
