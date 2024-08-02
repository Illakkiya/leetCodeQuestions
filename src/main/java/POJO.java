import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;

public class POJO {
    public static void main(String[] args) {
        // JSON string
        String json = "{\"items\": [\"item1\", \"item2\", \"item3\"]}";

        // Parse the JSON string and create a DocumentContext object
        DocumentContext context = JsonPath.parse(json);

        // Access the second item in the array using JSONPath expression
        String secondItem = context.read("$.items[1]", String.class);

        // Print the result
        System.out.println("Second set of items: " + secondItem);
    }
}
