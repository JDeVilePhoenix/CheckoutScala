import org.junit._
import org.junit.Assert._

class CheckoutTests {
  val checkout = new Checkout

  // step 1: Shopping cart
  @Test def calculateTotal_whenCorrectTotalReturned_valueDoesMatchWithinDelta = {
    val cart = List("Apple", "Apple", "Orange", "Apple")
    val total = checkout.calculateTotal(cart)
    assertEquals(2.05f, total, 0.001f)
  }

  @Test def calculateTotal_whenListEmpty_valueDoesMatch = {
    val cart = List()
    val total = checkout.calculateTotal(cart)
    assertEquals(0, total, 0)
  }

  @Test def calculateTotal_whenListElementsIncorrect_valueDoesMatch = {
    val cart = List("Apple", "Aple", "Orang", "pple")
    val total = checkout.calculateTotal(cart)
    assertEquals(0, total, 0)
  }
