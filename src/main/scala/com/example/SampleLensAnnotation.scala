package com.example

import monocle.macros.Lenses


object SampleLensAnnotation {
  def main(args: Array[String]): Unit = {
    // Streetのnameを不変性を保ったまま書き換えたい
    @Lenses
    case class Street(name: String)
    @Lenses
    case class Address(street: Street)

    @Lenses
    case class Company(address: Address)

    @Lenses
    case class Employee(company: Company)

    // 不変ッッ
    val employee = Employee(Company(Address(Street("chuodori"))))
    println((Street.name composeLens Company.address composeLens Street.name composeLens Street.name) get employee)
    // val employeeHoge = (_company composeLens _address composeLens _street composeLens _name).set("hogedori")(employee)
    // println((_company composeLens _address composeLens _street composeLens _name) get employeeHoge)
    // val employeeCap = (_company composeLens _address composeLens _street composeLens _name).modify(_.capitalize)(employee)
    // println((_company composeLens _address composeLens _street composeLens _name) get employeeCap)
    // println((_company ^|-> _address ^|-> _street ^|-> _name).modify(_.capitalize)(employee))
    // (company ^|-> address ^|-> street ^|-> name).modify(_.capitalize)(employee)


    println("Hello, world!")
  }
}
