package com.oreilly.testingscala

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class ShouldMatcherSpec extends FunSpec with ShouldMatchers {
	describe("Simple matchers"){
		it("should be"){
			val list = 2 :: 3 :: 4 :: Nil
			list.size should be (3)
		}

		it("should equal"){
			val list = 2 :: 3 :: 4 :: Nil
			list.size should equal (3)
		}
	}

	describe("String matchers"){
		it("may be"){
			val string = """I fell into a burning ring of fire.	I went down, down, down and the flames went higher"""

			string should startWith("I fell")
			string should endWith("higher")
			string should not endWith "My favorite friend, the end"

			string should include("down, down, down")
			string should not include ("Great balls of fire")
			
			string should startWith regex ("I.fel+")
			string should endWith regex ("h.{4}r")
			string should not endWith regex("\\d{5}")
			string should include regex ("flames?")
			string should fullyMatch regex ("""I(.|\n|\S)*higher""")
		}
	}

	describe("Relational operator matchers"){
		it("may be"){
			val answerToLife = 42
			answerToLife should be < (50)
			answerToLife should not be > (50)
			answerToLife should be > (3)
			answerToLife should be <= (100)
			answerToLife should be >= (0)
			answerToLife should be === (42)
			answerToLife should not be === (400)
		}
	}

	describe("Floating-point-matchers") {
		it("may be"){
			(0.9 - 0.8) should be (0.1 plusOrMinus .01)
			(0.4 + 0.1) should not be (40.00 plusOrMinus .30)
		}
	}

	describe("Reference matchers"){
		it("theSameInstanceAs"){
			val garthBrooks = new Artist("Garth", "Brooks")
			val chrisGaines = garthBrooks
			garthBrooks should be theSameInstanceAs (chrisGaines)
			
			val debbieHarry = new Artist("Debbie", "Harry")
			garthBrooks should not be theSameInstanceAs(debbieHarry)
		}
	}

	describe("Iterable matchers"){
		it("empty"){
			List() should be ('empty)
		}

		it("contain"){
			List(1,2,3,4,5) should contain (2)
		}
	}

	describe("Seq and traversable matchers"){
		it("have size"){
			(20 to 60 by 2) should have size (21)
		}

		it("have length"){
			(1 to 9) should have length (9)
		}
	}

	describe("Map matchers"){
		it("may be"){
			val map = Map("Jimmy Page" -> "Led Zeppelin", "Sting" -> "The Police", "Aimee Mann" -> "Til\' Tuesday")
			map should contain key ("Sting")
			map should contain value ("Led Zeppelin")
			map should not contain key("Brian May")
		}
	}

	describe("Compound matchers"){
		it("may be"){
			val redHotChiliPeppers = List("Anthony Kiedis", "Flea", "Chad Smith", "Josh Klinghoffer")
			redHotChiliPeppers should (contain("Anthony Kiedis") and
				(not contain ("John Frusciante")
					or contain("Dave Navarro")))
		}
	}

	describe("Property matchers"){
		it("may be"){
			val album = new Album("Blizzard of Ozz", 1980, new Artist("Ozzy", "Osbourne"))
			album should have (
				'title ("Blizzard of Ozz"),
				'year (1980),
				'artist (new Artist("Ozzy", "Osbourne"))
			)
		}
	}

	describe("java.util.Collection matchers"){
		it("may be"){
			import java.util.{List => JList, ArrayList => JArrayList, Map => JMap, HashMap => JHashMap}
			val jList: JList[Int] = new JArrayList[Int](20)
			jList.add(3); jList.add(6); jList.add(9)
			val emptyJList: JList[Int] = new JArrayList[Int]()
			emptyJList should be('empty)
			jList should have length (3)
			jList should have size (3)
			jList should contain(6)
			jList should not contain (10)
			val backupBands: JMap[String, String] = new JHashMap()
			backupBands.put("Joan Jett", "Blackhearts")
			backupBands.put("Tom Petty", "Heartbreakers")
			backupBands should contain key ("Joan Jett")
			backupBands should contain value ("Heartbreakers")
			backupBands should not contain key("John Lydon")
		}
	}
}