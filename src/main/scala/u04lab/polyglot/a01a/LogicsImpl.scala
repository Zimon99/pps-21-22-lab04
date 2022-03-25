package u04lab.polyglot.a01a
import Logics.*
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:

  private val random = Random ()
  private val isHorizontal: Boolean = random.nextBoolean() // Horizontal = true ! Vertical = false
  private val boardColStart: Int = random.nextInt(if isHorizontal then size - boat else size)
  private val boardRawStart: Int = random.nextInt(if isHorizontal then size else size - boat)
  private val FAILURES: Int = 5
  private var contHit: Int = 0
  private var contMiss: Int = 0

  def hit(row: Int, col: Int) =
      if checkCollision(row, col) then
        contHit = contHit + 1
        if contHit == boat then Result.WON else Result.HIT
      else
        contMiss = contMiss + 1
        if contMiss == FAILURES then Result.LOST else Result.MISS

  def checkCollision(row: Int, col: Int): Boolean =
    if isHorizontal then
      row == boardRawStart && col >= boardColStart && col < (boardColStart + boat)
    else
      col == boardColStart && row >= boardRawStart && row < (boardRawStart + boat)