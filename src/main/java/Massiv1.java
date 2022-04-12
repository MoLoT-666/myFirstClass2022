public class Massiv1 {
    public static void main(String[] args) {
        int[] number = {5, 8, 0, 3, 1, 4, 9, 2, 6, 7};
        for (int i = 0; i < 10; i++) {
            int x = number[i];

            for (int o = 0; o < 10; o++){
                if (x > number[o]) {
                x = number[o];
                number[o] = number[i];
                number[i] = x;
                }
            }

        }

        for (int i = 0; i < 10; i++) {
            System.out.println(number[i]);
        }

    }
}
