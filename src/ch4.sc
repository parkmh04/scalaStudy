import java.sql.Timestamp
import java.util
import java.util.Collections
import java.util.concurrent.TimeUnit

def hi() = "hi"
hi()

def hi2(): String = "hi"
hi2()

def multiplier(x: Int, y: Int): Int = x * y
multiplier(3, 5)

def multiplier2(x: Int, y: Int): Int = {
  if (x != 3 && y != 5) x * y
  else 15
}
multiplier2(4, 8)

// 재귀도 가능하다. 재귀를 짜려면 이왕이면, 테일로 짜라
def zerox(x: Int): Int = {
  println(x)
  val y = x * x
  if (y < 10000) zerox(y)
  else y
}

// 매개변수가 단일일 경우, 표현식 블록을 사용할 수 있다.
zerox {
  val x = 3
  x - 1
}

// 재귀가 무한 반복되는 경우가 발생가능하다. 스택 오버 플로우!!
//def meron(x: Int): Int = {
//  Thread.sleep(1)
//  println(x)
//  if (x < 1) 1
//  else 1*  meron(x + 1)
//}
//meron(3)

// 아래는 스택오버플로우 발생 안함. 계쏙 스택을 재활용하기 때문에
//@annotation.tailrec
//def meronTail(x: Int): Int = {
//  println(x)
//  if (x < 1) 1
//  else meronTail(x + 1)
//}
//meronTail(1)


//중첩 함수
def max(x: Int, y: Int, z: Int): Int = {
  def max(x: Int, y: Int) = if (x > y) x else y

  max(max(x, y), z)
}

max(3, 4, 5)

// 기본값을 갖는 함수
def devri(x: String = "x", y: String) = f"x=$x, y=$y"

devri("1", "z")
devri(y = "z")

// 매개변수가 가변인 경우
def sum(nums: Int*) = {
  var sum = 0
  for (n <- nums) sum += n
  sum
}

sum(1, 2, 3, 4)

// 일반 함수 - 타입을 매번 지정해줘야하는데 여간 불편한 것이 아니다.
def identify(s: String): String = s
identify("String")
//identify(1)  <-- 에러가 발생한다.

// 타입을 매개변수화 한 함수
def nonIdentify[A](s: A) = s
nonIdentify[Double](1)
nonIdentify[String]("1")


// 다른 클래스가 제공하는 함수 호출
val flag = nonIdentify("end").endsWith("d")
val number = nonIdentify(3.0).+(2.0) // 연산자 표기법

/**
  * 자바와 동일한 주석 규격을 가지고 있다.
  *
  * @param name
  * @return
  */
def normal(name: String) = f"$name"


// 연습문제 1.
def getDiameter(radius: Double) = 2 * 3.14 * radius
getDiameter(3)

// 연습문제 2.
def getDiameter(radius: String) = 2 * 3.14 * radius.toDouble
getDiameter("3")
// getDiameter("") // 에러발생

// 연습문제 3. 중첩함수를 쓰는 패턴을 이용하자
@annotation.tailrec
def sumFive(num: Int): Unit = {
  println(num)
  val sum = num + 5
  if (sum <= 50) sumFive(sum)
}
sumFive(5)

// 연습문제 4.
def getDate(millisecond: Long) = new Timestamp(TimeUnit.MILLISECONDS.convert(millisecond, TimeUnit.MILLISECONDS)).toString() // 자바스러움
getDate(1182139200000L)

// 연습문제 5.
def getHuge(x: Int, y: Int): Int = math.pow(x, y).toInt
getHuge(2, 5)

def getHuge2(x: Int, y: Int): Int = {

  @annotation.tailrec
  def loop(y: Int, acc: Int): Int = {
    y match {
      case 0 => 1
      case 1 => acc
      case _ => loop(y - 1, acc * x)
    }
  }
  loop(y, 1)
}
getHuge2(2, 5)

// 연습문제 6.
val tupleX = (5, 10)
val tupleY = (1, 4)

def getDistance(x: Tuple2[Int, Int], y: Tuple2[Int, Int]): Double = {
  val a = x._1 - y._1
  val b = x._2 - y._2
  return Math.sqrt(a * a + b * b)
}
getDistance(tupleX, tupleY)

// 연습문제 7.
val tupleZ = ("1", 4)
def orderTuple(x:(Any, Any)): (Any, Any) = {
  if (x._2.isInstanceOf[Int]) (x._2, x._1)
  else x
}
orderTuple(tupleZ)


// 연습문제 8.
val tupleM = ("1", 4, 5f)
def makeTuple(tuple: (Any, Any, Any)) = {
  tuple.productIterator
       .map(v => (v, v.toString))
         .collect(Collections.list())
}
makeTuple(tupleM)