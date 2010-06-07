package net.fratech.twitter

import swing._
import event.{ButtonClicked, ValueChanged}
import twitter4j.{Twitter, Status}
import scala.collection.jcl.Conversions._
import java.awt.{Dimension, Color}
import javax.swing.BorderFactory

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
object TwitterGUI extends SimpleGUIApplication {

  val twitter: Twitter = new Twitter("felipero","****")

  def top = new MainFrame {
    title = "A Simple Twitter Swing GUI"

    preferredSize = new Dimension(430,600)

    val updateLabel= new Label { text = "Status:" }
    val updateField = new TextArea(3, 50)
    val updateButton = new Button { text = "Send" }
    val refreshButton = new Button { text = "Refresh" }

    var list = new ListView[Status](getStatusList)
    list.renderer = new StatusRenderer
    list.fixedCellHeight = 70
    list.fixedCellWidth = 350

    contents = new BoxPanel(Orientation.Vertical) {
      contents += new FlowPanel(FlowPanel.Alignment.Left){ contents += updateLabel }
      contents += updateField
      contents += new FlowPanel{
        contents += updateButton
        contents += refreshButton
      }
      contents += new ScrollPane(list)
    }

    listenTo(updateField)
    listenTo(updateButton)
    listenTo(refreshButton)

    reactions += {
      case ValueChanged(ta: TextArea) =>
        updateLabel.text = "Status: (" + ta.text.length + ")"
        if(ta.text.length > 140) {
          updateLabel.foreground = Color.RED
          updateButton.enabled = false
        } else {
          updateLabel.foreground = Color.BLACK
          updateButton.enabled = true
        }
      case ButtonClicked(b) =>
        if(b == updateButton) {
          twitter.updateStatus(updateField.text)
          updateField.text = ""
          updateList(list)
        } else {
          updateList(list)
        }

    }
  }

  def updateList(list: ListView[Status]) = {
    list.listData = getStatusList
    list.repaint
  }
  def getStatusList = {
    twitter.getFriendsTimeline().toSeq
  }

}