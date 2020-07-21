package kotlinstudy

import kotlin.reflect.KProperty

class Main {

    val p: String by Delegate()

    companion object {
        @JvmStatic
        fun a() {

        }
        fun b() {

        }
    }

    fun String.inAdd(s: String?): String {
        println("测试 委托属性")
        println(p)
        println(p.length)
        println("***************")
        var a: String = ""
        val b: Int by lazy { 1 }
        println(b)
        val letLength = s.let {
            val temp = 1
            if (length == temp) {
                temp
            } else {
                length
            }
            println(this.javaClass.name + " this $this")
            println(it?.javaClass?.name + " it $it")
            isEmpty()
        }
        val withLength = with(s) {
            length
        }
        val runLength = s.run {
            length
        }
        val applyLength = s?.apply {
            length
        }
        val alsoLength = s?.also {
            length
        }
        println(letLength.javaClass.name + letLength)
        println(withLength.javaClass.name + withLength)
        println(runLength.javaClass.name + runLength)
        println(applyLength?.javaClass?.name + applyLength)
        println(alsoLength?.javaClass?.name + alsoLength)
        return "$this$a"
    }

    fun add1(s: String) {
        val letLength = s.let {
            val temp = 1
            if (it.length == temp) {
                temp
            } else {
                it.length
            }
            println(this.javaClass.name + " this $this")
            println(it.javaClass.name + " it $it")
            it.isEmpty()
        }
        val withLength = with(s) {
            length
        }
        val runLength = s.run {
            length
        }
        val applyLength = s.apply {
            length
        }
        val alsoLength = s.also {
            it.length
        }
        println(letLength.javaClass.name + letLength)
        println(withLength.javaClass.name + withLength)
        println(runLength.javaClass.name + runLength)
        println(applyLength?.javaClass?.name + applyLength)
        println(alsoLength?.javaClass?.name + alsoLength)
    }

    fun main() {
        println("a".add("b"))
        println("a".inAdd("123"))
    }

    fun mainNull(): String? {
        return null
    }
}

fun main() {
    val main = Main()
    main.main()
    val a = main::class
    val b = main.javaClass
    val c = main::class.java
    val d = main::javaClass
    val e = d.get()
    val f = main.javaClass.kotlin
}

fun String.add(s: String): String {
    return "$this$s"
}

private fun add() {

}

val a = "123"
private val privateA = "123"
public val publicA = "123"

@JvmField
public val publicFieldA = "123"
private var privateVarA = "123"
public var publicVarA = "123"
internal var internalVarA = "123"

object Main1 {

    private val a = 1
    public val b = 1

    @JvmStatic
    fun String.add1(s: String): String {
        return "$this$s"
    }

    fun String.add(s: String): String {
        return "$this$s"
    }

    @JvmStatic
    private fun add1() {

    }

    private fun add() {

    }
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}