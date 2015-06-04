package com.oreilly.testingscala.scalatest.spec

import com.oreilly.testingscala.{Album, Artist}
import org.junit.Assert._
import org.junit.{Before, Test}
import org.scalatest.junit.JUnitSuite

class ArtistJUnitSuite extends JUnitSuite {
  var artist: Artist = _

  @Before
  def startUp(): Unit = {
    artist = new Artist("Kenny", "Rogers")
  }

  @Test
  def addOneAlbumAndGetCopy() {
    val copyArtist = artist.addAlbum(new Album("Love will turn you around",
      1982, artist))
    assertEquals(copyArtist.albums.size, 1)
  }

  @Test
  def addTwoAlbumsAndGetCopy() {
    val copyArtist = artist
      .addAlbum(new Album("Love will turn you around", 1982, artist))
      .addAlbum(new Album("We've got tonight", 1983, artist))
    assertEquals(copyArtist.albums.size, 2)
  }
}
