package syntactic

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashSet

/**
 * 用~代替空
 * @author littlecorgi
 * @date 2020-04-03 23:41
 */

/**
 * first集
 */
val first = mutableMapOf<String, MutableSet<Char>>()

/**
 * follow集
 */
val follow = mutableMapOf<String, MutableSet<Char>>()

/**
 * select集
 */
val select = mutableMapOf<String, MutableSet<Char>>()

/**
 * 当前非终结符在VN_set中的位置
 */
val vnDic = mutableMapOf<String, Int>()

/**
 * 非终结符的集合
 */
val vnSet = ArrayList<Grammar>()

/**
 * 记录当前非终结符是否已经分析过了
 */
val used = arrayOfNulls<Boolean>(500)

/**
 * 预测分析表
 */
val predictTable = ArrayList<LinkedHashMap<Char, String>>()

fun main() {
    val n: Int
    var s: String
    val sc = Scanner(System.`in`)
    // 输入的n为此次文法的条数
    n = sc.nextInt()
    // 通过循环逐条录入此次的所有文法
    for (i in 0 until n) {
        s = sc.next()
        // 以->分隔出左部分和右部分
        val str0 = s.split("->")
        if (vnDic[str0[0]] == 0 || vnDic[str0[0]] == null) {
            // 将非终结符存入VN_set以及WF的left
            vnSet.add(Grammar(str0[0]))
            vnDic[str0[0]] = vnSet.size
        }
        // 将文法右边存入WF的right
        val x = vnDic[str0[0]]!! - 1
        val str1 = str0[1].split('|')
        for (j in str1) {
            vnSet[x].insert(j)
        }
    }

    // 判断是否存在左递归
    if (hasLeftRecursion()) {
        println("存在左递归")
        println("去除左递归:")
        solveLeftRecursion()

    } else {
        println("不存在左递归")
    }

    for (i in vnSet.indices) {
        first[vnSet[i].left] = LinkedHashSet()
        follow[vnSet[i].left] = LinkedHashSet()
        print("main()-> 输出${vnSet[i].left}的right：")
        for (l in vnSet[i].right.indices) {
            print(" ${vnSet[i].right.elementAt(l)},")
        }
        println()
    }

    // 构建First集
    makeFirst()
    // 构建Follow集
    makeFollow()
    // 构建预测分析表
    makeTable()
}