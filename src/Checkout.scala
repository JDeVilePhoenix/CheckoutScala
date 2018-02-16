class Checkout {
  private val products = Map("Apple" -> 0.60f, "Orange" -> 0.25f)

  def calculateTotal(cart:List[String]): Float = {
    if (cart.nonEmpty) {
      val total = (cart.count(_ == "Apple") * products("Apple")) +
        (cart.count(_ == "Orange") * products("Orange"))
      return total
    } else
      return 0f
  }

}
