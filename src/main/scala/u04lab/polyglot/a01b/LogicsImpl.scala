package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.OptionToOptional
import u04lab.code.Option
import u04lab.code.Option.*
import u04lab.code.List
import u04lab.code.List.*
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a05b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:

  // Logics of this implement
  // Example of field with size = 3 and mines = 2
  //
  //  0  1  2      When hit is called i 'translate' the coordinates with this formula: row * size + column
  //  3  4  5      For example:
  //  6  7  8          row = 1 | column = 2 ---> 1 * 3 + 2 = 5

  private val random = Random ()
  private var minesPos: List[Int] = Nil()
  private var contNiceShot: Int = 0

  while (length(minesPos) != mines)
    if !contains(minesPos, random.nextInt(size * size)) then
      minesPos = append(minesPos, Cons(random.nextInt(size * size), Nil()))

  def hit(x: Int, y: Int): java.util.Optional[Integer] =
    if !contains(minesPos, y * size + x) then
      contNiceShot = contNiceShot + 1
      OptionToOptional(Some(y * size + x))
    else
      OptionToOptional(None()) // Lose

  def won = contNiceShot == (size * size - mines)