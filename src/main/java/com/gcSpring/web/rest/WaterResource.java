package com.gcSpring.web.rest;

import com.gcSpring.domain.Users;
import com.gcSpring.domain.Water;
import com.gcSpring.service.UserService;
import com.gcSpring.service.WaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class WaterResource {

    private final WaterService waterService;
    private final UserService userService;

    public WaterResource(WaterService service, UserService userService){
        this.waterService = service;
        this.userService = userService;
    }
    @PostMapping("/water")
    public ResponseEntity<Water> add(@RequestParam Long measurement, @RequestParam Long userId){
        Users user = userService.findById(userId);
        Water water = new Water();
        water.setMeasurement(measurement);
        water.setUser(user);
        water.setDate(new Date().toString());
        waterService.save(water);
        return ResponseEntity.ok(water);
    }
    @GetMapping("/water")
    public ResponseEntity getAll(){
        List<Water> waterList = waterService.findAll();
        return ResponseEntity.ok(waterList);
    }
    @GetMapping("/water/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Water water = waterService.findById(id);
        return ResponseEntity.ok(water);
    }
    @PutMapping("/water")
    public ResponseEntity update(@RequestBody Water water){
        Water water1 = waterService.save(water);
        return ResponseEntity.ok(water1);
    }
    @DeleteMapping("/water/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        waterService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}