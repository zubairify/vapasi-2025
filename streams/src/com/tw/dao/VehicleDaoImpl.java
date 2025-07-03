package com.tw.dao;

import com.tw.bean.Vehicle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleDaoImpl implements VehicleDao {
    private List<Vehicle> vehicles;

    public VehicleDaoImpl() {
//        vehicles = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get("streams/src/vehicles.txt"));

            vehicles = lines.map(line -> {
                String[] record = line.split(",");
                return new Vehicle(Integer.parseInt(record[0]), record[1], record[2], record[3],
                        record[4], Double.parseDouble(record[5]));
            }).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(Vehicle vehicle) {
        vehicles.add(vehicle);
        return true;
    }

    @Override
    public Vehicle findByCode(int code) {
        return vehicles.stream().filter(v -> v.getCode()==code).findFirst().orElse(null);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicles;
    }

    @Override
    public List<Vehicle> findByBrand(String brand) {
        return vehicles.stream().filter(v -> v.getBrand().equals(brand)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByColor(String color) {
        return vehicles.stream().filter(v -> v.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByFuel(String fuel) {
        return vehicles.stream().filter(v -> v.getFuel().equals(fuel)).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findByCostRange(double min, double max) {
        return vehicles.stream().filter(v -> v.getCost() >= min && v.getCost() <= max).collect(Collectors.toList());
    }
}
