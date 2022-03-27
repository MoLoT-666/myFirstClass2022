import java.util.Scanner;

public class AbstractFactory {

    public static void main(String[] args) {

        String userInput;
        String brand = "bmw";
        String car = "familycar";
        Scanner scan = new Scanner(System.in);

        FactoryCars factory;
        CreateCar createCar;

        System.out.println("Name your favorite automaker in the World? [bmw or audi]");
        userInput = scan.nextLine();
        if (userInput.equals(brand)){
            factory = new BMWFactory();
        } else {
            factory = new AudiFactory();
        }

        System.out.println("What car do you need? [sportcar or familycar]");
        userInput = scan.nextLine();
        if (userInput.equals(car)) {
            createCar = new CreateCar(factory);
               createCar.familyCar.goFamilyCar();
        } else {
            createCar = new CreateCar(factory);
               createCar.sportCar.goSportCar();
        }
    }
}


interface FamilyCar {
    void goFamilyCar();
}

interface SportCar {
    void goSportCar();
}

class BMWFamilyCar implements FamilyCar {
    public void goFamilyCar() {
        System.out.println("Family car BMW go!");
    }
}

class AUDIFamilyCar implements FamilyCar {
    public void goFamilyCar() {
        System.out.println("Family car Audi go!");
    }
}

class BMWSportCar implements SportCar {
    public void goSportCar() {
        System.out.println("Sport car BMW go!!!");
    }
}

class AudiSportCar implements SportCar {
    public void goSportCar() {
        System.out.println("Sport car Audi go!!!");
    }
}
interface FactoryCars {
    FamilyCar createFamilyCar();
    SportCar createSportCar();
}

class BMWFactory implements FactoryCars {
    public FamilyCar createFamilyCar() {
        return new BMWFamilyCar();
    }
    public SportCar createSportCar() {
        return new BMWSportCar();
    }
}

class AudiFactory implements FactoryCars {
    public FamilyCar createFamilyCar() {
        return new AUDIFamilyCar();
    }
    public SportCar createSportCar() {
        return new AudiSportCar();
    }
}

class CreateCar {
    public FamilyCar familyCar;
    public SportCar sportCar;

    public CreateCar(FactoryCars factoryCars){
        familyCar = factoryCars.createFamilyCar();
        sportCar = factoryCars.createSportCar();
    }

}
