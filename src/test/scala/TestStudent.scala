import org.junit.Assert.{assertEquals, assertTrue}
import org.junit.Test
import u04lab.code.{Course, Student}
import u04lab.code.List.*

class TestStudent:

  val student = Student("mario", 2015)
  val cPCD = Course("PCD", "Ricci")
  val cPPS = Course("PPS", "Viroli")

  @Test def testEnrolling() =
    student.enrolling(cPCD, cPPS)
    assertEquals(Cons("PCD", Cons("PPS", Nil())), student.courses)

  @Test def testHasTeacher() =
    student.enrolling(cPCD)
    assertTrue(student.hasTeacher("Ricci"))
