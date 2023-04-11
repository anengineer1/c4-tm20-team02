package models;

import java.awt.Point;

import java.util.ArrayList;
import java.util.Collections;

import controller.BoardController;
import gui_elements.ToggleButtonStyle;
import gui_elements.ToggleButtonWithId;

public class CpuPlayer {

	// to know if it's player 1 or 2
	private PlayerSlot player;
	private BoardController board_controller;
	private ArrayList<ToggleButtonWithId> array_of_available_buttons;
	private ArrayList<Point> selected_points;

	/**
	 * The contructor must have the boardcontroller so the AI can manipulate the
	 * board
	 */
	public CpuPlayer(BoardController controller, PlayerSlot slot) {

		this.board_controller = controller;
		this.selected_points = new ArrayList<Point>();
		this.player = slot;

		this.initArrayOfAvailableButtons();

		this.board_controller.setCpuPlayer(this);
		// Only move first if its the first player
		if (slot == PlayerSlot.PLAYER_1) {
			this.doAMove();
			this.board_controller.toggleIsX();
			this.board_controller.togglePlayerTurn();
		}
	}

	/**
	 * Captures a list of the available buttons that ai can press and stores it in
	 * an internal atribute. Each button also contains its location
	 */
	private void initArrayOfAvailableButtons() {

		this.array_of_available_buttons = this.board_controller.getArrayOfAvailableButtons();

		// Randomizes the list
		Collections.shuffle(this.array_of_available_buttons);
	}

	/**
	 * Method that makes the cpu do a move
	 */
	public void doAMove() {

		// make sure the cpu knows which cells it can press
		this.initArrayOfAvailableButtons();

		// gets the first value of the randomized list
		this.array_of_available_buttons.get(0).setSelected(true);
		this.array_of_available_buttons.get(0).setPlayer(this.player);
		this.array_of_available_buttons.get(0).setUI(new ToggleButtonStyle(this.board_controller.getX()));
		this.array_of_available_buttons.get(0).setEnabled(false);
		Point current_point = new Point(this.array_of_available_buttons.get(0).getId_x(),
				this.array_of_available_buttons.get(0).getId_y());
		this.selected_points.add(current_point);
		System.out.println("moving");
	}
}
