package lexical

import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

/**
 * @author littlecorgi - tianweikang
 * @data 2020/03/30 09:04
 */

private val keyword = arrayOf(
    "auto", "break", "case", "char", "const", "continue", "default", "do", "double",
    "else", "enum", "extern", "float", "for", "goto", "if", "include", "int", "long", "register",
    "return", "short", "signed", "sizeof", "static", "struct", "switch", "typedef", "printf",
    "union", "unsigned", "void", "volatile", "while"
) // 关键字
private val arithmeticOperators = arrayOf(
    "+", "-", "*", "/", "++", "--"
)  // 算术运算符
private val comparisonOperator = arrayOf(
    "<", "<=", "=", ">", ">=", "<>", "==", "!="
) // 比较运算符
private val separator = arrayOf(
    ",", ";", ":=", ".", "(", ")", "[", "]", "{", "}"
) // 分隔符
private val otherOperator = arrayOf(
    "%", "$", "^", "&", "_", "#", "[]"
) //特殊标识符
private val commentOperator = arrayOf(
    "//", "/*", "*/"
) //注释符
private val logicalOperators = arrayOf(
    "&&", "||", "!"
) //逻辑运算符

private val keywords = mutableSetOf<String>()
private val operators = mutableSetOf<String>()
private val variables = mutableListOf<String>()
private val nums = mutableListOf<String>()

/**
 * 特殊符号
 * 设定此数组时因为存在某些符号，他自己就可以作为一个符号，同时他和其他符号连在一起也可以作为一个符号
 * eg:
 *  [ []
 *  + ++
 *  - --
 *  / //
 *  / \/\*
 *  * *\/
 *  ! !=
 */
private val specialCharacter = arrayOf(
    "+", "-", "<", ">", "=", "!", ":", "[", "(", "/", "*", "&", "|"
)

private var fr: FileReader? = null
private var fw: FileWriter? = null

fun search(searchStr: String, wordType: Int): Boolean //符号匹配
{
    var i: Int
    when (wordType) {
        1 -> {
            i = 0
            while (i < keyword.size) {
                if (searchStr == keyword[i]) {
                    return true
                }
                i++
            }
        }
        2 -> {
            i = 0
            while (i < arithmeticOperators.size) {
                if (searchStr == arithmeticOperators[i]) {
                    return true
                }
                i++
            }
        }
        3 -> {
            i = 0
            while (i < comparisonOperator.size) {
                if (searchStr == comparisonOperator[i]) {
                    return true
                }
                i++
            }
        }
        4 -> {
            i = 0
            while (i < separator.size) {
                if (searchStr == separator[i]) {
                    return true
                }
                i++
            }
        }
        5 -> {
            i = 0
            while (i < otherOperator.size) {
                if (searchStr == otherOperator[i]) {
                    return true
                }
                i++
            }
        }
        6 -> {
            i = 0
            while (i < commentOperator.size) {
                if (searchStr == commentOperator[i]) {
                    return true
                }
                i++
            }
        }
        7 -> {
            i = 0
            while (i < logicalOperators.size) {
                if (searchStr == logicalOperators[i]) {
                    return true
                }
                i++
            }
        }
        8 -> {
            i = 0
            while (i < specialCharacter.size) {
                if (searchStr == specialCharacter[i]) {
                    return true
                }
                i++
            }
        }
    }
    return false
}


@Throws(IOException::class)
private fun letterProcess(ch: Char): Int { // 字母处理程序
    var str = ch
    val letter = StringBuilder()
    while (Character.isAlphabetic(str.toInt()) || Character.isDigit(str)) {
        letter.append(str)
        str = fr!!.read().toChar()
    }
    if (search(letter.toString(), 1)) {
        println("< $letter , 关键字 >")
        fw!!.write("< $letter , 关键字 >\n")
        keywords.add(letter.toString())
    } else {
        println("< $letter , 自定义变量 >")
        fw!!.write("< $letter , 自定义变量 >\n")
        variables.add(letter.toString())
    }
    return str.toInt()
}

private fun digitProcess(ch: Char): Int {
    var str = ch
    val num = java.lang.StringBuilder()
    while (str.isDigit()) {
        num.append(str)
        str = fr!!.read().toChar()
    }
    if (str.isLetter()) { //数字后面是字符
        while (!str.isWhitespace()) {
            num.append(str)
            str = fr!!.read().toChar()
        }
        println("错误！非法标识符： $num ")
        fw!!.write("错误！非法标识符： $num \n")
        return str.toInt()
    }
    println("< $num , 数字 >")
    fw!!.write("< $num , 数字 >\n")
    nums.add(num.toString())
    return str.toInt()
}

