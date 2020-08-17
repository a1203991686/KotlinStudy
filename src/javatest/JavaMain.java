package javatest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Launcher;

import java.math.BigInteger;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

class JavaMain {
    static {
        System.out.println("JavaMain Static 1");
    }

    {
        System.out.println("JavaMain 1");
    }

    public JavaMain() {
        System.out.println("JavaMain Constructor");
    }

    static {
        System.out.println("JavaMain Static 2");
    }

    {
        System.out.println("JavaMain 1");
    }

    public static BigInteger test(int a) {
        if (a == 0) {
            return BigInteger.ONE;
        }
        BigInteger temp = BigInteger.valueOf(a).multiply(test(a - 1));
        return temp;
    }

    public static void nullableTest(@Nullable String a) {
        System.out.println(a);
    }

    public static void nonTest(@NotNull String a) {
        System.out.println(a);
    }

    // public static void main(String[] args) {
    //     // nullableTest(null);
    //     // nonTest(null);
    //     // System.out.println(test(100000));
    //
    // }
}

class ExtendsJavaMain extends JavaMain {
    static {
        System.out.println("ExtendsJavaMain Static 1");
    }

    {
        System.out.println("ExtendsJavaMain 1");
    }

    public ExtendsJavaMain() {
        System.out.println("ExtendsJavaMain Constructor");
    }

    static {
        System.out.println("ExtendsJavaMain Static 2");
    }

    {
        System.out.println("ExtendsJavaMain 1");
    }
}

class ListNode {
    private int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode reverseList(ListNode root) {
        // 如果当前节点已经是最后了，那么就直接返回即可，代表递归的终点
        if (root == null || root.next == null) {
            return root;
        }
        /*
         * pre指向当前节点的前一个节点
         * cur指向当前节点
         * tmp指向当前节点的下一个节点，做一个临时保存，
         *      因为pre和cur的指向会反转，那么在交换完成之后，cur的next就变成了pre，那么就无法继续遍历原链表剩下部分了
         * 每次就让pre和cur的指向互换，也就是cur.next指向pre，然后再跳转到tmp，进行下一次交换，如此重复，即可完成翻转
         */
        ListNode pre = null;
        ListNode cur = root;
        ListNode tmp = null;
        while (cur != null) {
            // 纪录下该节点的下一个节点
            tmp = cur.next;
            // 然后将当前节点指向pre
            cur.next = pre;
            // pre和cur都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // /**
    //  * 直接通过递归到队尾，然后再从队尾开始挨个元素将指针反转，最后递归完成，也就完成整个链表的反转了
    //  */
    // public static ListNode reverseList(ListNode root) {
    //     // 如果当前节点已经是最后了，那么就直接返回即可，代表递归的终点
    //     if (root == null || root.next == null) {
    //         return root;
    //     }
    //     // 进行递归
    //     ListNode cur = reverseList(root.next);
    //     // 先将他的下一个节点的next指向自己，也就翻转了
    //     root.next.next = root;
    //     // 防止产生链表循环
    //     root.next = null;
    //     // 每层都返回一个cur，也就是当前正在操作的节点
    //     return cur;
    // }

    public static void main(String[] args) {
        ListNode c = new ListNode(3, null);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        ListNode temp = reverseList(a);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}