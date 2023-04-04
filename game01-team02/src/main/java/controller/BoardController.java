/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import gui_elements.BoardTickTackToe;
import gui_elements.ToggleButtonStyle;
import gui_elements.ToggleButtonWithId;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class BoardController {

	// Atributes
	private int hover_x;
	private int hover_y;
	// X or O?
	private boolean is_x;

	// actions
	private MouseListener on_hover_event;
	private ActionListener on_click_toggle;

	private BoardTickTackToe ticktacktoe;

	public BoardController(BoardTickTackToe board_tick_tack_toe) {
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
				is_x = !is_x;
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
				System.out.println(((ToggleButtonWithId) e.getSource()).getId_x());
				System.out.println(((ToggleButtonWithId) e.getSource()).getId_y());
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};
	}

	public void clearButtons() {
		for (int i = 0; i < this.ticktacktoe.getArrayOfButtons().length; i++) {
			for (int j = 0; j < this.ticktacktoe.getArrayOfButtons()[i].length; j++) {
				this.ticktacktoe.getArrayOfButtons()[i][j].setEnabled(true);
				this.ticktacktoe.getArrayOfButtons()[i][j].setSelected(false);
			}
		}
	}
}
