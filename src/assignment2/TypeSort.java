package assignment2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.his.it401g.todo.Task;

public class TypeSort {
	private TaskPanel taskPanel;

	public void sortByType(List<Task> tasks) {
		// Sort the arraylist of tasks using the comparator for task type.
		Collections.sort(tasks, new TaskTypeComparator());
	}

	private class TaskTypeComparator implements Comparator<Task> {
		@Override
		public int compare(Task t1, Task t2) {
			// Comparison between task using their task type.
			return t1.getTaskType().compareTo(t2.getTaskType());
		}
	}
}
