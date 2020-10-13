package kotlinstudy

import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.io.Serializable

/**
 *
 * @author littlecorgi
 * @date 2020/10/13
 */
class Person(
    val name: String = "123",
    val age: Int = 12,
    val address: String = "Shannxi",
    val sex: Boolean = true,
    val stupid: Boolean = true
) : Serializable {
    companion object {
        private const val serialVersionUID = 12345148423148975L
    }

    override fun toString(): String {
        return "Person(name='$name', age=$age, address='$address', sex=$sex, stupid=$stupid)"
    }

    // override fun toString(): String {
    //     return "Person(name='$name', age=$age, address='$address', sex=$sex)"
    // }


}

fun main() {
    // val a = Person("王埃及", 21, "西安邮电大学", false)
    // val objectOutputStream = ObjectOutputStream(FileOutputStream(File("Test.txt")))
    // objectOutputStream.writeObject(a)
    // objectOutputStream.close()

    val objectInputStream = ObjectInputStream(FileInputStream(File("Test.txt")))
    val person = objectInputStream.readObject() as Person
    println(person.toString())
}