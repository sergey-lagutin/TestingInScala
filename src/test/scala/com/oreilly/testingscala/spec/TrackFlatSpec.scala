package com.oreilly.testingscala.spec

import com.oreilly.testingscala.Track
import org.joda.time.Period
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers

class TrackFlatSpec extends FlatSpec with MustMatchers {
  behavior of "A Track"

  it should """have constructor that accepts the name and the length of the track
              in min:sec and returns a joda.time.Period when track.period is called""" in {
    val track = new Track("Last dance", "5:00")
    track.period must be(new Period(0, 5, 0, 0))
  }

  it must
    """throw an IllegalArgumentException with the message \"Track name cannot be blank\"
      |if the name of the track is blank.""".stripMargin in {
    val exception = evaluating(new Track("")) must produce[IllegalArgumentException]
    exception.getMessage must be("requirement failed: Track name cannot be blank")
  }
}