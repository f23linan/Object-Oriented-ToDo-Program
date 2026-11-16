package assignment2;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.his.it401g.todo.Task;

public class TaskPanel extends JPanel {
	private List<Task> tasks;
	private TypeSort typeSort;
	private AlphaSort alphaSort;
	private CompSort compSort;
	private JLabel compLabel;

	public TaskPanel(Task task) {

		this.tasks = new ArrayList<>();

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		typeSort = new TypeSort();
		alphaSort = new AlphaSort();
		compSort = new CompSort();

		compLabel = new JLabel("0 out of 0 tasks completed!");

		this.add(compLabel);

	}

	// addTask adds task both to the UI and to the array list. Also refresh the UI
	// with a method.
	public void addTask(Task task) {
		tasks.add(task);
		add(task.getGuiComponent());
		revalidate();
		repaint();
		refreshUI();
	}

	// removeTask removes task both to the UI and to the array list. Also refresh
	// the UI with a method.
	public void removeTask(Task task) {
		tasks.remove(task);
		refreshUI();
	}

	// Method to sort task by type and refreshes the UI.
	public void sortTasksByType() {
		typeSort.sortByType(tasks);
		refreshUI();
	}

	// Method to sort task by alphabetical order and refreshes the UI.
	public void sortTasksByAlpha() {
		alphaSort.sortByAlpha(tasks);
		refreshUI();
	}

	// Method to sort task by completion and refreshes the UI.
	public void sortTasksByComp() {
		compSort.sortByComp(tasks);
		refreshUI();
	}

	// Refreshes the UI.
	public void refreshUI() {
		int TotalTasks = tasks.size();
		int CompletedTasks = 0;

		removeAll();
		for (Task task : tasks) {
			add(task.getGuiComponent());
			if (task.isComplete()) {
				CompletedTasks++;
			}
		}

		// Updates the completion label with the current status of tasks.
		compLabel.setText(CompletedTasks + " out of " + TotalTasks + " tasks completed!");
		revalidate();
		repaint();
	}

	// Method to get the completion label.
	public JLabel GetLabel() {
		return compLabel;
	}

}