package com.example

import monocle.{Iso, Prism}

object SampleIso {
  def main(args: Array[String]): Unit = {
    sealed trait Day
    case class Monday(day: Int) extends Day
    case class Tuesday(day: Int) extends Day
    case class Wednesday(day: Int) extends Day
    case class Thursday(day: Int) extends Day
    case class Friday(day: Int) extends Day
    case class Saturday(day: Int) extends Day
    case class Sunday(day: Int) extends Day
    case class Sample(day: Day)

    val iso = Iso[Sunday, Int](_.day)(Sunday)

    println(iso)

    println("Hello, world!")
  }
}
