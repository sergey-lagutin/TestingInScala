package com.oreilly.testingscala.spec

import com.oreilly.testingscala.{Album, Artist}
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.{FunSpec, GivenWhenThen, Tag}

class AlbumSpecAll extends FunSpec with ShouldMatchers with GivenWhenThen {
  describe("An Album") {
    it("can add an Artist to album at construction time", Tag("construction")) {
      given("The Thriller by Michael Jackson")
      val album = new Album("Thriller", 1981, Artist("Michael", "Jackson"))

      when("the artist of album is obtained")
      val artist = album.artist

      then("the artist should be an instance of Artist")
      artist.isInstanceOf[Artist] should be(true)


      and("the artist's first name and last name should be Michael Jackson")
      artist.firstName should be("Michael")
      artist.lastName should be("Jackson")

      info("This is still pending, since there may be more to accomplish in this test")
      pending
    }

    ignore("can add a Producer to an album at construction time") {
      // TODO: Add some logic to add a producer
    }
  }
}
