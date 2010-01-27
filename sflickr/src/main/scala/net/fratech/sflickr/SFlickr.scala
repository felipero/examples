package net.fratech.sflickr

import java.net.{HttpURLConnection, URL}
import xml.XML

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
object SFlickr {

  val api_key = "5746fe1e3a59df61c2a8270b4cfa9571"

  def listPhotos(user: String) = {
    val conn = new URL("http://api.flickr.com/services/rest/?method=flickr.people.getPublicPhotos&user_id=45928917@N08&api_key=5746fe1e3a59df61c2a8270b4cfa9571").
            openConnection.asInstanceOf[HttpURLConnection]
    val statusCode = conn.getResponseCode 
    if (statusCode != 200) {
      println("ERROR: " + statusCode.toString)
    }
    //println((XML.load(conn.getInputStream)))
    val photos = (XML.load(conn.getInputStream)) \\ "photo"
    photos
  }

  def testConnection = {
    val conn = new URL("http://api.flickr.com/services/rest/?method=flickr.test.echo&name=felipero&api_key=5746fe1e3a59df61c2a8270b4cfa9571").
            openConnection.asInstanceOf[HttpURLConnection]
    val statusCode = conn.getResponseCode
    if (statusCode != 200)
      println("ERROR: " + statusCode.toString)
    val result = (XML.load(conn.getInputStream()) \ "@stat").text == "ok"
    result
  }
}

