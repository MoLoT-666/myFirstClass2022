
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;


public class JsonStthm {

    public static void main(String[] args) {

        Cat myCat = new Cat();
        myCat.setName("Germes");
        myCat.setType("Sfinks");
        myCat.setAge(7);

        Gson gson = new Gson();

        String jsonCat = gson.toJson(myCat);
        System.out.println("json string: " + jsonCat);

    }

}
@Getter
@Setter

class Cat{
    private String name;
    private String type;
    private int age;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}