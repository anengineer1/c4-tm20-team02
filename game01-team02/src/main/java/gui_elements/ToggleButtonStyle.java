package gui_elements;
/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.border.BevelBorder;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class ToggleButtonStyle extends BasicButtonUI {

	private boolean drawX;
	
	public ToggleButtonStyle() {
		super();
		this.drawX = true;
	}
	
	public ToggleButtonStyle(boolean is_x) {
		super();
		this.drawX = is_x;
	}

	@Override
	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);

		if (c instanceof AbstractButton) {
			AbstractButton button = (AbstractButton) c;
			if (button.isSelected()) {
				Graphics2D g2 = (Graphics2D) g.create();
				g2.setColor(button.getForeground());
				FontMetrics fm = g2.getFontMetrics();
				
				String letter = drawX ? "X" : "O";

				int x = (c.getWidth() - fm.stringWidth(letter)) / 2;
				int y = (c.getHeight() - fm.getHeight()) / 2 + fm.getAscent();

				g2.drawString(letter, x, y);

				g2.dispose();
			}
		}
	}

	public void setDrawX(boolean drawX) {
		this.drawX = drawX;
	}

}
