package com.example

object Hello {
  def main(args: Array[String]): Unit = {
    // Streetのnameを不変性を保ったまま書き換えたい
    case class Street(name: String)
    case class Address(street: Street)
    case class Company(address: Address)
    case class Employee(company: Company)

    val employee = Employee(Company(Address(Street("chuodori"))))

    // Streetのnameをcapitalizeする
    val cap = employee.copy(
      company = employee.company.copy(
        address = employee.company.address.copy(
          street = employee.company.address.street.copy(
            name = employee.company.address.street.name.capitalize
          )
        )
      )
    )
    println(cap)

    println("Hello, world!")
  }
}
