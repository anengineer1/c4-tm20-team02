package controller;

import java.awt.Point;

import java.util.ArrayList;
import java.util.Collections;

import gui_elements.ToggleButtonStyle;
import gui_elements.ToggleButtonWithId;

public class CpuPlayer {

	private BoardController board_controller;
	private ArrayList<ToggleButtonWithId> array_of_available_buttons;
	private ArrayList<Point> selected_points;

	/**
	 * The contructor must have the boardcontroller so the AI can manipulate the
	 * board
	 */
	public CpuPlayer(BoardController controller, boolean is_first_player, boolean is_second_player) {

		this.board_controller = controller;
		this.selected_points = new ArrayList<Point>();

		this.initArrayOfAvailableButtons();

		this.board_controller.setCpuPlayer(this);
		// Only move first if its the first player
		if (is_first_player) {
			this.doAMove();
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
	 * Check if the cpu won, returns "true" if cpu won and "false" Otherwise
	 */
	public boolean checkWin() {

		// Create a 2D boolean array to represent the Tic Tac Toe board
		boolean[][] board = new boolean[3][3];

		// Update the board with the moves of each player
		// selected points are the cells chose by the
		// computer
		for (Point move : this.selected_points) {
			board[move.x][move.y] = true;
		}

		/*-- The following lines make checks for every win combination--*/
		// Check rows
		for (int i = 0; i < 3; i++) {
			if (board[i][0] && board[i][1] && board[i][2]) {
				return true;
			}
		}

		// Check columns
		for (int i = 0; i < 3; i++) {
			if (board[0][i] && board[1][i] && board[2][i]) {
				return true;
			}
		}

		// Check diagonals
		if (board[0][0] && board[1][1] && board[2][2]) {
			return true;
		}
		if (board[0][2] && board[1][1] && board[2][0]) {
			return true;
		}

		// If any of the previous conditions occur, there's no win
		return false;
	}

	/**
	 * Method that makes the cpu do a move
	 */
	public void doAMove() {

		// make sure the cpu knows which cells it can press
		this.initArrayOfAvailableButtons();

		// gets the first value of the randomized list
		this.array_of_available_buttons.get(0).setSelected(true);
		this.array_of_available_buttons.get(0).setUI(new ToggleButtonStyle(this.board_controller.getX()));
		this.array_of_available_buttons.get(0).setEnabled(false);
		Point current_point = new Point(this.array_of_available_buttons.get(0).getId_x(),
				this.array_of_available_buttons.get(0).getId_y());
		this.selected_points.add(current_point);
	}
}
