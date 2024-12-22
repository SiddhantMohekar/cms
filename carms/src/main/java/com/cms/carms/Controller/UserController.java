package com.cms.carms.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.carms.Entity.Car;
import com.cms.carms.Service.CarService;


@RestController
public class UserController {

    @Autowired
    private CarService carService;
    
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars(){
        List<Car> list =  carService.getAllCar();
        if (list.size()<=0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    //to get a single car Handler
    @GetMapping("/cars/{id}")
    public ResponseEntity<Optional<Car>> getSingleCar(@PathVariable("id") long id){
        Optional<Car> car = carService.getCarById(id);
        if (car==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }  

    // To add car Handler
    @PostMapping("/addcar")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        Car c = null;
        try{
            c = this.carService.addCar(car);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    // To delete car Handler
    @DeleteMapping("/cars/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable("carId") int carId){
        try{
        this.carService.deleteCar(carId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // To update car or update car handler
    @PutMapping("/cars/{carId}")
    public ResponseEntity<Car> updateCar(@RequestBody Car car,@PathVariable("carId") int carId ){
        try{
        this.carService.updateCar(car,carId);
        return ResponseEntity.ok().body(car);
        }catch(Exception e){
             e.printStackTrace();
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

