package f_C4_Item26.myTwoReadOnlyProperties

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

// Класс, реализующий интерфейс ReadOnlyProperty
class ComputedProperty<T>(private val initializer: () -> T) : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        // Если значение еще не вычислено, вычисляем его
            if (value == null) {
                value = initializer()
            }
        println("property.name: ${property.name}") //true
        return value!!
    }
}

// Использование ComputedProperty в классе
class Person(val firstName: String, val lastName: String, val city:String = "SPb", val street: String = "Nevskiy" ) {
    val fullName: String by ComputedProperty { "$firstName $lastName" }
    val address: String by ComputedProperty { "$city $street" }
}

fun main() {
    val person = Person("John", "Doe")
    println(person.fullName) // Вывод: John Doe
    println(person.address) // Вывод: John Doe
}

/*
property.name: fullName
John Doe
property.name: address
SPb Nevskiy
 */