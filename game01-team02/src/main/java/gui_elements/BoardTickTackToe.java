package gui_elements;
/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class BoardTickTackToe extends JPanel {
	private final static int ROWS = 3;
	private final static int COLS = 3;

	private ToggleButtonWithId[][] toggle_buttons;

	private ToggleButtonStyle[][] ui_toggle_button_style;

	public BoardTickTackToe() {
		super(new GridLayout(ROWS, COLS));
		this.initialize();
	}

	public BoardTickTackToe(LayoutManager arg0) {
		super(arg0);
		this.initialize();
	}

	private void initialize() {
		// Atributes
		this.toggle_buttons = new ToggleButtonWithId[BoardTickTackToe.ROWS][BoardTickTackToe.COLS];
		// this.ui_toggle_button_style = new ToggleButtonStyle[BoardTickTackToe.ROWS][BoardTickTackToe.COLS];

		for (int i = 0; i < toggle_buttons.length; i++) {
			for (int j = 0; j < toggle_buttons[i].length; j++) {
				// init togglebuttonsStyles
				// this.ui_toggle_button_style[i][j] = new ToggleButtonStyle();
				this.toggle_buttons[i][j] = new ToggleButtonWithId(i,j);
				this.toggle_buttons[i][j].setContentAreaFilled(false);
				// this.toggle_buttons[i][j].setOpaque(true);
				// this.toggle_buttons[i][j].setUI(this.ui_toggle_button_style[i][j]);
				this.add(this.toggle_buttons[i][j]);
			}
		}

	}

	public void setX(int i, int j) {
		this.ui_toggle_button_style[i][j].setDrawX(true);
	}

	public void setO(int i, int j) {
		this.ui_toggle_button_style[i][j].setDrawX(false);
	}
	
	public void setCellSelected(int i, int j) {
		this.toggle_buttons[i][j].setSelected(true);
	}
	
	public void setCellUnSelected(int i, int j) {
		this.toggle_buttons[i][j].setSelected(false);
	}
	
	public ToggleButtonWithId[][] getArrayOfButtons() {
		return this.toggle_buttons;
	}
	
	public ToggleButtonWithId getCurrentButton(int x, int y) {
		return this.toggle_buttons[x][y];
	}
}
