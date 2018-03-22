object Hello extends App {

  //@annotation.tailrec
  def meron(x: Int): Int = {
    Thread.sleep(1)
    println(x)
    if (x < 1) 1
    else 1*  meron(x + 1)
  }

  meron(3)
}
