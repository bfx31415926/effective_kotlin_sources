package C7_Item51.maPage312_1

fun main() {
    repeat(10) {
        print(it)
        if(it >= 5)
            return // OK (Non-local return is allowed)
    }
}
/*
012345
 */