private fun otherProcess(ch: Char): Int {
    var str = ch
    val other = StringBuilder()
    if (str.isWhitespace()) {
        str = fr!!.read().toChar()
        return str.toInt()
    }
    while (!str.isWhitespace() && !str.isLetterOrDigit() && other.length < 2) {
        other.append(str)
        if (other.length == 1) {
            if (!search(other.toString(), 8)) {
                str = fr!!.read().toChar()
                break
            }
        }
        str = fr!!.read().toChar()
    }
    when {
        search(other.toString(), 2) -> {
            println("< $other , 算数运算符 >")
            fw!!.write("< $other , 算数运算符 >\n")
            operators.add(other.toString())
        }
        search(other.toString(), 3) -> {
            println("< $other ,关系运算符 >")
            fw!!.write("< $other ,关系运算符 >\n")
            operators.add(other.toString())
        }
        search(other.toString(), 4) -> {
            println("< $other ,分隔符 >")
            fw!!.write("< $other ,分隔符 >\n")
            operators.add(other.toString())
        }
        search(other.toString(), 5) -> {
            println("< $other ,特殊标识符 >")
            fw!!.write("< $other ,特殊标识符 >\n")
            operators.add(other.toString())
        }
        search(other.toString(), 6) -> {
            if (other.toString() == "/*") {
                while (other.toString().substring(other.length - 2, other.length) != "*/") {
                    str = fr!!.read().toChar()
                    other.append(str)
                }
                str = fr!!.read().toChar()
            } else if (other.toString() == "//") {
                while (other.toString().last() != '\n') {
                    str = fr!!.read().toChar()
                    other.append(str)
                }
                str = fr!!.read().toChar()
            }
        }
        search(other.toString(), 7) -> {
            println("< $other ,逻辑运算符 >")
            fw!!.write("< $other ,逻辑运算符 >\n")
            operators.add(other.toString())
        }
        else -> {
            if (other.length >= 2) {
                for (i in other.indices) {
                    when {
                        search(other[i].toString(), 2) -> {
                            println("< ${other[i]} , 算数运算符 >")
                            fw!!.write("< ${other[i]} , 算数运算符 >\n")
                            operators.add(other[i].toString())
                        }
                        search(other[i].toString(), 3) -> {
                            println("< ${other[i]} ,关系运算符 >")
                            fw!!.write("< ${other[i]} ,关系运算符 >\n")
                            operators.add(other[i].toString())
                        }
                        search(other[i].toString(), 4) -> {
                            println("< ${other[i]} ,分隔符 >")
                            fw!!.write("< ${other[i]} ,分隔符 >\n")
                            operators.add(other[i].toString())
                        }
                        search(other[i].toString(), 5) -> {
                            println("< ${other[i]} ,特殊标识符 >")
                            fw!!.write("< ${other[i]} ,特殊标识符 >\n")
                            operators.add(other[i].toString())
                        }
                        search(other[i].toString(), 6) -> {
                            println("< ${other[i]} ,注释符 >")
                            fw!!.write("< $${other[i]} ,注释符 >\n")
                            operators.add(other[i].toString())
                        }
                        search(other[i].toString(), 7) -> {
                            println("< ${other[i]} ,逻辑运算符 >")
                            fw!!.write("< ${other[i]} ,逻辑运算符 >\n")
                            operators.add(other[i].toString())
                        }
                        else -> {
                            println("错误！非法字符： ${other[i]}")
                            fw!!.write("错误！非法字符： ${other[i]}\n")
                        }
                    }
                }
            } else {
                println("错误！非法字符： $other")
                fw!!.write("错误！非法字符： $other\n")
            }
        }
    }
    return str.toInt()
}

fun main() {
    try {
        fr = FileReader("/Users/littlecorgi/Documents/Java/idea/KotlinStudy/src/lexical/源程序.txt")
        fw = FileWriter("/Users/littlecorgi/Documents/Java/idea/KotlinStudy/src/lexical/结果.txt")
        var ch = fr!!.read()
        var str: Char
        while (ch != -1 && ch.toChar().isDefined()) {
            str = ch.toChar()
            ch = when {
                str.isLetter() -> letterProcess(str) // 处理字母
                str.isDigit() -> digitProcess(str) // 处理数字
                else -> otherProcess(str) // 处理字符(符号)
            }
        }

        fw!!.append("\n关键字: \n")
        for (i in keywords) {
            fw!!.append("$i, ")
        }
        fw!!.append("\n")

        fw!!.append("运算符: \n")
        for (i in operators) {
            fw!!.append("$i, ")
        }
        fw!!.append("\n")

        fw!!.append("变量: \n")
        for (i in variables) {
            fw!!.append("$i, ")
        }
        fw!!.append("\n")

        fw!!.append("常数: \n")
        for (i in nums) {
            fw!!.append("$i, ")
        }
        fw!!.append("\n")

        fr!!.close()
        fw!!.flush()
        fw!!.close()
    } catch (e: IOException) {
        e.printStackTrace()
        println("源程序无法打开")
    }
}
