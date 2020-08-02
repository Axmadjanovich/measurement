package com.gcSpring.service;

import com.gcSpring.domain.Water;
import com.gcSpring.repository.WaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterService {
    private final WaterRepository waterRepository;
    public WaterService(WaterRepository waterRepository){
        this.waterRepository = waterRepository;
    }
    public Water save(Water Water){
        return waterRepository.save(Water);
    }
    public List<Water> findAll(){
        return waterRepository.findAll();
    }
    public Water findById(Long id){
        return waterRepository.findById(id).get();
    }
    public void delete(Long id){
        Water water = waterRepository.getOne(id);
        waterRepository.delete(water);
    }
}
