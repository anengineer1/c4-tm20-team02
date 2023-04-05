package gui_elements;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JToggleButton;

public class ToggleButtonWithId extends JToggleButton {
	
	private int id_x;
	private int id_y;
	
	public ToggleButtonWithId(int x, int y) {
		this.setId_x(x);
		this.setId_y(y);
	}

	public ToggleButtonWithId() {
		super();

	}

	public ToggleButtonWithId(Action a) {
		super(a);

	}

	public ToggleButtonWithId(Icon icon, boolean selected) {
		super(icon, selected);

	}

	public ToggleButtonWithId(Icon icon) {
		super(icon);

	}

	public ToggleButtonWithId(String text, boolean selected) {
		super(text, selected);

	}

	public ToggleButtonWithId(String text, Icon icon, boolean selected) {
		super(text, icon, selected);

	}

	public ToggleButtonWithId(String text, Icon icon) {
		super(text, icon);

	}

	public ToggleButtonWithId(String text) {
		super(text);

	}

	public int getId_x() {
		return id_x;
	}

	public void setId_x(int id_x) {
		this.id_x = id_x;
	}

	public int getId_y() {
		return id_y;
	}

	public void setId_y(int id_y) {
		this.id_y = id_y;
	}

}
