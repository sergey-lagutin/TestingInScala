package com.oreilly.testingscala.scalatest.fixture

import com.oreilly.testingscala.{Band, Album}
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class AlbumFixtureSpec extends FunSpec with ShouldMatchers {
  def fixture = new {
    val letterFromHome = new Album("Letter from Home", 1989,
      new Band("Pat Metheny Group"))
  }

  describe("The Letter From Home Album by Pat Metheny") {
    it("should get the year 1989 from the album") {
      val album = fixture.letterFromHome
      album.year should be(1989)
    }
  }
}
