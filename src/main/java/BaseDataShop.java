


import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;


public class BaseDataShop {

    public static void main(String[] args) {

        /*хранит ввод пользователя*/
        String userInput;

        List<Part> parts = new ArrayList<>();

        int price;

        String x = "exit";

        /*цикл работает до тех пор пока пользователь не введет "exit"*/
        do {
            Scanner console = new Scanner(System.in);

            /*сообщение*/
            String errorMessage = null;

            /*запчасть*/
            Part part = new Part();

            System.out.println("Введите наименование запчасти, ее бренд и стоимость, для выхода введите exit");
            System.out.println("Введите имя запчасти:");

            userInput = console.nextLine();

            if (userInput.equals(x)) {
                System.out.println("Пользователь завершил программу.");
                break;
            } else {
                /*first step*/
                if (validateString(userInput)) {
                    part.setName(userInput);
                    System.out.println("Введите производителя запчасти:");

                    userInput = console.nextLine();

                    /*second step*/
                    if (validateString(userInput)) {
                        part.setBrand(userInput);

                        System.out.println("Введите цену запчасти:");
                        price = console.nextInt();

                        /*third step*/
                        if (validateNumber(price)) {
                            part.setPrice(price);
                        } else {
                            errorMessage = "Цена указана не верно";
                        }
                    } else {
                        errorMessage = "Наименование производителя не корректно";
                    }

                } else {
                    errorMessage = "Название не корректно";
                }
            }

            /*если есть ошибка, то выводим сообщение и завершаем метод*/
            if (errorMessage != null) {
                System.out.println(errorMessage);
            } else {
                System.out.println("Ваши данные успешно внесены.");
                parts.add(part);
            }

        } while (!userInput.equals(x));


        /*time to save to file*/
        Path path = Path.of("parts_catalog.txt");

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }

        } catch (IOException e) {
            System.out.println("Не удалось создать файл!");
            return;

        }

        List<String> partsAsString =
                parts.stream()
                        .map(Part::toString)
                        .collect(Collectors.toList());

        try {
            Files.write(path, partsAsString, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ваши данные сохранены в файл.");

    }

    /**
     * Метод проверяет строку
     * 1. Ссылка не должна быть null
     * 2. Строка должна содержать более 3х символов
     */
    private static boolean validateString(String stringToCheck) {

        boolean partNameIsNotNull = stringToCheck != null;
        boolean partNameIsNotEmpty = !stringToCheck.isEmpty();
        boolean partNameLengthIsOk = stringToCheck.length() > 3;

        return partNameIsNotNull && partNameIsNotEmpty && partNameLengthIsOk;
    }

    private static boolean validateNumber(int numberToValidate) {
        return numberToValidate > 0 && numberToValidate < 1_000_000;
    }
}

@Setter
@ToString
class Part {

    public String name;
    public String brand;
    public int price;

    public Part() {

    }

    public Part(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
}


