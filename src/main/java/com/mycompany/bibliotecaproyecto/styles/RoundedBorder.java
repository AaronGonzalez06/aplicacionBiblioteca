package com.mycompany.bibliotecaproyecto.styles;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.Border;

public class RoundedBorder implements Border {
    private int radio;

    public RoundedBorder(int radio) {
        this.radio = radio;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setColor(((JComponent) c).getBackground());

        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, width - 1, height - 1, radio, radio);
        g2d.draw(rect);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(radio + 1, radio + 1, radio + 2, radio);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

}