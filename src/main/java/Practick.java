import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practick {

    public static void main(String[] args) {

        Car car = new Car();

        car.addPeredachi(new Peredacha("задняя", 10));
        car.addPeredachi(new Peredacha("первая", 20));
        car.addPeredachi(new Peredacha("вторая", 40));
        car.addPeredachi(new Peredacha("третья", 60));
        car.addPeredachi(new Peredacha("четвертая", 80));
        car.addPeredachi(new Peredacha("пятая", 180));


        int maxSpeed = car.findMaxSpeed();
        List<Integer> list = car.collectSpeeds();

        System.out.println(maxSpeed);
        System.out.println(list);

        int sum = car.mkpp
                .stream()
                .mapToInt(peredacha -> peredacha.maxSpeed)
                .sum();

        List<String> names = car.mkpp
                .stream()
                .map(b -> b.description)
                .collect(Collectors.toList());

        System.out.println(names);

        List<Peredacha> fastGears = car.mkpp
                .stream()
                .filter(peredacha -> peredacha.maxSpeed > 60)
                .collect(Collectors.toList());

        System.out.println("--------------");
        System.out.println(fastGears);
        System.out.println("--------------");

        Optional<Peredacha> peredachaOptional = car.mkpp
                .stream()
                .filter(peredacha -> peredacha.description.equals("пятая"))
                .findFirst();

        if (peredachaOptional.isEmpty()) {
            System.out.println("Нет такой передачи!");
        } else {
            System.out.println("Есть такая!!!");
        }

        boolean isPeredachaPresent = car.mkpp
                .stream()
                .anyMatch(peredacha -> peredacha.maxSpeed == 60 && peredacha.description.equals("третья"));



    }

    public static class Peredacha {
        private String description;
        private int maxSpeed;

        public Peredacha(String description, int maxSpeed) {

            this.description = description;
            this.maxSpeed = maxSpeed;
        }

        @Override
        public String toString() {
            return "Peredacha{" +
                    "description='" + description + '\'' +
                    ", maxSpeed=" + maxSpeed +
                    '}';
        }
    }

    public static class Car {

        public List<Peredacha> mkpp = new ArrayList<>();

        public void addPeredachi(Peredacha peredacha) {

            if (peredacha != null) {
                mkpp.add(peredacha);
            }
        }



        public int findMaxSpeed() {
            int result = 0;

            for (Peredacha peredacha : mkpp) {
                int maxSpeed = peredacha.maxSpeed;
                if (maxSpeed > result) {
                    result = maxSpeed;
                }
            }

            return result;
        }

        public List<Integer> collectSpeeds() {
//            List<Integer> result = new ArrayList<>();
//
//            for (Peredacha peredacha : mkpp) {
//                result.add(peredacha.maxSpeed);
//            }
//
//            return result;

            return mkpp.stream()
                    .map(peredacha -> peredacha.maxSpeed)
                    .collect(Collectors.toList());
        }
    }




}

