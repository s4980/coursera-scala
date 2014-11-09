package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 | c == r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)

  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def checkParenthes(char: Char, count: Int): Int = {

      if (char == '(')
        count + 1
      else if (char == ')')
        count - 1
      else
        count
    }

    def loop(chars: List[Char], state: Int): Int = {

      if (chars.isEmpty)
        state
      else if (state == -1)
        -1
      else
        loop(chars.tail, (checkParenthes(chars.head, state)))
    }

    loop(chars, 0) == 0

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    var totalAmount: Int = 0;

    def check(money: Int, coins: List[Int]) {
      if (!coins.isEmpty) {
        if (money > coins.head) {
          check(money - coins.head, coins)
          check(money, coins.tail)
        } else if (money < coins.head) {
          check(money, coins.tail)
        } else if (money - coins.head == 0) {
          totalAmount += 1
        }
      }
    }
    check(money, coins.sorted)
    totalAmount
  }

}
