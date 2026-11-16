package assignment2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

public class ToDo extends JFrame implements TaskListener, ActionListener {

	private static final long serialVersionUID = 1L;

	private TaskPanel taskPanel;

	public ToDo() {
		// Name and size of the application window.
		super("ToDo <3");
		setBounds(90, 90, 500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		add(new ButtonPanel(this), BorderLayout.NORTH);

		taskPanel = new TaskPanel(null);
		add(taskPanel, BorderLayout.CENTER);

		// Create new panel for completion label and sorting panel for the buttons.
		JPanel Footer = new JPanel();
		Footer.setLayout(new BoxLayout(Footer, BoxLayout.Y_AXIS));

		// Add label to the footer panel.
		JLabel completionLabel = taskPanel.GetLabel();
		Footer.add(completionLabel);

		// Add sorting panel to the footer.
		SortPanel sortPanel = new SortPanel(taskPanel);
		Footer.add(sortPanel);

		// Adds footer to the bottom of window.
		add(Footer, BorderLayout.SOUTH);

	}

	void start() {
		setVisible(true);
	}

	public static void main(String[] args) {
		ToDo todo = new ToDo();
		todo.start();
	}

	// ActionListener method that handles the click events of the task buttons.
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		Task task = null;
		switch (command) {
		case "New HomeTask":
			task = new HomeTask();
			break;
		case "New StudyTask":
			task = new StudyTask();
			break;
		case "New SelfcareTask":
			task = new SelfcareTask();
			break;
		}
		if (task != null) {
			task.setTaskListener(this);
			taskCreated(task);
		}

	}

	// TaskListener method that is called when a new task is created and adds the
	// created task to the taskPanel.
	@Override
	public void taskCreated(Task t) {
		taskPanel.addTask(t);
	}

	// TaskListener method that is called when a task is removed and deletes the
	// task from the taskPanel.
	@Override
	public void taskRemoved(Task t) {
		taskPanel.removeTask(t);
	}

	// TaskListener method that is called when a task is changed. Not used for this
	// case.
	@Override
	public void taskChanged(Task t) {
	}

	// TaskListener method that is called when a task is marked as completed.
	@Override
	public void taskCompleted(Task t) {
		taskPanel.refreshUI();
	}

	// TaskListener method that is called when a task is marked as uncompleted.
	@Override
	public void taskUncompleted(Task t) {
		taskPanel.refreshUI();
	}

	// Method to sort tasks by type and refresh the UI.
	public void sortTasksByType() {
		taskPanel.sortTasksByType();
		taskPanel.refreshUI();
	}
	
	// Method to sort tasks by alphabetical order and refresh the UI.
	public void sortTasksByAlpha() {
		taskPanel.sortTasksByAlpha();
		taskPanel.refreshUI();
	}
	
	// Method to sort tasks by completion status and refresh the UI.
	public void sortTasksByComp() {
		taskPanel.sortTasksByComp();
		taskPanel.refreshUI();
	}

}
