package C1_Item05.myFile2

fun largestOf(vararg nums: Int): Int =
    nums.maxOrNull()!!

fun main(){
    largestOf() //вызовет NullPointerException,
                // т.к. ghb отсутствиb параметров ф-я возвратит null
}