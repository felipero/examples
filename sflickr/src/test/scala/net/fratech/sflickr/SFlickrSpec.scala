package net.fratech.sflickr

import org.specs._

object SFlickrSpec extends Specification {
  "sflickr" should {
    "talk to Flickr" in {
      SFlickr.testConnection must beTrue
    }
    "list of public photos for a user" in {
      SFlickr.listPhotos("felipero").size must_== 100
    }
  }
}

