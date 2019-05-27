package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import contract.IModel;
import contract.ILevel;
import javax.swing.JPanel;

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
	/** The view frame. */

	private ViewFrame viewFrame;
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel() {
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable observable, final Object object) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		if (this.model.getLevel().isFinished()) {
			graphics.drawString("Congratulations on winning this level", 300, 400);
			graphics.drawString("Number of diamonds collected : "+model.getLevel().getDiamondsCollected() +"/ "+model.getLevel().getDiamondsNumber(), 300, 500);
			graphics.drawString("The game is now loading the next level", 300, 600);

		}
		else if (!this.model.getLevel().getPlayer.isAlive()) {
			graphics.drawString("You died, the game is lost", 400, 450);
			graphics.drawString("Number of diamonds collected : "+model.getLevel().getDiamondsCollected() +"/ "+model.getLevel().getDiamondsNumber(), 300, 550);
			model.setDiamondCounter(0);
		}
	}
}
