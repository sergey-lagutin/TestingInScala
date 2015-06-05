package com.oreilly.testingscala.spec2

import com.oreilly.testingscala._
import org.specs2.matcher.Matcher
import org.specs2.mutable.Specification

class MatchersSpec extends Specification {
  "A Matchers" should {
    "Simple Matchers" in {
      val rumours = new Album("Rumours", 1977,
        Some(List(new Track("Second Hand News", "2:43"),
          new Track("Dreams", "4:14"),
          new Track("Never Going Back Again", "2:02"),
          new Track("Don't Stop", "3:11"))), new Band("Fleetwood Mac"))
      rumours.title must be_==("Rumours")
      rumours.title must beEqualTo("Rumours")
      rumours.title must_== "Rumours"
      rumours.title mustEqual "Rumours"
      rumours.title should_== "Rumours"
      rumours.title === "Rumours"
      rumours.title must be equalTo "Rumours"
      rumours.title must not be equalTo("Sweet Emotion")
      rumours.title must_!= "Sweet Emotion"
      rumours.title mustNotEqual "Sweet Emotion"
      rumours.title must be_!=("Sweet Emotion")
      rumours.title !== "Sweet Emotion"
    }

    "String matchers" in {
      val boston = new Album("Boston", 1976,
        Some(List(new Track("More Than a Feeling", "4:44"),
          new Track("Peace of Mind", "5:02"),
          new Track("Foreplay/Long Time", "7:47"),
          new Track("Rock and Roll Band", "2:59"))), new Band("Boston"))
      boston.title must beEqualTo("BoSTon").ignoreCase
      boston.title must beEqualTo(" Boston").ignoreSpace
      boston.title must beEqualTo(" BoStOn ").ignoreSpace.ignoreCase
      boston.title must contain("os")
      boston.title must startWith("Bos")
      boston.title must endWith("ton")
      boston.title must not startWith "Char"
      boston.title must have size 6
      boston.title must beMatching("B\\w{4}n")
      boston.title must beMatching( """B\w{4}n""")
      boston.title must =~( """B\w{4}n""")
      boston.title must find( """(os.)""").withGroups("ost")
    }

    "Relation Operator matchers" in {
      val answerToLife = 42
      answerToLife should be_<(50)
      answerToLife should not be_> 50
      answerToLife must beLessThan(50)
      answerToLife should be_>(3)
      answerToLife must beGreaterThan(3)
      answerToLife should be_<=(100)
      answerToLife must beLessThanOrEqualTo(100)
      answerToLife should be_>=(0)
      answerToLife must beGreaterThanOrEqualTo(0)
      answerToLife === 42
    }

    "Floating - Point Matchers" in {
      (4.0 + 1.2) must be_==(5.2)
      (0.9 - 0.8) must beCloseTo(0.1, .01)
      (0.4 + 0.1) must not beCloseTo(40.00, .30)
      (0.4 + 0.1) must not be closeTo(40.00, .30)
    }

    "Reference matchers" in {
      val garthBrooks = new Artist("Garth", "Brooks")
      val chrisGaines = garthBrooks
      garthBrooks must beTheSameAs(chrisGaines)
      val debbieHarry = new Artist("Debbie", "Harry")
      garthBrooks must not beTheSameAs (debbieHarry)
    }

    "Iterable matchers" in {
      (Nil must be).empty
      List(1, 2, 3) must not be empty
      List(1, 2, 3) must contain(3)
      List(1, 2, 3) must not contain (5)
      List(4, 5, 6) must not contain(7, 8, 9)
      List(1, 2, 3, 4, 5, 6) must contain(3, 4, 5).inOrder
      List(4, 5, 6) must contain(4, 5, 6).only.inOrder
      List(1, 2) must have size (2)
      List(1, 2) must have length (2)
    }

    "Seq matchers" in {
      List("Hello", "World") must containMatch("ll") // matches with .*ll.*
      List("Hello", "World") must containMatch("Hello") // matches with .*ll.*
      List("Hello", "World") must containPattern(".*llo") // matches with .*llo
      List("Hello", "World") must containPattern("\\w{5}")
      List("Hello", "World") must containMatch("ll").onlyOnce
      List("Hello", "World") must have(_.size >= 5)
      List("Hello", "World") must haveTheSameElementsAs(List("World", "Hello"))
    }

    "Map matchers" in {
      val map = Map("Jimmy Page" -> "Led Zeppelin", "Sting" -> "The Police", "Aimee Mann" -> "Til\' Tuesday")
      map must haveKey("Sting")
      map must haveValue("Led Zeppelin")
      map must not haveKey ("Brian May")
      map must havePair("Aimee Mann" -> "Til\' Tuesday")
    }

    "XML Matchers" in {
      val coldPlayAlbums = <albums>
        <album name="Parachutes"/>
        <album name="A Rush of Blood to the Head"/>
        <album name="X&amp;Y"/>
        <album name="Viva la Vida or Death and All His Friends"/>
        <album name="Mylo Xyloto"/>
      </albums>

      coldPlayAlbums must beEqualTo(<albums>
        <album name="Parachutes"/>
        <album name="A Rush of Blood to the Head"/>
        <album name="X&amp;Y"/>
        <album name="Viva la Vida or Death and All His Friends"/>
        <album name="Mylo Xyloto"/>
      </albums>)

      coldPlayAlbums must beEqualToIgnoringSpace(<albums>
        <album name="Parachutes"/>
                <album name="A Rush of Blood to the Head"/>
            <album name="X&amp;Y"/>
                <album name="Viva la Vida or Death and All His Friends"/>
        <album name="Mylo Xyloto"/>
      </albums>)
    }

    "Partial Function Matchers" in {
      val gold: PartialFunction[Int, String] = new PartialFunction[Int, String] {
        def isDefinedAt(x: Int) = x >= 500000 //States that this partial function will take on the task

        def apply(v1: Int) = "Gold" //What we do if this does partial function matches
      }

      val platinum: PartialFunction[Int, String] = {
        case x: Int if x >= 1000000 => "Platinum"
      }
      val junk: PartialFunction[Int, String] = {
        case x: Int if x < 500000 => "Alternative"
      }

      val riaaCertification = gold orElse platinum orElse junk
      riaaCertification must beDefinedAt(100)
      riaaCertification must beDefinedBy(100 -> "Alternative")
    }

    "Custom matchers" in {
      def beEven: Matcher[Int] = (i: Int) => (i % 2 == 0, i + " is even", i + " is odd")

      val two = 2
      two should beEven
    }
  }
}
