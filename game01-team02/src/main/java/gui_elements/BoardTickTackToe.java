package gui_elements;

import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class BoardTickTackToe extends JPanel {
	private final static int ROWS = 3;
	private final static int COLS = 3;

	private JToggleButton[][] toggle_buttons;

	public BoardTickTackToe() {
		super(new GridLayout(ROWS, COLS));
		this.initialize();
	}

	public BoardTickTackToe(LayoutManager arg0) {
		super(arg0);
		this.initialize();
	}

	public void initialize() {
		this.toggle_buttons = new JToggleButton[BoardTickTackToe.ROWS][BoardTickTackToe.COLS];

		for (int i = 0; i < toggle_buttons.length; i++) {
			for (int j = 0; j < toggle_buttons[i].length; j++) {
				this.toggle_buttons[i][j] = new JToggleButton();
				this.toggle_buttons[i][j].setContentAreaFilled(false);
				// this.toggle_buttons[i][j].setOpaque(true);
				this.toggle_buttons[i][j].setUI(new ToggleButtonStyle());
				this.toggle_buttons[i][j].setVisible(true);
				this.add(this.toggle_buttons[i][j]);
			}
		}

	}

}
