import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author d_shilko
 * Created: 13.03.2022
 */

public class First {

    public static void main(String[] args) {

        /*Есть коллекция*/
        List<String> strings = Stream.of("1", "2", "3").collect(Collectors.toList());

        /*мы хотим преобразовать List<String> в List<Integer>*/
        List<Integer> integers =
                strings.stream()
                        .map(stringToInteger) /*такой ссылки у нас нет, нужно ее создать, что бы компилятор не ругался*/
                        .collect(Collectors.toList());

        System.out.println(integers);

    }

}
