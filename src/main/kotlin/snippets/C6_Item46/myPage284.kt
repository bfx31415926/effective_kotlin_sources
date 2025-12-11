package C6_Item46.myPage284

class PhoneBookIncorrect {
    fun verify(number: String): Boolean {
        require(number.isPhoneNumber())
        return true
    }

    // Bad practice, do not do this
    fun String.isPhoneNumber(): Boolean =
        this.length == 7 && this.all { it.isDigit() }
}

fun main(){
//    val refX = PhoneBookIncorrect::isPhoneNumber // ERROR
                                    //    (при раскомментировании получим ощмбку)
    val book = PhoneBookIncorrect()
//    val boundedRefX = book::isPhoneNumber        // ERROR
                                    //    (при раскомментировании получим ощмбку)

 }
