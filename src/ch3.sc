import com.sun.tools.doclets.internal.toolkit.util.DocFinder.Input

// 조건식 : 삼항식이 없단다...
val x = 5;
val y = 4;
val max = if (x > y) x + y else x - y;
val min = if (x > y) x + y else {
  if (x > 0) x - y else x * y
};

// 매치 표현식
val maxmax = x > y match {
  case true => x + y
  case false => x - y
}

val maxmaxmax = x + y match {
  case 5 => {
    println("55555")
    5
  }
  case 9 => {
    println("99999")
    9
  }
}

val day = "MON"
val week = day match {
  case "MON" | "TUS" | "WED" | "THR" | "FRI" => {
    println("WEEK!")
  }
  case "SAT" | "SUN" => {
    println("WEEKEND!")
  }
}

// 와일드카드 매칭
val day2 = "SUN"
val week2 = day2 match {
  case "MON" | "TUS" | "WED" | "THR" | "FRI" => {
    println("WEEK!")
  }
  case _ => {
    println("WEEKEND!")
  }
}

val day3 = "SUN"
val week3 = day3 match {
  case "MON" | "TUS" | "WED" | "THR" | "FRI" => {
    println("WEEK!")
  }
  case other => {
    println("WEEKEND!")
  }
}

// 패턴 가드
val response: String = null
response match {
  case s if s != null => println(s"${s} is not null.");
  case s => println(s"${s} is null.");
}


// Loop
for (x <- 1 to 7) println(s"You owe ${x}.")

// Yield
val xx = for (x <- 1 to 7) yield s"You owe  ${x}."
println(xx(0));

// Loop by Any
for (x <- xx) yield s"Important thing is ${x}."

// Loop Guard
val threes = for (inx <- 1 to 30 if inx % 3 == 0) yield inx
val quote = "Faith, Hope,, Charity"
val quoteArr = for (quote <- quote.split(",") if quote != null if quote.size > 0) yield quote // 조건을 여러개 중첩가능

// Loop two
val something = for {inx <- 2 to 4
                     jnx <- 1 to 9;
                     multi = inx * jnx} {
  println(s"${inx} * ${jnx} = ${multi}")
};

// 연습문제 1.
val name = ""
name match {
  case s if s != null && s.size > 0 => s
  case other => "n/a"
}

// 연습문제 2.
val amount: Double = -1
amount match {
  case d if d > 0 => "greater"
  case d if d == 0 => "same"
  case d if d < 0 => "less"
}
println(amount)

// 연습문제 3.
val inputs = List("cyan", "magenta", "yellow")
val converted = inputs.map(s => s match {
  case "cyan" => "#00FFFF"
  case "magenta" => "#FF00FF"
  case "yellow" => "#FFFF00"
  case _ => "#FFFFFF"
})
println(converted)

val converted2 = for (input <- inputs) yield
  input match {
    case "cyan" => "#00FFFF"
    case "magenta" => "#FF00FF"
    case "yellow" => "#FFFF00"
    case _ => "#FFFFFF"
  }
println(converted2)

// 연습문제 4.
val numbers = for (i <- 1 to 100) {
  print(s"${i}, ")
  if (i % 5 == 0) println()
}

val numbers_1 = (1 to 100).foreach(i => {
  print(s"${i}, ")
  if (i % 5 == 0) println()
})

// 연습문제 5.
val numbers2 = (for (i <- 1 to 100) yield
  i match {
    case i if i % 3 == 0 && i % 5 == 0 => "typesafe"
    case i if i % 3 == 0 => "type"
    case i if i % 5 == 0 => "safe"
    case _ => ""
  }).foreach(i =>println(i))
val numbers22 = for (i <- 1 to 100)
  i match {
    case i if i % 15 == 0 => println("typesafe")
    case i if i % 3 == 0 => println("type")
    case i if i % 5 == 0 => println("safe")
    case _ =>
}

// 연습문제 6.
val numbers3 = for (i <- 1 to 100) if (i % 3 == 0 && i % 5 == 0) println("typesafe") else if (i % 3 == 0) println("type") else if (i % 5 == 0) println("safe")
val isSame = numbers2 == numbers3

//val numbers4 = (1 to 100).foreach(i => println(if (i % 15 == 0) "typesafe" else if (i % 3 == 0) "type" else if (i % 5 == 0) "safe"))

def conv(s:Int) = s match {
  case 0 => "a"
  case 2 => "b"
}
conv(3)
