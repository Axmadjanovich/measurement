package com.gcSpring.service;

import com.gcSpring.domain.Gas;
import com.gcSpring.repository.GasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GasService {
    private final GasRepository gasRepository;
    public GasService(GasRepository gasRepository){
        this.gasRepository = gasRepository;
    }
    public Gas save(Gas gas){
        return gasRepository.save(gas);
    }
    public List<Gas> findAll(){
        return gasRepository.findAll();
    }
    public Gas findById(Long id){
        return gasRepository.findById(id).get();
    }
    public void delete(Long id){
        Gas gas = gasRepository.getOne(id);
        gasRepository.delete(gas);
    }
}
