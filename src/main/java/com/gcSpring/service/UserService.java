package com.gcSpring.service;

import com.gcSpring.domain.Users;
import com.gcSpring.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users save(Users user){
        return usersRepository.save(user);
    }

    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    public Users findById(Long id){
        return usersRepository.findById(id).get();
    }

    public void delete(Long id){
        Users user = usersRepository.getOne(id);
        usersRepository.delete(user);
    }
}
