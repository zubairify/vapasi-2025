package com.tw.service;

import com.tw.bean.Vehicle;
import com.tw.dao.VehicleDao;

import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private VehicleDao dao;

    public VehicleServiceImpl(VehicleDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return dao.add(vehicle);
    }

    @Override
    public Vehicle findByCode(int code) {
        return dao.findByCode(code);
    }

    @Override
    public List<Vehicle> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return dao.findByBrand(brand);
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        return dao.findByColor(color);
    }

    @Override
    public List<Vehicle> findByFuel(String fuel) {
        return dao.findByFuel(fuel);
    }

    @Override
    public List<Vehicle> findByCostRange(double min, double max) {
        return dao.findByCostRange(min, max);
    }
}
