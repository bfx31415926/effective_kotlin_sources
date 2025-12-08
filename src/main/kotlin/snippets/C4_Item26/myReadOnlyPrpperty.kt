package f_C4_Item26.myReadOnlyProperty

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
        println(property.name == "fullName") //true
        return value!!
    }
}

// Использование ComputedProperty в классе
class Person(val firstName: String, val lastName: String) {
    val fullName: String by ComputedProperty { "$firstName $lastName" }
/*
если раскомментировать нижние две строки,
закомментировав верхнюю, мы получим тот же вывод
 */
//    val fullName
//        get() = firstName + " " + lastName

}
/*
Комментарий ИИ:
--------------
Да, в данном случае оба варианта будут выполнять одну и ту же функцию, создавая свойство fullName, которое объединяет firstName и lastName в одну строку. Однако есть некоторые нюансы, которые стоит учитывать:
1. Явное указание типа: В первом варианте fullName явно имеет тип String, поскольку используется делегат ComputedProperty. Во втором варианте тип будет выведен автоматически компилятором.
2. Ленивая вычисляемость: Если ComputedProperty реализует какую-то логику кэширования или ленивого вычисления, то при повторных обращениях к fullName результат может возвращаться быстрее. В вашем примере get() будет каждый раз пересчитывать значение при обращении к fullName.
3. Семантика и читаемость: Использование делегата может быть более семантически понятным в контексте вашего приложения, особенно если вы хотите явно указать, что это вычисляемое свойство.
4. Поддержка изменений: Если изменяются значения firstName или lastName, то оба варианта будут обновлять значение fullName на лету. Однако, если у вас есть какие-то дополнительные требования к обновлению или кэшированию, использование делегата может быть более предпочтительным.
В общем, если вам не нужны дополнительные функции, предоставляемые ComputedProperty, то оба варианта можно использовать взаимозаменяемо.
 */

fun main() {
    val person = Person("John", "Doe")
    println(person.fullName) // Вывод: John Doe
}
/*
true
John Doe
 */