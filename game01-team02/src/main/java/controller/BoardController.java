/**
 * 
 */
package controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import clases.PlayerSlot;
import gui_elements.BoardTickTackToe;
import gui_elements.ToggleButtonStyle;
import gui_elements.ToggleButtonWithId;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class BoardController {
	// CPU to send signals back in case the CPU is one of the players
	private CpuPlayer cpu_player;

	// X or O?
	private boolean is_x;
	// this defines who's turn is
	private PlayerSlot turn;

	// actions
	private MouseListener on_hover_event;
	private ActionListener on_click_toggle;

	// The board
	private BoardTickTackToe ticktacktoe;

	/**
	 * A board is needed for the controller to work
	 *
	 */
	public BoardController(BoardTickTackToe board_tick_tack_toe) {

		// Initially, we don't have communication with any cpu
		this.cpu_player = null;
		this.is_x = true;
		this.turn = PlayerSlot.PLAYER_1;
		this.ticktacktoe = board_tick_tack_toe;
		this.initOnHover();
		this.initTogglePressed();
		this.initToggleButtonsActions();
	}

	/**
	 * Initializes every button with the listeners
	 */
	private void initToggleButtonsActions() {

		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				this.ticktacktoe.getArrayOfButtons()[i][j].addMouseListener(on_hover_event);
				this.ticktacktoe.getArrayOfButtons()[i][j].addActionListener(on_click_toggle);

			}
		}
	}

	/**
	 * Initializes the action when an user presses the button on the grid
	 */
	private void initTogglePressed() {

		this.on_click_toggle = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((ToggleButtonWithId) e.getSource()).setUI(new ToggleButtonStyle(is_x));
				((ToggleButtonWithId) e.getSource()).setPlayer(turn);
				((ToggleButtonWithId) e.getSource()).setEnabled(false);
				// if the cpu is playing we have to let the cpu
				// know it is its turn
				if (cpu_player != null) {
					// I have to toggle the symbol for the cpu
					// Then, the cpu change it again after a move
					toggleIsX();
					togglePlayerTurn();
					cpu_player.doAMove();
					((ToggleButtonWithId) e.getSource()).setPlayer(turn);
					if (isGameFinished()) {
						System.out.println("Game finished"); // we have to replace this line once the GUI is finished
					} else {
						toggleIsX();
						togglePlayerTurn();
					}
				} else if (isGameFinished()) { // This section of the code is not tested
					System.out.println("Game finished"); // we have to replace this line once the GUI is finished
					ticktacktoe.blockBoard();
				} else {
					toggleIsX();
					togglePlayerTurn();
				}
				System.out.println("Now it's turn: " + turn);

			}
		};
	}

	private void initOnHover() {
		this.on_hover_event = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
//				System.out.println(((ToggleButtonWithId) e.getSource()).getId_x());
//				System.out.println(((ToggleButtonWithId) e.getSource()).getId_y());
//				System.out.println(((ToggleButtonWithId) e.getSource()).getPlayer());
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};
	}

	/**
	 * This method is meant to be used when the games needs to be restarted
	 */
	public void clearButtons() {

		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				this.ticktacktoe.getArrayOfButtons()[i][j].setEnabled(true);
				this.ticktacktoe.getArrayOfButtons()[i][j].setSelected(false);
			}
		}
	}

	/**
	 * Returns an array of buttons yet to be pushed
	 */
	public ArrayList<ToggleButtonWithId> getArrayOfAvailableButtons() {

		ArrayList<ToggleButtonWithId> array_of_available_buttons = new ArrayList<ToggleButtonWithId>();

		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				if (!this.ticktacktoe.getCurrentButton(i, j).isSelected()) {
					array_of_available_buttons.add(this.ticktacktoe.getCurrentButton(i, j));
				}
			}
		}

		return array_of_available_buttons;
	}

	/**
	 * When a cpu player is parsed, it will be able to reply to user input
	 */
	public void setCpuPlayer(CpuPlayer mycpuplayer) {

		this.cpu_player = mycpuplayer;
	}

	/**
	 * True if the turn corresponds to an 'X'
	 */
	public boolean getX() {

		return this.is_x;
	}

	/**
	 * Toggle the use of 'X' and 'O'
	 */
	public void toggleIsX() {

		this.is_x = !this.is_x;
	}

	public void togglePlayerTurn() {

		switch (this.turn) {
		case PLAYER_1:
			this.turn = PlayerSlot.PLAYER_2;
			break;

		case PLAYER_2:
			this.turn = PlayerSlot.PLAYER_1;
			break;

		default:
			break;
		}

	}

	/**
	 * Given the player, returns all the buttons that player pressed
	 */
	public ArrayList<ToggleButtonWithId> getPlayerPressedButtons(PlayerSlot player) {
		ArrayList<ToggleButtonWithId> list_of_buttons = new ArrayList<ToggleButtonWithId>();
		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				if (this.ticktacktoe.getCurrentButton(i, j).getPlayer() == player) {
					list_of_buttons.add(this.ticktacktoe.getCurrentButton(i, j));
				}
			}
		}
		return list_of_buttons;
	}

	/**
	 * Given the PlayerSlot, it returns of that player won or not
	 */
	public boolean didPlayerWon(PlayerSlot player) {

		/*-- The following lines make checks for every win combination--*/
		// Check rows
		for (int i = 0; i < 3; i++) {
//			System.out.println("Getplayer: " + this.ticktacktoe.getCurrentButton(i, 0).getPlayer());
//			System.out.println("Getplayer: " + this.ticktacktoe.getCurrentButton(i, 1).getPlayer());
//			System.out.println("Getplayer: " + this.ticktacktoe.getCurrentButton(i, 2).getPlayer());
//			System.out.println("--------------------------------");
			if (this.ticktacktoe.getCurrentButton(i, 0).getPlayer() == player
					&& this.ticktacktoe.getCurrentButton(i, 1).getPlayer() == player
					&& this.ticktacktoe.getCurrentButton(i, 2).getPlayer() == player) {
				return true;
			}
		}

		// Check columns
		for (int i = 0; i < 3; i++) {
			if (this.ticktacktoe.getCurrentButton(0, i).getPlayer() == player
					&& this.ticktacktoe.getCurrentButton(1, i).getPlayer() == player
					&& this.ticktacktoe.getCurrentButton(2, i).getPlayer() == player) {
				return true;
			}
		}

		// Check diagonals
		if (this.ticktacktoe.getCurrentButton(0, 0).getPlayer() == player
				&& this.ticktacktoe.getCurrentButton(1, 1).getPlayer() == player
				&& this.ticktacktoe.getCurrentButton(2, 2).getPlayer() == player) {
			return true;
		}
		if (this.ticktacktoe.getCurrentButton(0, 2).getPlayer() == player
				&& this.ticktacktoe.getCurrentButton(1, 1).getPlayer() == player
				&& this.ticktacktoe.getCurrentButton(2, 0).getPlayer() == player) {
			return true;
		}

		// If any of the previous conditions occur, there's no win
		return false;
	}

	/**
	 * It returns who won the match, it returns NON if there's no winner. Keep in
	 * mind that it doesn't check if the match ended or not, use in combination with
	 * isGameFinished()
	 */
	public PlayerSlot winner() {
		if (this.didPlayerWon(PlayerSlot.PLAYER_1)) {
			return PlayerSlot.PLAYER_1;
		} else if (this.didPlayerWon(PlayerSlot.PLAYER_2)) {
			return PlayerSlot.PLAYER_2;
		} else {
			return PlayerSlot.NON; // No winner or game not finished
		}

	}

	public boolean isGameFinished() {
		System.out.println("Player 1: " + didPlayerWon(PlayerSlot.PLAYER_1));
		System.out.println("Player 2: " + didPlayerWon(PlayerSlot.PLAYER_2));
		System.out.println("--------------------------------");
		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				if (this.ticktacktoe.getCurrentButton(i, j).getPlayer() == PlayerSlot.NON
						&& !(didPlayerWon(PlayerSlot.PLAYER_1) || didPlayerWon(PlayerSlot.PLAYER_2))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Unlocks the Board and restarts the state
	 */
	public void restartGame() {
		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				this.ticktacktoe.getCurrentButton(i, j).setEnabled(true);
				this.ticktacktoe.getCurrentButton(i, j).setSelected(false);
				this.ticktacktoe.getCurrentButton(i, j).setPlayer(PlayerSlot.NON);
			}
		}
	}
}
