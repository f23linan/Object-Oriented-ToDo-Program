package assignment2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import se.his.it401g.todo.Task;

public class CompSort {
	private TaskPanel taskPanel;

	public void sortByComp(List<Task> tasks) {
		// Sort the arraylist of tasks using the comparator for completion status.
		Collections.sort(tasks, new TaskCompComparator());
	}

	private class TaskCompComparator implements Comparator<Task> {
		@Override
		public int compare(Task t1, Task t2) {
			// Comparison between task using their completion status.
			return Boolean.compare(t1.isComplete(), t2.isComplete());
		}
	}
}
