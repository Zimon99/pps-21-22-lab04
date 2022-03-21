package u04lab.code

trait Complex:
  def re: Double
  def im: Double
  def +(c: Complex): Complex // should implement the sum of two complex numbers..
  def *(c: Complex): Complex // should implement the product of two complex numbers

object Complex:
  def apply(re: Double, im: Double): Complex = ComplexImpl(re, im)

case class ComplexImpl(override val re: Double, override val im: Double) extends Complex:
  override def +(c: Complex): Complex = Complex(c.re + re, c.im + im)
  override def *(c: Complex): Complex = Complex(c.re * re - c.im * im, c.re * re + c.im * im)

@main def checkComplex(): Unit =
  val a = Array(Complex(10, 20), Complex(1, 1), Complex(7, 0))
  val c = a(0) + a(1) + a(2)
  println((c, c.re, c.im)) // (ComplexImpl(18.0,21.0),18.0,21.0)
  val c2 = a(0) * a(1)
  println((c2, c2.re, c2.im)) // (ComplexImpl(-10.0,30.0),-10.0,30.0)*/

  // Check that equality and toString do not work (run without case in definition of ComplexImpl class).
  println(Complex(10,10)) // u04lab.code.ComplexImpl@262b2c86
  println(Complex(10,10) == Complex(10,10)) // False


/** Hints:
  *   - implement Complex with a ComplexImpl class, similar to PersonImpl in slides
  *   - check that equality and toString do not work
  *   - use a case class ComplexImpl instead, creating objects without the 'new' keyword
  *   - check equality and toString now
  */





