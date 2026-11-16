package assignment2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import se.his.it401g.todo.Task;

public class AlphaSort {
	private TaskPanel taskPanel;

	public void sortByAlpha(List<Task> tasks) {
		// Sort the arraylist of tasks using the comparator for alphabet.
		Collections.sort(tasks, new TaskAlphaComparator());
	}

	private class TaskAlphaComparator implements Comparator<Task> {
		@Override
		public int compare(Task t1, Task t2) {
			// Comparison between task using their inputed name.
			return t1.getText().compareToIgnoreCase(t2.getText());
		}
	}
}
