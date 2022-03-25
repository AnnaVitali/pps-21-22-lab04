package u04lab.polyglot.a01a
import Logics.*

import u04lab.code.List.*
import scala.util.Random


/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01a/sol2/ */
class LogicsImpl(private val size: Int, private val boat: Int) extends Logics:
  private val maxFailure: Int = 5
  private var hits: u04lab.code.List[Tuple2[Int, Int]] = Nil()
  private val r: Random = Random(size)
  private val boatRow: Int = r.nextInt(size)
  private val boatLeftCol: Int = r.nextInt(size - boat);
  private var failures: Int = 0;

  def hit(row: Int, col: Int): Result =
    if row == this.boatRow && col >= this.boatLeftCol && col < (this.boatLeftCol + boat) then
      hits = append(hits, Cons(Tuple2(row,col), Nil()))
      if length(hits).equals(boat) then Result.WON else Result.HIT
    else
      failures = failures + 1
      if failures.equals(maxFailure) then Result.LOST else Result.MISS


