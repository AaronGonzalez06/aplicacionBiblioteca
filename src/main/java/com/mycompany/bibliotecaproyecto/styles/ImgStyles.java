package com.mycompany.bibliotecaproyecto.styles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.LineBorder;

public class ImgStyles extends LineBorder{

	public ImgStyles(Color color, int thickness, boolean roundedCorners) {
		super(color, thickness, roundedCorners);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getLineColor());

        RoundRectangle2D rect = new RoundRectangle2D.Double(x, y, width - 1, height - 1, 0, 0);
        g2d.draw(rect);
    }
}
