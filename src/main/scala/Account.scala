//how to create a class, and instances from that class

import java.time.LocalDateTime
import java.util.UUID

abstract class Account(id: UUID, name:String, dateOpened: LocalDateTime) {
  // this is the primary constructor for this class.
  private var _id: UUID = id
  private var _name: String = name
  private var _dateOpened: LocalDateTime = dateOpened
  val _accountType: String
    //these are instance variables and represent the memory image of the objec

  // the primary constructor can't do what we want it to do. we need an another constructor which MUST be called this
  //this is the auxiliary constructor
  // the this constructor must call the primary constructor
  def this(name: String){
    this(UUID.randomUUID(), name, LocalDateTime.now())
  }

  def getId: UUID = _id
  def getName: String = _name
  def getDateOpened: LocalDateTime = _dateOpened
  def updatedName(newName: String): Unit = _name = newName //this takes a new account name and replaces it
  def getAccountType: String = _accountType

  override def toString: String = s"Account id=${_id}, name=${_name}, dateOpened=${_dateOpened}"

}

// inheritance  of classes - one way to do it is as follows with this Credit and Deposits account example.
class CreditAccount(name: String) extends Account(name:String) {
  //when the caller creates an instance of CreditAccount,
  // the value of name will be passed onto the parent class Account
//
//  private val _accountType = "Credit"
//  def getAccountType: String = _accountType
  override val _accountType: String = "Credit"
}

class DepositsAccount(name: String) extends Account(name:String) {
//
//    private val _accountType = "Deposit"
//    def getAccountType: String = _accountType
  override val _accountType: String = "Deposit"
  override def toString: String = s"Account id=${getId}, name=${getName}, dateOpened=${getDateOpened}, account type=${getAccountType}"
}

object AccountRunner extends App {
//  val a1 = new Account(UUID.randomUUID(), name = "Account_01", LocalDateTime.now())
//  val a2 = new Account(UUID.randomUUID(), name = "Account_02", LocalDateTime.now().plusHours(6))
//  val a3 = new Account("Account_03")

  // previous to the construction of the getter methods, we could have modified
  //these directly, whereas now they are encapsulated
//  a1.updatedName("Updated Account_01")
//  println(a1.getId, a1.getName, a1.getDateOpened)
//  println(a2.getId, a2.getName, a2.getDateOpened)
//  println(a3.getId, a3.getName, a3.getDateOpened)


  val ca1: Account = new CreditAccount("Travel Mastercard")
//  println(ca1.getId, ca1.getName, ca1.getDateOpened, ca1.getAccountType)
  println(ca1)

  val da1: DepositsAccount = new DepositsAccount("Super Savings")
//  println(da1.getId, da1.getName, da1.getDateOpened, da1.getAccountType)
  println(da1)
}