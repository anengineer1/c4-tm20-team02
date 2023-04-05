/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

	// Atributes meant to be deleted
	private int hover_x;
	private int hover_y;
	// X or O?
	private boolean is_x;

	// Turn from player1
	private boolean turn_player1;

	// actions
	private MouseListener on_hover_event;
	private ActionListener on_click_toggle;

	// The board
	private BoardTickTackToe ticktacktoe;

	public BoardController(BoardTickTackToe board_tick_tack_toe) {
		this.cpu_player = null;
		this.hover_x = 0;
		this.hover_y = 0;
		this.is_x = true;
		this.ticktacktoe = board_tick_tack_toe;
		this.initOnHover();
		this.initTogglePressed();
		this.initToggleButtonsActions();
	}

	private void initToggleButtonsActions() {
		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				this.ticktacktoe.getArrayOfButtons()[i][j].addMouseListener(on_hover_event);
				this.ticktacktoe.getArrayOfButtons()[i][j].addActionListener(on_click_toggle);

			}
		}
	}

	private void initTogglePressed() {
		this.on_click_toggle = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((ToggleButtonWithId) e.getSource()).setUI(new ToggleButtonStyle(is_x));
				((ToggleButtonWithId) e.getSource()).setEnabled(false);
				// if the cpu is playing we have to let the cpu
				// know it is its turn
				if (cpu_player != null) {
					// I have to toggle the symbol for the cpu
					// Then, the cpu change it again after a move
					toggleIsX();
					cpu_player.doAMove();
					toggleIsX();
				} else {
					toggleIsX();
				}

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
				// System.out.println(((ToggleButtonWithId) e.getSource()).getId_x());
				// System.out.println(((ToggleButtonWithId) e.getSource()).getId_y());
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};
	}

	public void clearButtons() {
		// this method is meant to be used when the games needs to be restarted
		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				this.ticktacktoe.getArrayOfButtons()[i][j].setEnabled(true);
				this.ticktacktoe.getArrayOfButtons()[i][j].setSelected(false);
			}
		}
	}

	public ArrayList<ToggleButtonWithId> getArrayOfAvailableButtons() {
		ArrayList<ToggleButtonWithId> array_of_available_buttons = new ArrayList<ToggleButtonWithId>();

		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				if (!this.ticktacktoe.getArrayOfButtons()[i][j].isSelected()) {
					array_of_available_buttons.add(this.ticktacktoe.getArrayOfButtons()[i][j]);
				}
			}
		}

		return array_of_available_buttons;
	}

	public void setCpuPlayer(CpuPlayer mycpuplayer) {
		this.cpu_player = mycpuplayer;
	}

	public boolean getX() {
		return this.is_x;
	}

	public void toggleIsX() {
		this.is_x = !this.is_x;
	}
}
