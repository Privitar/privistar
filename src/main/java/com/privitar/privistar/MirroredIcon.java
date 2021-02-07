package com.privitar.privistar;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;

public class MirroredIcon implements Icon {

    private final Icon icon;

    public MirroredIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();

        AffineTransform transform = new AffineTransform();
        transform.scale(-1,1);
        transform.translate(-icon.getIconWidth(), 0);
        transform.translate(-x,y);
        g2.transform(transform);

        icon.paintIcon(c, g2, 0, 0);
    }

    @Override
    public int getIconWidth() {
        return icon.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return icon.getIconHeight();
    }
}
