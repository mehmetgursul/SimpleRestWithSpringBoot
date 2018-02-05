package selfstudy.spring.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@RequestMapping("/cars")
	public List<Car> getAllCars() {
		return carService.getAllCars();
	}

	@RequestMapping("/cars/{id}")
	public Car getTopic(@PathVariable String id) {
		return carService.getCar(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/cars")
	public void addCar(@RequestBody Car car) {
		carService.addCar(car);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateCar(@RequestBody Car car) {
		carService.updateCar(car);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/cars/{id}")
	public void deleteCar(@PathVariable String id) {
		carService.deleteCar(id);
	}

}
