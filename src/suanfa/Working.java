package suanfa;

import java.util.HashMap;
import java.util.Map;

public class Working {

    public static void main(String[] args) {
        Map<Short, Integer> map = new HashMap<>();
        for (Short i = 0; i < 100; i++) {
            map.put(i, 100 - i);
            map.remove(i - 1);
        }
        System.out.println(map.size());
    }
}
