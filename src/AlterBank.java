import java.util.ArrayList;
import java.util.List;

/**
 * @author d_shilko
 * Created: 18.02.2022
 */

public class AlterBank {

    public static void main(String[] args) {

        Certificate certificate = new Certificate("Google");
        certificate.addSalary(null);
        certificate.addSalary(new Salary(1000, TheMonth.MAY));
        certificate.addSalary(new Salary(1200, TheMonth.JUN));
        certificate.addSalary(new Salary(900, TheMonth.JUL));


        /* vasja*/
        Client vasjaDolznik = new Client("Vasja", 25);
        vasjaDolznik.certificate = certificate;
        vasjaDolznik.passport = new Passport(Sex.MAN, "MC778822", 2023);

        /*petya*/
        Client petyaPorutchitel = new Client("Petya", 23);
        petyaPorutchitel.certificate = certificate;
        petyaPorutchitel.passport = new Passport(Sex.I_DONT_KNOW, "MC112233", 2022);

    }

    private static class Salary {

        private int amount;
        private TheMonth month;

        public Salary(int amount, TheMonth month) {

            this.amount = amount;
            this.month = month;
        }

    }

    private static enum TheMonth {
        MAY, JUN, JUL
    }

    private static class Client {

        public Passport passport;
        public Certificate certificate;

        private String name;
        private int age;

        public Client(String name, int age) {

            this.name = name;
            this.age = age;
        }
    }

    private static enum Sex {
        MAN, WOMAN, I_DONT_KNOW
    }

    private static class Passport implements Validateable {
        private Sex sex;
        private String passportNumber;
        private int expirationDate;

        public Passport(Sex sex, String passportNumber, int expirationDate) {
            this.sex = sex;
            this.passportNumber = passportNumber;
            this.expirationDate = expirationDate;
        }

        @Override
        public boolean validate() {
            if (sex == null){
                return false;
            }
            if (passportNumber == null){
                return false;
            }
            if (expirationDate<=2020){
                return false;
            }
            else return true;
        }
    }

    private static class Certificate implements Validateable {
        private String workPlace;

        private List<Salary> salaries = new ArrayList<>();

        public Certificate(String workPlace) {
            this.workPlace = workPlace;
        }

        public void addSalary(Salary salary) {

            if (salary != null) {
                salaries.add(salary);
            }

        }

        @Override
        public boolean validate() {
            if (workPlace == null) {
                return false;
            }

            if (salaries == null) {
                return false;
            }

            if (salaries.size() < 3) {
                return false;
            }

            return true;
        }
    }


    private static interface Operation {

        boolean check(Validateable validateable);

        void operate();

    }

    private static class CreditOperation implements Operation {

        @Override
        public boolean check(Validateable validateable) {
            return false;
        }

        @Override
        public void operate() {

        }

    }

    private static interface Validateable {

        boolean validate();

    }

}

