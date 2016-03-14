package com.example

object HelloVar {
  def main(args: Array[String]): Unit = {
    // もし、変数がvarで再代入可能だったら
    case class Street(var name: String)
    case class Address(var street: Street)
    case class Company(var address: Address)
    case class Employee(var company: Company)
    val employee = Employee(Company(Address(Street("higashioodori"))))
    // varで書き換えてるけど、不変性は保ちたいよねッ
    val cap = employee.company.address.street.name.capitalize
    println(cap)

    println("Hello, world!")
  }
}
