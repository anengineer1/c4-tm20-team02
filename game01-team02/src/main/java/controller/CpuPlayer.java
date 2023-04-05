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
	private boolean is_cpu_turn;
	private boolean is_second_player;
	private boolean is_first_player;

	public CpuPlayer(BoardController controller, boolean is_first_player, boolean is_second_player) {
		this.board_controller = controller;
		this.selected_points = new ArrayList<Point>();
		// cpu has first turn if it's the first player
		this.is_cpu_turn = is_first_player;
		this.is_first_player = is_first_player;
		this.is_second_player = is_second_player;
		this.initArrayOfAvailableButtons();
		this.board_controller.setCpuPlayer(this);
		if (is_first_player) {
			this.doAMove();
		}
	}

	private void initArrayOfAvailableButtons() {
		this.array_of_available_buttons = this.board_controller.getArrayOfAvailableButtons();
		Collections.shuffle(this.array_of_available_buttons);
	}

//	private void checkArrayofAvailableButtons() {
//		// Drop the already used elements from a the list
//		for (int i = 0; i < this.array_of_available_buttons.size(); i++) {
//			if (this.array_of_available_buttons.get(i).isSelected()) {
//				System.out.println("Removing " + i);
//				this.array_of_available_buttons.remove(i);
//			}
//		}
//	}

	public boolean checkWin() {
		// check if there's a victory
		
		// Create a 2D boolean array to represent the Tic Tac Toe board
		boolean[][] board = new boolean[3][3];

		// Update the board with the moves of each player
		for (Point move : this.selected_points) {
			board[move.x][move.y] = true;
		}

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

		// No win
		return false;
	}

	public void doAMove() {
		// this.checkArrayofAvailableButtons();
		this.initArrayOfAvailableButtons();
		this.array_of_available_buttons.get(0).setSelected(true);
		this.array_of_available_buttons.get(0).setUI(new ToggleButtonStyle(this.board_controller.getX()));
		// this.panel_controller.toggleIsX();
		this.array_of_available_buttons.get(0).setEnabled(false);
		Point current_point = new Point(this.array_of_available_buttons.get(0).getId_x(),
				this.array_of_available_buttons.get(0).getId_y());
		System.out.println(current_point);
		this.selected_points.add(current_point);
		System.out.println(this.checkWin());
	}
}