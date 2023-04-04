package org.TA20.game01_team02;

import java.awt.EventQueue;

import gui_elements.MainView;

/**
 * GAME01-TEAM02( Marc Rojo, Francisco, Elena)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	/**
    	 * Launch the application.
    	 */
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
