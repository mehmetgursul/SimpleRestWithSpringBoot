package selfstudy.spring.car;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true)
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAllCars() {
		List<Car> cars = new ArrayList<>();
		carRepository.findAll().forEach(cars::add);
		return cars;
	}

	public Car getCar(String id) {
		return carRepository.findOne(id);
	}

	@Transactional(
	            propagation = Propagation.REQUIRED,
	            readOnly = false)
	public void addCar(Car car) {
		carRepository.save(car);
		
        // Illustrate Tx Rollback
        if (car.getId().equals("5")) {
            throw new RuntimeException("Rollback car with id : 5!");
        }
	}

	public void updateCar(Car car) {
		carRepository.save(car);
	}

	public void deleteCar(String id) {
		carRepository.delete(id);
	}
}
