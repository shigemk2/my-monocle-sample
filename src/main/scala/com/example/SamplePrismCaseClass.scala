package com.example

import monocle.Prism

object SamplePrismCaseClass {
  def main(args: Array[String]): Unit = {
    sealed trait Day
    case class Monday() extends Day
    case class Tuesday() extends Day
    case class Wednesday() extends Day
    case class Thursday() extends Day
    case class Friday() extends Day
    case class Saturday() extends Day
    case class Sunday() extends Day
    case class Sample(day: Day)

    val _tuesday = Prism[Sample, Day]{
      case x: Day => Option(x)
      case _       => None
    } { x =>
      Sample(x)
    }

    println(_tuesday.reverseGet(Tuesday()))
    println(_tuesday.getOption(Sample(Monday()))) // None
    println(_tuesday.getOption(Sample(Tuesday()))) // Some(())
    println(_tuesday.getMaybe(Sample(Monday()))) // Empty()
    println(_tuesday.getMaybe(Sample(Tuesday()))) // Just(())
    println(Sample(Tuesday()).day)
    println("Hello, world!")
  }
}
