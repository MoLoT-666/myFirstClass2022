public class FirstClass {

            public static void main(String[] args) {

            int[] salary = new int[]{1000, 700, 1200};   //зп за последние 3 месяца
            Human boy = new Human();
            boy.salary = salary;
            boy.guarantorBoy = true;  //Есть ли поручитель
            boy.moneyToExchange = 100;  //валюта для обмена

            Credit newCredit = new Credit();
            newCredit.minCash = 1000;       //условие для кредита (мин средний заработок за 3 месяца)
            newCredit.guarantor = true;     //условие для кредита (нужен ли поручитель)
            newCredit.clientBank = boy;
            newCredit.salary1 = salary;

            Currency euroDollar = new Currency();
            euroDollar.client2 = boy;
            euroDollar.euro = 2;

            Bank<Operations> Belarusbank = new Bank<>();
            Belarusbank.operations = euroDollar;
            Belarusbank.work();
            Belarusbank.operations = newCredit;
            Belarusbank.work();

            }


}
    interface Operations {
        int make();
    }

    class Human {
        public boolean guarantorBoy;
        public int moneyToExchange;
        public int[] salary;
    }
    class Credit implements Operations{
        public Human clientBank;
        public int[] salary1;
        int minCash;
        boolean guarantor;
        int cash1 = 0;

        @Override
        public int make() {
            int i;
            for (i=0;i<salary1.length;i++){
                cash1 = cash1 + salary1[i];}
            cash1 = cash1/ salary1.length;
            System.out.println(cash1);
            if ((cash1 >= minCash)&& (clientBank.guarantorBoy==guarantor)){
                System.out.println("Ваш кредит одобрен!!!");
            }
            else if ((cash1 < minCash)&&(clientBank.guarantorBoy==guarantor)){
                System.out.println("У Вас не достаточна зарплата, для данного кредита!!!");
            }
            else if ((cash1 >= minCash)&& (clientBank.guarantorBoy!=guarantor)){
                System.out.println("Для выдачи кредита нуже поручитель!!!");}
            else System.out.println("Вам отказано в выдаче кредита!!!");
            return cash1 = 0;
        }
    }

    class Currency implements Operations{
        public Human client2;
        int euro;
        int cash2 = 0;

        @Override
        public int make() {
            cash2 = client2.moneyToExchange*euro;
            System.out.println("Вот ваши " + cash2 + " евродолларысша");
            return cash2 = 0;
        }

    }
    class Bank <X extends Operations>{
        public X operations;
        public void work(){
            operations.make();
        }
    }

