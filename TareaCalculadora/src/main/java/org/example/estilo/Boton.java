package org.example.estilo;

import javax.swing.*;
import java.awt.*;

public class Boton extends JButton {
        public Boton() {
            this.setOpaque(true);
            this.setContentAreaFilled(true);
            this.setPreferredSize(new Dimension(100,30));
        }
        @Override
        protected void paintComponent(Graphics graphics){
            Graphics2D g2=(Graphics2D) graphics;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
/*

#b2fefa
→
#0ed2f7
 */
            GradientPaint gradientPaint=new GradientPaint(0,0,Color.decode("#fc00ff"),0,getHeight(),Color.decode("#00dbde"));
            g2.setPaint(gradientPaint);
            g2.fillRect(0,0,getWidth(),getHeight());
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.50f));
            super.paintComponent(g2);
        }
    }
