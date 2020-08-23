package javatest.tencent;

import java.util.*;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class Object1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            // 读取一组数据
            LinkedList<Integer> linkedList = new LinkedList<>();
            int n = in.nextInt();
            for (int j = 0; j < n; j++) {
                int temp = in.nextInt();
                linkedList.add(temp);
            }

            // 用于保存每次相加的结果
            int result = 0;
            // 当链表中的元素的个数只有1的时候，就代表出结果了
            while (linkedList.size() != 1) {
                // 按从小到大排序
                Collections.sort(linkedList);
                int a = linkedList.get(0);
                int b = linkedList.get(1);
                // 移除掉a对应的元素
                linkedList.remove(0);
                // 移除掉b对应的元素
                linkedList.remove(0);
                result += a + b;
                linkedList.add(0, a + b);
            }
            System.out.println(result);
        }
        in.close();
    }
}
