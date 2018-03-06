// 여러줄의 문자열
"""
  | Hello World!!!
  | Wha~..
  |
  |
"""

val input = "Enjoying this apple 3.14159 times today"
val pattern = """.* apple ([\d].+)times.*""".r  // 정규식이 책이 잘못된거 아닌가
val pattern(amountText) = input
val amount = amountText.toDouble

// Unit Type이라는 게 존재하는데, 여러모로 void와 비슷하단다. 아무 값도 반환하지 않는 타입
val nada = ()

// 튜플타입
val info = (5, "Koban", true) // 여러개의 타입을 동시에 사용가능.
info._1
info._2
info._3

// K,V 방식의 튜플을 생성하는 다른 방법
val anotherTuple = 5 -> "xx"

// 연습문제 1.
val first = 22.5
val second = (first * 9/5)
val third = second + 32

// 연습문제 2.
val start = 22.5
val notEnd = (start * 9/5)
val end = (notEnd + 32).toInt

// 연습문제 3.
val value = "2.7255"
val guzi = "$"

f"You owe  ${guzi}${value}."

// 연습문제 4.
val flag : Boolean = false;
val result : Boolean = (flag == false)

val simple = (flag == false)

// 연습문제 5.
val integer : Int = 128
val char : Char = integer.toChar
val string : String = char.toString
// val double : Double = string.toDouble //<-- Exception 발생

// 연습문제 6.
val text = "Frank, 123 Main, 925-555-1943,95122"
val regex = """\d{3}-\d{3}-\d{4}""".r
val phoneNumber : String = (regex findFirstIn(text)).get
val digits = phoneNumber.toCharArray
                        .filter(ch => ch != '-')
                        .map(ch=>ch.asDigit)
val pick = digits(2) // 요런건 그냥 [] 로 해주지..


