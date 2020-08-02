package com.gcSpring.web.rest;

import com.gcSpring.domain.Gas;
import com.gcSpring.domain.Users;
import com.gcSpring.service.GasService;
import com.gcSpring.service.UserService;
import org.hibernate.exception.DataException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/measurements")
public class GasResource {

    private final GasService gasService;
    private final UserService userService;

    public GasResource(GasService service, UserService userService){
        this.gasService = service;
        this.userService = userService;
    }
    @PostMapping("/gas")
    public ResponseEntity<Gas> add(@RequestParam Long measurement, @RequestParam Long userId){
        Users user = userService.findById(userId);
        Gas gas = new Gas();
        gas.setMeasurement(measurement);
        gas.setUser(user);
        gas.setDate(new Date().toString());
        gasService.save(gas);
        return ResponseEntity.ok(gas);
    }
    @GetMapping("/gas")
    public ResponseEntity getAll(){
        List<Gas> gasList = gasService.findAll();
        return ResponseEntity.ok(gasList);
    }
    @GetMapping("/gas/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Gas gas = gasService.findById(id);
        return ResponseEntity.ok(gas);
    }
    @PutMapping("/gas")
    public ResponseEntity update(@RequestBody Gas gas){
        Gas gas1 = gasService.save(gas);
        return ResponseEntity.ok(gas1);
    }
    @DeleteMapping("/gas/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        gasService.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
