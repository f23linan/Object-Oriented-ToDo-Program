package assignment2;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompletionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel compLabel;

	public CompletionPanel() {
		// Creates the default label for when no tasks are added or completed.
		compLabel = new JLabel("0 out of 0 tasks completed!");
		this.add(compLabel);
	}

	public void getLabel(int CompletedTasks, int TotalTasks) {
		// Updates the text of the label to show the current completed task and total
		// tasks.
		compLabel.setText(CompletedTasks + " out of " + TotalTasks + " tasks completed!");

		// Refreshes the UI.
		this.revalidate();
		this.repaint();
	}
}
