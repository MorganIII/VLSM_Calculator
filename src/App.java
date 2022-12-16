import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(50);
        list.add(15);
        Map<String, Subnet> subnets= Calculator.findall("172.31.103.0/24",list);

        Calculator.printAllSubnetsInfo(subnets);
    }
}
