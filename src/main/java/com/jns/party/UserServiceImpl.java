package com.jns.party;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Inject
    public UserServiceImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(final User user) throws UserAlreadyExistsException {
    	User existing = repository.findOne(user.getId());
        if (existing != null) {
            throw new UserAlreadyExistsException(String.format("There already exists a user with id=%s", user.getId()));
        }
        return repository.save(user);
    }
    
    
    @Override
    @Transactional
    public User getUser(final String id)  {
    	System.out.println("id to fetch::"+id);
    	User user = repository.findOne(id);
        return user;
    }
    
    @Override
    @Transactional
    public List<User> getUsers()  {
    	List<User> users = repository.findAll();
        return users;
    }
    

}
