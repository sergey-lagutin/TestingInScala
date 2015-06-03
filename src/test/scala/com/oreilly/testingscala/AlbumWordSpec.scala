package com.oreilly.testingscala

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

class AlbumWordSpec extends WordSpec with ShouldMatchers {
  "An Album" when {
    "created" should {
      "accept the title, the year and a Band as parameter, and be able to read those parameters back" in {
        new Album("Hotel California", 1977,
          new Band("The Eagles", new Artist("Don", "Henley"), new Artist("Glenn", "Frey")))
      }
    }
  }

  "An Album" should {
    "throw an IllegalArgumentException if there are no acts when created" in {
      intercept[IllegalArgumentException] {
        new Album("The Joy", 1980, None)
      }
    }
  }
}
