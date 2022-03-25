public class FabricClass {

    public static void main(String[] args) {

        Factory factory = new FactoryAudi();
        Car car = factory.createCar();
        car.carGo();
        car.carStop();
        factory.createParts();

    }
}

abstract class Car {

    public abstract void carGo();
    public abstract void carStop();
}

class Bmw extends Car{

    @Override
    public void carGo() {
        System.out.println("BMW fucking faster go!!!");
    }

    @Override
    public void carStop() {
        System.out.println("BMW stopped just with help column...");
    }
}

class Audi extends Car{

    @Override
    public void carGo() {
        System.out.println("Audi started like a bullet!");
    }

    @Override
    public void carStop() {
        System.out.println("Audi stopped");
    }
}

abstract class Factory {

    public abstract Car createCar();
    public abstract void createParts();
}

class FactoryBmw extends Factory{

    @Override
    public Car createCar() {
        return new Bmw();
    }

    @Override
    public void createParts() {
        System.out.println("Parts is ready!");
    }
}

class FactoryAudi extends Factory{

    @Override
    public Car createCar() {
        return new Audi();
    }

    @Override
    public void createParts() {
        System.out.println("Parts is ready!");
    }
}