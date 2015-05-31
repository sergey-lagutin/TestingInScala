package com.oreilly.testingscala

class Act

case class Artist(firstName: String, lastName: String) extends Act

class Band(name: String, members: Artist*) extends Act

class Album(val title: String, val year: Int, val acts: List[Act]) {
  require(acts.size > 0)

  def this(title: String, year: Int, act: Act) {
    this(title, year, List(act))
  }

  def artist = acts.head.asInstanceOf[Artist]
}

