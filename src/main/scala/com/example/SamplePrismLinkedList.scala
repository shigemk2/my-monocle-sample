package com.example

import monocle.Prism
import monocle.function.fields._
import monocle.std.tuple2._

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

    // usage of Prism
    println(_cons.getOption(l1))
    println(_cons.isMatching(l1))
    println(_cons.isMatching(l2))
    println(_cons[Int].modify(_.copy(_1 = 5))(l1))
    println(_cons[Int].modify(_.copy(_1 = 5))(l2))

    // using Lens
    println(_cons[Int].modifyOption(_.copy(_1 = 5))(l1))
    println(_cons[Int].modifyOption(_.copy(_1 = 5))(l2))

    // not use copy, it's annoying
    println((_cons[Int] composeLens first).set(5)(l1))
    println((_cons[Int] composeLens first).set(5)(l2))

    println("Hello, world!")
  }
}
