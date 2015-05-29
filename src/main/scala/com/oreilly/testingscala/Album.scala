package com.oreilly.testingscala

class Album(val title : String, val year : Int, val artists : List[Artist]) {
	if (artists.isEmpty) throw new IllegalArgumentException("An Artist is required")

	def this(title : String, year : Int, artist : Artist){
		this(title, year, List(artist))
	}

	def artist = artists.head
}

case class Artist(val firstName : String, val lastName : String)
