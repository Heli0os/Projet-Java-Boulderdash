package view;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class ViewFrame.
 *
 * @author Clément
 */
class ViewFrame extends JFrame implements KeyListener {

	/**
	 * The model.
	 */
	private IModel model;

	/**
	 * The controller
	 */
	private IController controller;

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = -697358409737458175L;

	/**
	 * The width
	 */
	private int width = 1000;

	/**
	 * The height
	 */
	private int height = 1000;

	/**
	 * The game panel
	 */
	private ViewPanel panel;

	/**
	 * Constructor of the frame
	 */
	ViewFrame(IModel model) {
		this.model = model;
		this.setTitle("Boulderdash");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new ViewPanel(this.model);
		this.panel.setBackground(Color.BLACK);
		this.setContentPane(this.panel);
		this.setResizable(false);
		this.addKeyListener(this);
		this.setVisible(true);
	}

	/**
	 * print a message on a window
	 * @param message the message
	 */
	public void printMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/**
	 * Method which will update the panel
	 */
	public void repaint() {
		this.panel.repaint();
	}

	/**
	 * Get the ViewPanel
	 * @return
	 * return the panel
	 */
	public ViewPanel getViewPanel() {
		return this.panel;
	}

	/**
	 * Get the width
	 * @return
	 * return the width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Get the height
	 * @return
	 * return the height
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Get the Controller
	 * @return
	 * return the controller
	 */
	public IController getController() {
		return controller;
	}

	/**
	 * Set the Controller
	 * @param controller
	 * set the controller
	 */
	public void setController(IController controller) {
		this.controller = controller;
	}

	/**
	 * Method which link the command entered from the user to the controller
	 * Used when a key is pressed by the user
	 * @param e
	 * Event producted by the action of the user
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_Z:
			case KeyEvent.VK_UP:
				this.controller.orderPerform(ControllerOrder.MOVE_UP);
				break;
			case KeyEvent.VK_Q:
			case KeyEvent.VK_LEFT:
				this.controller.orderPerform(ControllerOrder.MOVE_LEFT);
				break;
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				this.controller.orderPerform(ControllerOrder.MOVE_DOWN);
				break;
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:	
				this.controller.orderPerform(ControllerOrder.MOVE_RIGHT);
				break;
			case KeyEvent.VK_ESCAPE:
				this.controller.orderPerform(ControllerOrder.PAUSED);
				break;
		}
	}

	/**
	 * Method which link the command entered from the user to the controller but not used
	 * @param e
	 * Event producted by the action of the user
	 */
	public void keyReleased(KeyEvent e) {

	}

	/**
	 * Method which link the command entered from the user to the controller but not used
	 * @param e
	 * Event producted by the action of the user
	 */
	public void keyTyped(KeyEvent e) {

	}
}
