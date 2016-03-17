package com.example

import monocle.macros.Lenses


object SampleLensAnnotation {
  def main(args: Array[String]): Unit = {
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
    println((Employee.company composeLens Company.address composeLens Address.street composeLens Street.name) get employee)

    val employeeHoge = (Employee.company composeLens Company.address composeLens Address.street composeLens Street.name).set("hogedori")(employee)
    println((Employee.company composeLens Company.address composeLens Address.street composeLens Street.name) get employeeHoge)

    val employeeCap = (Employee.company composeLens Company.address composeLens Address.street composeLens Street.name).modify(_.capitalize)(employee)
    println((Employee.company composeLens Company.address composeLens Address.street composeLens Street.name) get employeeCap)

    println((Employee.company ^|-> Company.address ^|-> Address.street ^|-> Street.name).modify(_.capitalize)(employee))


    println("Hello, world!")
  }
}
