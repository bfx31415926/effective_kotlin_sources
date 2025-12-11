/*
Коммнтарии ИИ:
--------------
Общая суть
Это — расширение (inline‑функция‑расширение) для типа CharSequence?, добавляющее метод isNullOrBlank(). Метод проверяет, является ли последовательность символов:

null или
пустой/состоящей только из пробельных символов (blank).
Разбор компонентов
1. Импорты и аннотация
kotlin
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
kotlin.contracts — пакет с экспериментальными контрактами Kotlin.
@OptIn — аннотация, разрешающая использование экспериментальных API (ExperimentalContracts). Без неё компилятор выдаст предупреждение.
2. Объявление функции
kotlin
inline fun CharSequence?.isNullOrBlank(): Boolean
inline — функция будет встроена в место вызова (оптимизация, избегает накладных расходов на вызов).
CharSequence? — приёмник расширения (может быть null).
isNullOrBlank() — имя метода.
Boolean — возвращаемый тип.
3. Контракт (ключевая часть)
kotlin
contract {
    returns(false) implies (this@isNullOrBlank != null)
}
Что это значит:

Если функция возвращает false, гарантируется, что this@isNullOrBlank != null.
Иными словами: если isNullOrBlank() == false, то объект точно не null.
Зачем нужен контракт?
Компилятор использует эту информацию для:

умного приведения типов (smart casts);
устранения лишних проверок на null в коде, использующем эту функцию.
4. Тело функции
kotlin
return this == null || this.isBlank()
Логика:

Если this == null → возвращаем true (объект null).
Иначе проверяем this.isBlank():
isBlank() — встроенный метод CharSequence, возвращает true, если строка пуста или состоит только из пробельных символов (пробелы, табуляции и т. п.).
Если хотя бы одно условие истинно → возвращаем true.
Пример использования
kotlin
val str: CharSequence? = "  Hello  "

if (!str.isNullOrBlank()) {
    // Компилятор *знает*, что str не null (благодаря контракту)!
    println(str.length)  // Можно безопасно использовать str
}
Без контракта компилятор потребовал бы явной проверки на null перед использованием str.length.

Итог
Функция isNullOrBlank() удобно проверяет null + «пустоту» строки.
Контракт даёт компилятору гарантию: если результат false, объект точно не null.
inline оптимизирует вызов.
@OptIn разрешает использование экспериментального API контрактов.
Это типичный пример использования контрактов в Kotlin для улучшения безопасности типов и читаемости кода.
 */
package C6_Item45.myFile1

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
inline fun CharSequence?.isNullOrBlank(): Boolean {
    contract {
        returns(false) implies (this@isNullOrBlank != null)
    }

    return this == null || this.isBlank()
}

fun main(){
    val str: CharSequence? = "  Hello  "

    if (!str.isNullOrBlank()) {
        // Компилятор *знает*, что str не null (благодаря контракту)!
        println(str.length)  // Можно безопасно использовать str
    }
}