package kotlinstudy

class Person {
    private var age: Int = 0
    private var name: Name = Name("William", "Shakespeare")

    inner class Name(val firstName: String, val lastName: String) {
        fun print() {
            println("$firstName $lastName's age is $age")
        }
    }
}