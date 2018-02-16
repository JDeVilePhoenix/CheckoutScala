class Checkout {
  private val products = Map("Apple" -> 0.60f, "Orange" -> 0.25f)

  // step 1: Shopping cart
  // a more scalable solution, can accept any number of mapped products
  // takes a list of string product names and compares each element with the products map
  // totaling the associated price of the mapped product if an empty list is passed or an incorrect
  // product name the function returns 0
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

}
