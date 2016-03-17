package com.example

import monocle.macros.GenLens


object SampleLensMacro {
  def main(args: Array[String]): Unit = {
    // Streetのnameを不変性を保ったまま書き換えたい
    case class Street(name: String)
    case class Address(street: Street)
    case class Company(address: Address)
    case class Employee(company: Company)

    val _name = GenLens[Street](_.name)
    val _street = GenLens[Address](_.street)
    val _address = GenLens[Company](_.address)
    val _company = GenLens[Employee](_.company)

    // 不変ッッ
    val employee = Employee(Company(Address(Street("chuodori"))))
    println((_company composeLens _address composeLens _street composeLens _name) get employee)
    val employeeHoge = (_company composeLens _address composeLens _street composeLens _name).set("hogedori")(employee)
    println((_company composeLens _address composeLens _street composeLens _name) get employeeHoge)
    val employeeCap = (_company composeLens _address composeLens _street composeLens _name).modify(_.capitalize)(employee)
    println((_company composeLens _address composeLens _street composeLens _name) get employeeCap)
    println((_company ^|-> _address ^|-> _street ^|-> _name).modify(_.capitalize)(employee))


    println("Hello, world!")
  }
}
