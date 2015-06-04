package com.oreilly.testingscala.fixture

import com.oreilly.testingscala.{Band, Album}
import org.scalatest.{BeforeAndAfter, WordSpec}
import org.scalatest.matchers.ShouldMatchers

import scala.collection.mutable.ListBuffer

class AlbumBeforeAndAfterFixtureSpec extends WordSpec with ShouldMatchers with BeforeAndAfter {
  val humanLeagueDiscography = new ListBuffer[Album]()
  before {
    info("Starting to populate the discography")
    humanLeagueDiscography += new Album("Dare", 1981, new Band("Human League"))
  }

  "A mutable ListBuffer of albums" should {
    "have a size of 3 when two more albums are added to the Human League Discography" in {
      humanLeagueDiscography += new Album("Hysteria", 1984, new Band("Human League"))
      humanLeagueDiscography += new Album("Crash", 1986, new Band("Human League"))
      humanLeagueDiscography should have size 3
    }
    "have a size of 2 when one more album is added to the Human League      Discography" in {
      humanLeagueDiscography += new Album("Romantic", 1990, new Band("Human League"))
      humanLeagueDiscography should have size 2
    }
  }

  after {
    info("Clearing the discography")
    humanLeagueDiscography.clear()
  }
}
