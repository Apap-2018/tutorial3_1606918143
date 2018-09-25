package com.apap.tutorial3.service;
import java.util.ArrayList;
import java.util.List;

import com.apap.tutorial3.model.CarModel;

import org.springframework.stereotype.Service;

@Service
public class CarInMemoryService implements CarService {
	private List<CarModel> archiveCar;
	
	public CarInMemoryService() {
		archiveCar = new ArrayList<>();
	}

	@Override
	public void addCar(CarModel car) {
		archiveCar.add(car);
	}

	@Override
	public List<CarModel> getCarList() {
		return archiveCar;
	}

	@Override
	public CarModel getCarDetail(String id) {
	for (int i = 0; i < archiveCar.size(); i++) {
			CarModel mobil = archiveCar.get(i);
			if(mobil.getId().equals(id)) {
				return mobil;
			}
	}
	return null;
	}
	
	@Override
	public boolean checkCar(String id) {
		for(int i = 0; i < archiveCar.size(); i++) {
			CarModel mobil = archiveCar.get(i);
			if(mobil.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void updateAmount(String id, String amount) {
		CarModel mobil = getCarDetail(id);
		mobil.setAmount(Integer.parseInt(amount));
	}
	
	public void deleteCar(String id) {
		CarModel mobil = getCarDetail(id);
		archiveCar.remove(mobil);
	}
}
