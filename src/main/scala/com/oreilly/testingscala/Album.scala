package com.oreilly.testingscala

class Album(val title : String, val year : Int, val artist : Artist)

case class Artist(val firstName : String, val lastName : String)
