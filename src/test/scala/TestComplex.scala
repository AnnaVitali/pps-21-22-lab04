import org.junit.*
import org.junit.Assert.*
import u04lab.code.{Complex}

class TestComplex:

  val a = Array(Complex(10, 20), Complex(1, 1), Complex(7, 0))

  @Test def testSum() =
    val c = a(0) + a(1) + a(2)
    assertEquals((Complex(18.0,21.0),18.0,21.0), (c, c.re, c.im))

  @Test def testProduct() =
    val c = a(0) * a(1)
    assertEquals((Complex(-10.0,30.0),-10.0,30.0), (c, c.re, c.im))