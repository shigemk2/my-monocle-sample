package com.example

import monocle.Lens

object SampleManiLens {
  def main(args: Array[String]): Unit = {
    // Streetのnameを不変性を保ったまま書き換えたい
    case class Street(name: String)
    case class Address(street: Street)
    case class Company(address: Address)
    case class Employee(company: Company)

    // 対象のデータに対するgetterとsetterを引数に渡します。

    val _name = Lens[Street, String](_.name)(str => s => s.copy(name = str))
    val _street = Lens[Address, Street](_.street)(s => a => a.copy(street = s))
    val _address = Lens[Company, Address](_.address)(a => c => c.copy(address = a))
    val _company = Lens[Employee, Company](_.company)(c => e => e.copy(company = c))

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
