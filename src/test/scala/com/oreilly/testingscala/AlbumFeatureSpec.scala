package com.oreilly.testingscala

import org.scalatest.FeatureSpec
import org.scalatest.matchers.ShouldMatchers

class AlbumFeatureSpec extends FeatureSpec with ShouldMatchers {
  feature("An album's default constructor should support a parameter that accepts Option[List[Track]]") {
    scenario("Album's default constructor is given a list of 3 tracks exactly for the tracks parameter") {
      val depecheMode = new Band("Depeche Mode", new Artist("Dave", "Gahan"), new Artist("Martin", "Gore"))
      val album = new Album(
        "Black celebration",
        1990,
        Some(List(new Track("Black Celebration"), new Track("Fly on the windscreen"))),
        List(depecheMode):_*)

      album.tracks should have size (3)
    }

    scenario("Album's default constructor is given a an empty List for the tracks parameter") {
      pending
    }

    scenario("Album's default constructor is given null for the tracks parameter") {
      pending
    }
  }

  feature("An album should have an addTrack method that takes a track and returns " +
    "immutable copy of the Album with added track") {
  }
}
