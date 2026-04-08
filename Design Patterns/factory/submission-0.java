interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

// ✅ Just implement these (NO Main class)

class CarFactory extends VehicleFactory {
    Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory extends VehicleFactory {
    Vehicle createVehicle() {
        return new Bike();
    }
}

class TruckFactory extends VehicleFactory {
    Vehicle createVehicle() {
        return new Truck();
    }
}