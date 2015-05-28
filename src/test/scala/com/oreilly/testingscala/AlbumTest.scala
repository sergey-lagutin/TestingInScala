package com.oreilly.testingscala

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class AlbumTest extends FunSpec with ShouldMatchers {
	describe("Album") {
		it ("can add Artist object to the album") {
			val album = new Album("Thriller", 1981, new Artist("Michael", "Jackson"))
			album.artist.firstName should be ("Michael")
		}
	}
}