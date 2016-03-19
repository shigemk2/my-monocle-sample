package com.example

import monocle.Prism

object SamplePrism {
  def main(args: Array[String]): Unit = {
    sealed trait Day
    case object Monday extends Day
    case object Tuesday extends Day
    case object Wednesday extends Day
    case object Thursday extends Day
    case object Friday extends Day
    case object Saturday extends Day
    case object Sunday extends Day

    val _tuesday = Prism[Day, Unit]{
      case Tuesday => Some(())
      case _       => None
    }(_ => Tuesday)

    println(_tuesday.reverseGet()) // Tuesday
    println(_tuesday.getOption(Monday)) // None
    println(_tuesday.getOption(Tuesday)) // Some(())
    println(_tuesday.getMaybe(Monday)) // Empty()
    println(_tuesday.getMaybe(Tuesday)) // Just(())
    println(_tuesday.modify(println))

    println("Hello, world!")
  }
}
