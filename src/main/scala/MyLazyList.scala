
package myLazyList

/*
 * This file implements a custom lazy list (similar to Scala's LazyList).
 * Elements are only computed when accessed, demonstrating lazy evaluation.
 */

sealed trait MyLazyList[+A]

case object Empty extends MyLazyList[Nothing]

case class Cons[A](head: () => A, tail: () => MyLazyList[A]) extends MyLazyList[A]

object MyLazyList {
  // 'apply' constructs a lazy list node, delaying computation of head and tail
  def apply[A](head: => A, tail: => MyLazyList[A]): MyLazyList[A] = {
    lazy val h = head
    lazy val t = tail
    Cons(() => h, () => t)
  }

  // 'unapply' allows pattern matching on MyLazyList
  def unapply[A](list: MyLazyList[A]): Option[(A, MyLazyList[A])] = list match {
    case Empty => None
    case Cons(head, tail) => Some((head(), tail()))
  }
}

@main def testMyLazyList(): Unit = {
  // Create a lazy list with three elements
  val lazyList = MyLazyList(1, MyLazyList(2, MyLazyList(3, Empty)))

  // Pattern match to extract elements
  lazyList match {
    case MyLazyList(x, MyLazyList(y, MyLazyList(z, _))) =>
      println(s"Head: $x, Second: $y, Third: $z")
    case _ =>
      println("Pattern match failed")
  }

  // Demonstrating lazy evaluation: elements are only computed when accessed
  val lazyComputation = MyLazyList({
    println("Computing 4...")
    4
  }, MyLazyList({
    println("Computing 5...")
    5
  }, Empty))

  lazyComputation match {
    case Empty => println("Empty list")
    case MyLazyList(a, MyLazyList(b, _)) =>
      println(s"First: $a, Second: $b")
    case myLazyList.Cons(_, _) => println("Matched a Cons")
  }
}

