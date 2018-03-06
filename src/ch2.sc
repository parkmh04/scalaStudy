var x: Int = 5
var res0 = x
var res1 = x * 2
var res2 = x / 5
var res3 = res0 * res1

var a : Double = x
var b : Int = a.toInt

println(s"Pi, using $x*2, is about $res1") // 문자열 보간
f"$x = $x / $res0"  // 문자열 보간

val input = "Enjoying this apple 3.14159 times today"
val pattern = """.* apple ([\d].+)times.*""".r
val pattern(amountText) = input
val amount = amountText.toDouble


