import java.sql.Driver;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WaitTypes {
   List<Integer> arr = Arrays.asList(1,5,7);

   List<Integer> newArr = arr.stream().filter(a->a>4).collect(Collectors.toList());

}
