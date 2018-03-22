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

// 재귀도 가능하다.
def zerox(x: Int): Int = {
  println(x)
  val y = x * x
  if (y < 10000) zerox(y)
  else y
}

// 매개변수가 단일일 경우, 표현식 블록을 사용할 수 있다.
zerox {
  val x = 3; x - 1
}

// 재귀가 무한 반복되는 경우가 발생가능하기 때문에 컴파일 시점에서 이를 판단할 수 있는 꼬리 재귀 함수
// 컴파일 에러가 발생할 줄 알았으나, 발생 안함.. 왜 그럴까??
@annotation.tailrec
def meron(x: Int): Int = {
  println(x)
  if (x < 1) 1
  else meron(x + 1)
}

meron(1)
