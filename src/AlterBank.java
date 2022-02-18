/**
 * @author d_shilko
 * Created: 18.02.2022
 */

public class AlterBank {

    public static void main(String[] args) {
        Salary[] salaries = {
                new Salary(),
                new Salary(),
                new Salary(),
        };

        Operation creditOperation = new Operation();


        Operation exchangeOperation = new Operation();
        creditOperation.passportRequired = true;

    }

    private static class Human {
        String name;
        int age;
    }

    private static class Salary {
        String month; /* month name*/
        int amount; /* how much money did you got*/
    }

    private static class Condition {
        boolean passportRequired;
        boolean needGuarantor;
    }

    private static class Operation {
        String operationName;
        Condition condition;
    }


}

