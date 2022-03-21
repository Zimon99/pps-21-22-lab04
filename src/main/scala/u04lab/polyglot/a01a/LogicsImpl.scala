package u04lab.polyglot.a01a
import Logics.*
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:

  val random = Random ()
  val randomWithSeed = Random (42)

  var boardColStart = random.nextInt(size - boat)
  var boardRawStart = random.nextInt(size)

  println("Riga nave --> " + boardRawStart)
  println("Colonna nave --> " + boardColStart)

  def hit(row: Int, col: Int) =
    if row == boardRawStart && col >= boardColStart && col < (boardColStart + boat) then Result.HIT else Result.MISS


