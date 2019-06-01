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

		this.level=this.model.getLevel();
		if(this.level == null)System.err.println("level null in viewPanel builder");
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
		this.level=this.model.getLevel();

		for (int y = 0; y <= this.model.getLevel().getDimensions().getHeight(); y++) {
			for (int x = 0; x<= this.model.getLevel().getDimensions().getWidth(); x++) {
				IElements element = this.model.getLevel().getElement(x,y);
				graphics.drawImage(element.getSprite().getImage().getScaledInstance(45,45,Image.SCALE_AREA_AVERAGING),x*45,y*45,this);
			}
		}
		if (this.model.getLevel().isPaused()) {
			gamePaused(graphics);
;		}
		else if (this.model.getLevel().isFinished()) {
			levelFinished(graphics);
		}
		else if (!this.level.getPlayer().isAlive()) {
			gameLost(graphics);
		}
	}

	/**
	 * A panel that appears when the game is paused
	 * @param graphics The graphics
	 */
	void gamePaused (Graphics graphics) {
		graphics.fillRect(300, 400, 400, 200);
		graphics.setColor(Color.WHITE);
		this.setFont(new Font ("Dialog", Font.BOLD, 20));
		graphics.drawString("The game is Paused, press echap to resume", 375, 450);
		graphics.drawString(model.getLevel().getDiamondsCollected() + " / "+model.getLevel().getDiamondsNumber() + " Diamonds collected", 375, 550);
	}

	/**
	 * A panel that appears when the player dies
	 * @param graphics The graphics
	 */
	void gameLost (Graphics graphics) {
		graphics.fillRect(300, 400, 400, 200);
		graphics.setColor(Color.WHITE);
		this.setFont(new Font ("Dialog", Font.BOLD, 20));
		graphics.drawString("You died, the game is lost", 375, 450);
		graphics.drawString(model.getLevel().getDiamondsCollected() + " / "+model.getLevel().getDiamondsNumber() + " Diamonds collected", 375, 550);
	}

	/**
	 * A panel that appears when a level is finished
	 * @param graphics The graphics
	 */
	void levelFinished(Graphics graphics) {
		graphics.fillRect(300, 400, 400, 200);
		graphics.setColor(Color.WHITE);
		this.setFont(new Font ("Dialog", Font.BOLD, 20));
		graphics.drawString("Congratulations on winning this level", 375, 450);
		graphics.drawString(model.getLevel().getDiamondsCollected() + " / "+model.getLevel().getDiamondsNumber() + " Diamonds collected", 375, 550);
	}
}
