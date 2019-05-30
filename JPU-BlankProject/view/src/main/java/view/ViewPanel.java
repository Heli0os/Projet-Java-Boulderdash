package view;

import contract.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The Class ViewPanel.
 *
 * @author Clément
 */
class ViewPanel extends JPanel implements Observer {

	/** The model. */
	private IModel model;
	/** The level. */
	private ILevel level;
	/**
	 * The controller
	 */
	private IController controller;
	/** The view frame. */
	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;

	/**
	 * The constructor of the viewPanel
	 */
	public ViewPanel(IModel model) {
		this.model=model;
		this.level=model.getLevel();
		setVisible(true);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/**
	 * Update the view
	 * @param observable The observable
	 * @param object The object
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable observable, final Object object) {
		this.repaint();
	}

	/**
	 * Draw the components on the frame
	 * @param graphics The graphics
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		graphics.drawString("Player control : Z (UP), Q (LEFT), S (DOWN), D (RIGHT)", 450, 500);

		for (int y = 0; y< this.level.getDimensions().getHeight(); y++) {
			for (int x = 0; x< this.level.getDimensions().getWidth(); x++) {
				IElements elements = this.level.getElement(x,y);
				graphics.drawImage(elements.getSprite().getImage(),x,y,this);
			}
		}
		if (this.level.isFinished() && this.level.getPlayer().isAlive()) {
			graphics.drawString("Congratulations on winning this level", 300, 400);
			graphics.drawString("Number of diamonds collected : "+model.getLevel().getDiamondsCollected() +"/ "+model.getLevel().getDiamondsNumber(), 300, 500);
			graphics.drawString("The game is now loading the next level", 300, 600);
		}
		else if (this.controller.isGamePaused()) {
			graphics.drawString("The game is Paused, press echap to resume"+model.getLevel().getDiamondsCollected() +"/ "+model.getLevel().getDiamondsNumber(), 300, 500);
		}
		else if (!this.level.getPlayer().isAlive()) {
			graphics.drawString("You died, the game is lost", 400, 450);
			graphics.drawString("Number of diamonds collected : "+model.getLevel().getDiamondsCollected() +"/ "+model.getLevel().getDiamondsNumber(), 300, 550);
		}
	}
}
