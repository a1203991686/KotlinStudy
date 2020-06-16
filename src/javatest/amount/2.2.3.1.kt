package javatest.amount

class vals(val a: Int = 5) {
    fun geta() : Int = a
}

fun varfun() : Int {
    var b = 10;
    return b;
}

var c = 15

fun main(args: Array<String>) {
    // println(a) // Unresolved reference: a
    println(vals().a)
    // println(b) // Unresolved reference: b
    println(varfun())
    println(c)
}