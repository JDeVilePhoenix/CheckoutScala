import java.text.DecimalFormat

class Checkout {
  private val products = Map("Apple" -> 0.60f, "Orange" -> 0.25f)

  // step 1: Shopping cart
  // A more scalable solution, can accept any number of mapped products.
  // Takes a list of string product names and compares each element with the products map
  // totaling the associated price of the mapped product if an empty list is passed or an incorrect
  // product name the function returns 0.
  def calculateTotal(cart:List[String]): Float = {
    var total = 0f
    if (cart.nonEmpty) try {
      for (elem <- cart) {
        total += products(elem)
      }
      return total
    } catch {
      case e: NoSuchElementException => println("Unmapped product or spelling error: " + e)
        return 0f
    }
    else
      return total
  }

  // step 2: Simple offers, implemented to be used with any item
  // Takes an string and a list of strings, uses the List count function
  // to count the passed in item and returns the amount to be deducted from the total,
  // the the price of the item, multiplied by the amount of items counted divided by 2.
  def applyBogofDeal(item:String, cart:List[String]) : Float = {
    val count = cart.count(_ == item)
    return products(item) * (count/2)
  }

  // Takes an string and a list of strings, uses the List count function
  // to count the passed in item and returns the amount to be deducted from the total,
  // the the price of the item, multiplied by the amount of items counted divided by 3.
  def applyThreeForTwoDeal(item:String, cart:List[String]) : Float = {
    val count = cart.count(_ == item)
    return products(item) * (count/3)
  }

  // format the output to british pounds
  def formatToPounds(c:Float) : String = {
    val gbp = new DecimalFormat("#,###0.00")
    gbp.format(c)
  }
}

object main {
  def main(args: Array[String]) {
    val cart = List("Apple", "Apple", "Orange", "Apple", "Orange", "Apple", "Orange")
    val checkout = new Checkout
    val total = checkout.calculateTotal(cart)
    val finalTotal = total - checkout.applyBogofDeal("Apple", cart) - checkout.applyThreeForTwoDeal("Orange", cart)
    println("Your total comes to £" + checkout.formatToPounds(total))
    println("With the current deals on apples and oranges your total comes to: £" + checkout.formatToPounds(finalTotal))
  }
}