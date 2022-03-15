
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;


public class JsonStthm {

    public static void main(String[] args) throws JsonProcessingException {

        Cat myCat = new Cat();
        myCat.setName("Germes");
        myCat.setType("Sfinks");
        myCat.setAge(7);

        Gson gson = new Gson();

        String jsonCat = gson.toJson(myCat);
        System.out.println("JSON string with gson libraries: " + jsonCat);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonCat2 = objectMapper.writeValueAsString(myCat);
        System.out.println("JSON string with jackson libraries: " + jsonCat2);

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