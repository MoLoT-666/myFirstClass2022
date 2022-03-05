



import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class BaseDataShop {
    public static void main(String[] args) {


        Parts parts = new Parts();


        Scanner console = new Scanner(System.in);

        String name1;
        String brand1;
        int price1;
        String x = "exit";


        System.out.println("Введите наименование запчасти, ее бренд и стоимость, для выхода введите exit");


        System.out.println("Введите имя запчасти:");
        name1 = console.nextLine();
            if ((!name1.equals(x)) & (name1!=null)) {
                Part.name = name1;

                System.out.println("Введите производителя запчасти:");
                brand1 = console.nextLine();
                if (!brand1.equals(x)) {
                    Part.brand = brand1;

                    System.out.println("Введите цену запчасти:");
                    price1 = console.nextInt();
                    if (price1 != 0) {
                        Part.price = price1;


                    System.out.println("Ваши данные успешно внесены.");
                    }
                }

            }

            else console.close();


            parts.addPart(new Part(Part.name, Part.brand, Part.price));


            String price2 = Integer.toString(Part.price);
            ArrayList<String> toDataBase = new ArrayList(Arrays.asList(Part.name, Part.brand, price2));


            Path path = Path.of("readme.txt");

            try {
                if (!parts.equals(Path.of("readme.txt"))) {
                    Files.createFile(path);
                }


            } catch (IOException e) {
                System.out.println("Skynet is broucken!!! call 911");

            }
            try {
                Files.write(path, toDataBase, StandardOpenOption.WRITE);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

            class Part {
               public static String name;
               public static String brand;
               public static int price;

                public Part(String name, String brand, int price) {
                    this.name = name;
                    this.brand = brand;
                    this.price = price;
                }

            }


            class Parts {
                public List<Part> baseParts = new ArrayList<>();

                public void addPart(Part part) {
                    if (!part.equals(null)) {
                        baseParts.add(part);
                    }
                }

            }
