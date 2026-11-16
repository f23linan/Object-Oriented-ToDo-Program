package assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SortPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private TaskPanel taskPanel;

	public SortPanel(TaskPanel taskPanel) {
		this.taskPanel = taskPanel;

		// Creates a button for sorting tasks by type. Also sets action listener.
		JButton SortTypeButton = new JButton("Sort by type");
		SortTypeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taskPanel.sortTasksByType();
			}
		});
		add(SortTypeButton);

		// Creates a button for sorting tasks by alphabetical order. Also sets action
		// listener.
		JButton SortAlphaButton = new JButton("Sort by A-Z");
		SortAlphaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taskPanel.sortTasksByAlpha();
			}
		});
		add(SortAlphaButton);

		// Creates a button for sorting tasks by completion. Also sets action listener.
		JButton SortCompButton = new JButton("Sort by completion");
		SortCompButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				taskPanel.sortTasksByComp();
			}
		});
		add(SortCompButton);

	}

}
