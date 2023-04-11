package gui_elements;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JToggleButton;

import models.PlayerSlot;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class ToggleButtonWithId extends JToggleButton {
	
	private int id_x;
	private int id_y;
	private PlayerSlot player;
	
	public ToggleButtonWithId(int x, int y) {
		this.setId_x(x);
		this.setId_y(y);
		this.player = PlayerSlot.NON;
		setBackground(Color.ORANGE);
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, null, null, null));
		setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 75));
	}

	public ToggleButtonWithId(int x, int y, PlayerSlot player) {
		this.setId_x(x);
		this.setId_y(y);
		this.setPlayer(player);
		setBackground(Color.ORANGE);
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, null, null, null));
		setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 75));
	}
	
	public ToggleButtonWithId() {
		super();
		setBackground(Color.ORANGE);
		setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, null, null, null));
		setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 75));
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
	
	public void setPlayer(PlayerSlot slot) {
		this.player = slot;
	}
	
	public PlayerSlot getPlayer() {
		return this.player;
	}

}
