package controller;

import java.util.ArrayList;
import java.util.Collections;

import gui_elements.ToggleButtonStyle;
import gui_elements.ToggleButtonWithId;

public class CpuPlayer {

	private BoardController panel_controller;
	private ArrayList<ToggleButtonWithId> array_of_available_buttons;
	private boolean is_cpu_turn;
	private boolean is_second_player;
	private boolean is_first_player;

	public CpuPlayer(BoardController controller, boolean is_first_player, boolean is_second_player) {
		this.panel_controller = controller;
		// cpu has first turn if it's the first player
		this.is_cpu_turn = is_first_player;
		this.is_first_player = is_first_player;
		this.is_second_player = is_second_player;
		this.initArrayOfAvailableButtons();
		this.panel_controller.setCpuPlayer(this);
		if (is_first_player) {
			this.doAMove();
		}
	}

	private void initArrayOfAvailableButtons() {
		this.array_of_available_buttons = this.panel_controller.getArrayOfAvailableButtons();
		Collections.shuffle(this.array_of_available_buttons);
	}
	
	private void checkArrayofAvailableButtons() {
		// Drop the already used elements from a the list
		for (int i = 0; i < this.array_of_available_buttons.size(); i++) {
			if (this.array_of_available_buttons.get(i).isSelected()) {
				System.out.println("Removing " + i);
				this.array_of_available_buttons.remove(i);
			}
		}
	}
	
	public void shiftTurn() {
		
	}

	public void doAMove() {
			this.checkArrayofAvailableButtons();
			this.array_of_available_buttons.get(0).setSelected(true);
			this.array_of_available_buttons.get(0).setUI(new ToggleButtonStyle(this.panel_controller.getX()));
			this.panel_controller.toggleIsX();
			this.array_of_available_buttons.get(0).setEnabled(false);
			System.out.println("Hi");
			// this.array_of_available_buttons.remove(0);
	
	}
}
