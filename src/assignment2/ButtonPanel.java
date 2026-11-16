package assignment2;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public ButtonPanel(ActionListener listener) {

		// Add the button and its action command and listener for the different
		// task types.
		JButton homeButton = new JButton("New HomeTask");
		homeButton.setActionCommand("New HomeTask");
		homeButton.addActionListener(listener);
		add(homeButton);

		JButton studyButton = new JButton("New StudyTask");
		studyButton.setActionCommand("New StudyTask");
		studyButton.addActionListener(listener);
		add(studyButton);

		JButton selfcareButton = new JButton("New SelfcareTask");
		selfcareButton.setActionCommand("New SelfcareTask");
		selfcareButton.addActionListener(listener);
		add(selfcareButton);

		// Refreshes the UI.
		revalidate();
		repaint();

	}

}
