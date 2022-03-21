package u04lab.polyglot.a01a
import Logics.*
import scala.util.Random

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:

  private val random = Random ()
  private val randomWithSeed = Random (42)
  private val vertOrHoriz: Int = random.nextInt(2) // Horizontal = 0 ! Vertical = 1
  private val boardColStart: Int = random.nextInt(if vertOrHoriz == 0 then size - boat else size)
  private val boardRawStart: Int = random.nextInt(if vertOrHoriz == 0 then size else size - boat)
  private val FAILURES: Int = 5
  private var contHit: Int = 0
  private var contMiss: Int = 0

  def hit(row: Int, col: Int) =
      if checkCollision(row, col) then
        this.contHit = this.contHit + 1
        if this.contHit == boat then Result.WON else Result.HIT
      else
        this.contMiss = this.contMiss + 1
        if this.contMiss == FAILURES then Result.LOST else Result.MISS

  def checkCollision(row: Int, col: Int): Boolean =
    if this.vertOrHoriz == 0 then
      row == boardRawStart && col >= boardColStart && col < (boardColStart + boat)
    else
      col == boardColStart && row >= boardRawStart && row < (boardRawStart + boat)

/*
println("Boat row --> " + boardRawStart)
println("Boat column --> " + boardColStart)
println(if vertOrHoriz == 0 then "Horizzontal" else "Vertical")
*/