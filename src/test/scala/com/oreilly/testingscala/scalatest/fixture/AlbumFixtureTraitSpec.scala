package com.oreilly.testingscala.scalatest.fixture

import com.oreilly.testingscala.{Album, Band}
import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class AlbumFixtureTraitSpec extends FunSpec with ShouldMatchers {

  trait AlbumFixture {
    val letterFromHome = new Album("Letter from Home", 1989,
      new Band("Pat Metheny Group"))
  }

  describe("The Letter From Home Album by Pat Metheny") {
    it("should get the year 1989 from the album") {
      new AlbumFixture {
        letterFromHome.year should be(1989)
      }
    }
  }
}
