package com.example

import monocle.Lens

object Hello {
  def main(args: Array[String]): Unit = {
    case class Example(s: String, i: Int)
    val s = Lens[Example, String](_.s)(s => _.copy(s = s))
    println(s)
    println("Hello, world!")
  }
}
