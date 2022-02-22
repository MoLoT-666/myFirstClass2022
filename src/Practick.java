import java.util.ArrayList;
import java.util.List;

public class Practick {

    public static void main(String[] args) {

        Car car = new Car();

        car.addPeredachi(new Peredachi("задняя", 10));
        car.addPeredachi(new Peredachi("первая", 20));
        car.addPeredachi(new Peredachi("вторая", 40));
        car.addPeredachi(new Peredachi("третья", 60));
        car.addPeredachi(new Peredachi("четвертая", 80));
        car.addPeredachi(new Peredachi("пятая", 180));



        car.findMaxSpeed();
        System.out.println(car.maxSpeedAll);



    }

    public static class Peredachi {
        private String description;
        private static int maxSpeed;

        public Peredachi(String description, int maxSpeed) {

            this.description = description;
            this.maxSpeed = maxSpeed;
        }


    }

    public static class Car {


        public List<Peredachi> mkpp = new ArrayList<>();
        public List<Integer> maxSpeedAll = new ArrayList<>();
        public Peredachi peredachki;


        public void addPeredachi(Peredachi peredachki) {

            if (peredachki != null) {
                mkpp.add(peredachki);
            }
        }

        int i;
        int x = 0;

        public int findMaxSpeed() {

            int maxSpeed = Peredachi.maxSpeed;
            if (maxSpeed != 0) {

                for (i = 0; i < mkpp.size(); i++) {
                    Peredachi maxSpeedFor1 = mkpp.get(i);
                    x = maxSpeedFor1.maxSpeed;

                }
                maxSpeedAll.add(x);

            }
           return x;
        }
    }


}

