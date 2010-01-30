package net.fratech.twitter

import swing._
import event.{ButtonClicked, ValueChanged}
import java.awt.Color

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
object TwitterGUI extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "A Simple Twitter Swing GUI"

    val updateLabel= new Label { text = "Write your message:"}
    val updateField = new TextArea(3, 50)
    val updateButton = new Button { text = "Update" }

    contents = new BoxPanel(Orientation.Vertical) {
      contents += updateLabel
      contents += new ScrollPane(updateField)
      contents += new FlowPanel{ contents += updateButton }
    }

    listenTo(updateField)
    listenTo(updateButton)

    reactions += {
      case ValueChanged(ta: TextArea) =>
        if(ta.text.length > 140) {
          updateLabel.text = "Write your message (Only 140 characters):"
          updateLabel.foreground = Color.RED
          updateButton.enabled = false
        } else {
          updateLabel.text = "Write your message:"
          updateLabel.foreground = Color.BLACK
          updateButton.enabled = true
        }
      case ButtonClicked(b) =>
        println(updateField.text)
        updateField.text = ""
    }
  }
}