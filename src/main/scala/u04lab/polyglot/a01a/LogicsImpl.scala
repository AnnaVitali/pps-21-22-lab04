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

  def hit(row: Int, col: Int): Result = row == this.boatRow && col >= this.boatLeftCol && col < (this.boatLeftCol + boat) match
    case true =>
      hits = append(hits, Cons(Tuple2(row,col), Nil()))
      length(hits).equals(boat) match
        case true => Result.WON
        case _ => Result.HIT
    case _ =>
      failures = failures + 1
      failures.equals(maxFailure) match
        case true => Result.LOST
        case _ => Result.MISS


