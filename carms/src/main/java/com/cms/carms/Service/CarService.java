package com.cms.carms.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.carms.Entity.Car;
import com.cms.carms.Repos.CarRepository;


@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCar(){
        List<Car> list =(List<Car>) this.carRepository.findAll();
        return list;
    }

    //to get single car
    public Optional<Car> getCarById(long id){
        Optional<Car> car = null;
        try{
               car = this.carRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return car;
    }

    //To add new car
    public Car addCar(Car b){
        Car result = carRepository.save(b);
        return result;
    }

    // To delete car
    public void deleteCar(long bid){
        carRepository.deleteById(bid);
    }

    // To update car
    public void updateCar(Car car,int carId){
    car.setId(carId);
    carRepository.save(car);
       
    }
}

