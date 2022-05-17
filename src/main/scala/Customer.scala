import java.util.UUID

final class Customer(first: String, last: String, email:String) {
  private val _id: UUID = UUID.randomUUID()
  private val _first = first
  private val _last = last
  private val _email = email

    def getId: UUID = _id
    def getFirst: String = _first
    def getLast: String = _last
    def getEmail: String = _email
}

object EmailRunner extends App {
  val c1: Customer = new Customer("Tony", "Stark", "tony@stark.com")
  println(c1.getId, c1.getFirst, c1.getLast, c1.getEmail)
}
