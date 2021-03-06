package com.oreilly.testingscala

class Act

case class Artist(firstName: String, lastName: String, albums: List[Album] = List()) extends Act {
  def addAlbum(album: Album) = Artist(firstName, lastName, albums :+ album)
}

class Band(name: String, members: Artist*) extends Act

class Album(val title: String, val year: Int, _tracks: Option[List[Track]], val acts: Act*) {
  require(acts.size > 0)

  def this(title: String, year: Int, acts: Act*) {
    this(title, year, None, acts: _*)
  }

  def this(title: String, year: Int, act: Act) {
    this(title, year, List(act): _*)
  }

  def artist = acts.head.asInstanceOf[Artist]

  def tracks: List[Track] = _tracks.getOrElse(List())
}

