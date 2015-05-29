package com.oreilly.testingscala

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.matchers.MustMatchers

class ExceptionHandlingSpec extends FlatSpec with ShouldMatchers with MustMatchers {
	// "An album" should {
		// "throw an IllegalArgumentException if there are no acts when created 1" in {
		// 	intercept[IllegalArgumentException] {
		// 		new Album("The Joy of Listening to Nothing", 1980, List())
		// 	}
		// }

		// "throw an IllegalArgumentException if there are no acts when created 2" in {
		// 	val thrownException = evaluating {new Album("The Joy of Listening to Nothing", 1980, List())} must produce [IllegalArgumentException]
		// 	thrownException.getMessage() must be ("An Artist is required")
		// }
	// }
}
