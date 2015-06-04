package com.oreilly.testingscala

import org.scalatest.testng.TestNGSuite
import org.testng.annotations.{Test, DataProvider}
import org.testng.Assert._

import scala.collection.mutable

class ArtistTestNGSuite extends TestNGSuite {
  @DataProvider(name = "provider")
  def provideData = {
    val g = new mutable.ArrayBuilder.ofRef[Array[Object]]()
    g += Array[Object]("Heart", 5.asInstanceOf[java.lang.Integer])
    g += Array[Object]("Jimmy Buffet", 12.asInstanceOf[java.lang.Integer])
    g.result()
  }

  @Test(dataProvider = "provider")
  def testTheStringLength(n1: String, n2: java.lang.Integer) {
    assertEquals(n1.length, n2)
  }
}
