package syntactic;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */
public class TablePrint {

    private static final int SPACE = 10;

    public static void printTable(
            ArrayList<Character> letter,
            ArrayList<Grammar> vnSet,
            ArrayList<LinkedHashMap<Character, String>> predictTable) {
        System.out.println("****************TABLE**********************");
        for (int i = 0; i <= (letter.size() + 1) * SPACE; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("|%9s", "|");
        for (Character character : letter) {
            System.out.printf("%5c%5s", character, "|");
        }
        System.out.println();
        for (int i = 0; i <= (letter.size() + 1) * SPACE; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < vnSet.size(); i++) {
            System.out.printf("|%5s%4s", vnSet.get(i).getLeft(), "|");
            for (Character character : letter) {
                if (predictTable.get(i).containsKey(character)) {
                    System.out.printf("%7s%3s", predictTable.get(i).get(character), "|");
                } else {
                    System.out.printf("%10s", "|");
                }
            }
            System.out.println();
            for (int j = 0; j <= (letter.size() + 1) * SPACE; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
