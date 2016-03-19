package com.example

import monocle.Prism

object SamplePrismLinkedList {
  def main(args: Array[String]): Unit = {
    sealed trait LinkedList[A]
    case class Nil[A]() extends LinkedList[A]
    case class Cons[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

    def _nil[A] = Prism[LinkedList[A], Unit]{
      case Nil()      => Some(())
      case Cons(_, _) => None
    }(_ => Nil())

    def _cons[A] = Prism[LinkedList[A], (A, LinkedList[A])]{
      case Nil()      => None
      case Cons(h, t) => Some((h, t))
    }{ case (h, t) => Cons(h, t)}

    val l1 = Cons(1, Cons(2, Cons(3, Nil())))
    val l2 = _nil[Int].reverseGet(())

    println(l1)
    println(l2)

    println("Hello, world!")
  }
}
