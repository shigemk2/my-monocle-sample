package com.example

import monocle.macros.Lenses


object SampleLensAnnotation {
  def main(args: Array[String]): Unit = {
    // Streetのnameを不変性を保ったまま書き換えたい
    // @Lenses case class Address(name: String)
    // @Lenses case class Person(address: Address)
//
    // val addressNameLens = Person.address composeLens Address.name
    // val changeNameFunc = addressNameLens.modify(_.toUpperCase)(_:Person)
//
    // val person = Person(Address("person_address"))
    // val updatedPerson = changeNameFunc(person)
//
    // println(updatedPerson)
    @Lenses
    case class Street(name: String)

    @Lenses
    case class Address(street: Street)

    @Lenses
    case class Company(address: Address)

    @Lenses
    case class Employee(company: Company)

    // val _name = GenLens[Street](_.name)
    // val _street = GenLens[Address](_.street)
    // val _address = GenLens[Company](_.address)
    // val _company = GenLens[Employee](_.company)


    // 不変ッッ
    val employee = Employee(Company(Address(Street("chuodori"))))
    println((Employee.company composeLens Company.address composeLens Address.street composeLens Street.name) get employee)
    // println((_company composeLens _address composeLens _street composeLens _name) get employee)
    // val employeeHoge = (_company composeLens _address composeLens _street composeLens _name).set("hogedori")(employee)
    // println((_company composeLens _address composeLens _street composeLens _name) get employeeHoge)
    // val employeeCap = (_company composeLens _address composeLens _street composeLens _name).modify(_.capitalize)(employee)
    // println((_company composeLens _address composeLens _street composeLens _name) get employeeCap)
    // println((_company ^|-> _address ^|-> _street ^|-> _name).modify(_.capitalize)(employee))
    // (company ^|-> address ^|-> street ^|-> name).modify(_.capitalize)(employee)


    println("Hello, world!")
  }
}
