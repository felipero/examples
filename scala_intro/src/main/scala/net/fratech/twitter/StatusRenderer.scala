package net.fratech.twitter

import swing.ListView.Renderer
import twitter4j.Status
import java.awt.{Dimension, Color}
import swing._
import javax.swing.{JTextPane, BorderFactory, ImageIcon}

/**
 * @author Felipe Rodrigues - felipe (at) fratech.net
 */
class StatusRenderer extends Renderer[Status] {

  def componentFor(list: ListView[_], isSelected: Boolean, focused: Boolean, status: Status, index: Int) = {
    val color = if(index % 2 == 0) new Color(229, 229, 242) else new Color(197, 197, 228)

    val avatarPanel = new BoxPanel(Orientation.Vertical) {
      contents += new Label { icon = new ImageIcon(status.getUser.getProfileImageURL) }
      contents += new Label { text = status.getUser.getScreenName }
      background = color
      border = BorderFactory.createMatteBorder(0,0,0,1, Color.lightGray)
      minimumSize = new Dimension(90, 70)
      maximumSize = new Dimension(90, 70)
    }


    new BoxPanel(Orientation.Horizontal) {
      contents += avatarPanel
      val txt = Component.wrap(new JTextPane() {
        setText(status.getText)
        setBackground(color)
        setPreferredSize(new Dimension(300, 50))
        setMaximumSize(new Dimension(300, 50))
      })

      contents += txt
      background = color
    }
  }

//  def scale(Image src, double scale): ImageIcon = {
//        int w = (int)(scale*src.getWidth(this));
//        int h = (int)(scale*src.getHeight(this));
//        int type = BufferedImage.TYPE_INT_RGB;
//        BufferedImage dst = new BufferedImage(w, h, type);
//        Graphics2D g2 = dst.createGraphics();
//        g2.drawImage(src, 0, 0, w, h, this);
//        g2.dispose();
//        return new ImageIcon(dst);
//    }
}