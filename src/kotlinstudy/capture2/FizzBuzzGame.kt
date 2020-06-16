package kotlinstudy.capture2

/**
 * 2.4.2
 *
 * @author littlecorgi - tianweikang
 * @data 2020/03/23 11:33
 */
fun main() {
    // for (i in 1..100) {
    //     println(fizzBuzz(i))
    // }

    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }
    val list = arrayListOf(1, 2, 3)
    val set = setOf<String>("apple", "big", "current")
    println(set.max())
}

fun fizzBuzz(num: Int) =
    when {
        (num % 15 == 0) -> {
            "FizzBuzz"
        }
        (num % 5 == 0) -> {
            "Buzz"
        }
        (num % 3 == 0) -> {
            "Fizz"
        }
        else -> {
            "$num"
        }
    }