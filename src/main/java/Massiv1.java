import java.util.Arrays;
import java.util.Random;

public class Massiv1 {
    public static void main(String[] args) {
//        int[] number = {5, 8, 0, 3, 1, 4, 9, 2, 6, 7};
//        for (int i = 0; i < number.length; i++) {
//            int x = number[i];
//
//            for (int o = i+1; o < number.length; o++){
//                if (x < number[o]) {
//                x = number[o];
//                number[o] = number[i];
//                number[i] = x;
//                }
//            }
//        }
//        for (int j : number) {
//            System.out.println(j);
//        }
//    }
        Random random = new Random();
        int[] number = new int[100000];
        for  (int j=0; j<number.length; j++){
        number [j] = random.nextInt(100);}
//        for (int i=0; i<number.length; i++){
//        System.out.println(number[i]);}
       /**** пузырьковый метод *****/
//        for (int i = 0; i < number.length; i++) {
//            int x = number[i];
//
//            for (int o = i+1; o < number.length; o++){
//                if (x < number[o]) {
//                x = number[o];
//                number[o] = number[i];
//                number[i] = x;
//                }
//            }
//        }
//        for (int j : number) {
//            System.out.println(j);
//        }

        Arrays.sort(number);
        for (int j : number) {
          System.out.println(j);}
    }
}
