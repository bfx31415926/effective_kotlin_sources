package f_C7_Item52.s_5

@JvmInline
value class StudentId(val value: String)

@JvmInline
value class ClassId(val value: String)

data class Student(val id: StudentId, val classId: ClassId)

fun main() {
    println( Student(StudentId("123"), ClassId("456")))
}
/*
Student(id=StudentId(value=123), classId=ClassId(value=456))
 */