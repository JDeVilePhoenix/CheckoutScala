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

  // step 2: Simple offers
  @Test def applyBogofDeal_whenCorrectDeductionCalculated_valueDoesMatchWithinDelta = {
    val cart = List("Apple", "Apple", "Orange", "Apple")
    val total = checkout.calculateTotal(cart) - checkout.applyBogofDeal("Apple", cart)
    assertEquals(1.45f, total, 0.001f)
  }

  @Test def applyBogofDeal_whenListEmpty_valueDoesMatch = {
    val cart = List()
    val total = checkout.calculateTotal(cart) - checkout.applyBogofDeal("Apple", cart)
    assertEquals(0, total, 0)
  }

  @Test def applyTheeForTwoDeal_whenCorrectDeductionCalculated_valueDoesMatchWithinDelta = {
    val cart = List("Orange", "Orange", "Orange", "Apple")
    val total = checkout.calculateTotal(cart) - checkout.applyThreeForTwoDeal("Orange", cart)
    assertEquals(1.10f, total, 0.001f)
  }

}