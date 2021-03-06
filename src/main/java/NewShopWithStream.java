import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewShopWithStream {

    public static void main(String[] args) {

        Client bill = new Client("Bill", 43);
        ShopAutoparts shopAutopars = new ShopAutoparts();
        SallerMan max = new SallerMan("Max", 33);
        Scanner scanner = new Scanner(System.in);


        shopAutopars.addTools(new Tool("тормоз", "German", 100));
        shopAutopars.addTools(new Tool("тормоз", "France", 70));
        shopAutopars.addTools(new Tool("тормоз", "China", 10));
        shopAutopars.addTools(new Tool("тормоз", "Italy", 68));
        shopAutopars.addTools(new Tool("тормоз", "USA", 50));
        shopAutopars.addTools(new Tool("газ", "Japan", 85));

        max.shop = shopAutopars;
        max.client = bill;

        System.out.println("Введите неоходимую запчасть");

        bill.findTool = scanner.nextLine();
        if (!bill.findTool.equals(" ")) {


            List<Tool> toolYoyNeed = shopAutopars.inStok.stream()
                    .filter(tool -> tool.nameTool.equals(bill.findTool))
                    .collect(Collectors.toList());


            List<Tool> bestPriceInFierst = toolYoyNeed.stream()
                    .sorted(Comparator.comparing(tool -> tool.price))
                    .collect(Collectors.toList());

            if (bestPriceInFierst.size() > 0) {

                System.out.println("Можем предложить для вас:");
                System.out.println(bestPriceInFierst);
            } else System.out.println("Нет такого у нас ваабще!!!");
        } else System.out.println("Erorr...call Bruese Willys");
    }
}

class Client{

    String findTool;

    private String name;
    private int age;

    public Client(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
class Tool {

    public String nameTool;
    public String country;
    public int price;


    @Override
    public String toString() {
        return nameTool + " " + country + " " + price + "$";
    }

    public Tool(String nameTool, String country, int price) {
        this.nameTool = nameTool;
        this.country = country;
        this.price = price;



    }

}

class ShopAutoparts{

    public List<Tool> inStok = new ArrayList<>();
    public void addTools(Tool tool){
        if (tool != null){
            inStok.add(tool);

        }
    }

}
class SallerMan {

    public ShopAutoparts shop;
    public Client client;
    private String name;
    private int age;

    public SallerMan(String name, int age) {
        this.name = name;
        this.age = age;
    }
}