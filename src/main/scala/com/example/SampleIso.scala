package com.example

import monocle.Iso

object SampleIso {
  def main(args: Array[String]): Unit = {
    sealed trait Day
    case object Monday extends Day
    case object Tuesday extends Day
    case object Wednesday extends Day
    case object Thursday extends Day
    case object Friday extends Day
    case object Saturday extends Day
    case object Sunday extends Day

    val iso = Iso[Day, Unit]{
      case Tuesday => Some(())
      case _       => None
    }(_ => Tuesday)

    println(iso)
    println(iso.reverseGet()) // Tuesday
    println(iso.modify(println))

    println("Hello, world!")
  }
}
