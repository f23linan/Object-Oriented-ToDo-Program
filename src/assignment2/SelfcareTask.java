package assignment2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.TaskListener;

/**
 * Implements a simple study task type, following the Task.java interface class.
 * 
 * This file licensed under the
 * <a href="https://creativecommons.org/licenses/by/4.0/">Creative Commons (CC)
 * BY 4.0 license</a>.
 * 
 * @author Dr. Erik Billing, University of Skovde
 *
 */
public class SelfcareTask extends JPanel implements Task {

	/**
	 * The editable text field.
	 */
	private JTextField text;

	/**
	 * The non editable text label.
	 */
	private JLabel textLabel;

	/**
	 * Check box holding the completion status and importance.
	 */
	JCheckBox completed = new JCheckBox("✔");
	JCheckBox important = new JCheckBox("!");
	private Color defaultColor;

	/**
	 * The task listener used for reporting changes to the main application.
	 */
	private TaskListener listener;

	/**
	 * This is the constructor for the task, initiating the GUI component for the
	 * task. Several listeners are used to react to various events in the GUI.
	 */
	public SelfcareTask() {
		super(new BorderLayout());
		this.text = new JTextField("New task", 20);
		this.textLabel = new JLabel();
		this.textLabel.setVisible(false);
		this.defaultColor = getBackground();

		JPanel center = new JPanel();
		center.add(text);
		center.add(textLabel);
		add(center, BorderLayout.CENTER);

		TaskInputListener inputListener = new TaskInputListener(this, text, textLabel);
		this.text.addKeyListener(inputListener);
		this.textLabel.addMouseListener(inputListener);

		JButton remove = new JButton("Remove");
		add(remove, BorderLayout.EAST);
		remove.addActionListener(inputListener);

		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.X_AXIS));

		completed.setVisible(true);
		important.setVisible(true);

		checkBoxPanel.add(completed);
		checkBoxPanel.add(important);

		checkBoxPanel.setPreferredSize(new Dimension(70, 50));

		add(checkBoxPanel, BorderLayout.WEST);
		
		completed.addItemListener(inputListener);
		
		setMaximumSize(new Dimension(1000, 50));
		setBorder(new TitledBorder(getTaskType()));

		important.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (important != null && important.isSelected()) {
					// Ensure the component is opaque and sets it color to red
					setOpaque(true);
					center.setBackground(Color.RED);
				} else {
					// Reset background if not selected
					center.setBackground(defaultColor);
				}
				revalidate();
				repaint();

			}
		});
	}

	@Override
	public String getText() {
		return text.getText();
	}

	@Override
	public String getTaskType() {
		return "Selfcare";
	}

	@Override
	public void setTaskListener(TaskListener t) {
		listener = t;
	}

	@Override
	public TaskListener getTaskListener() {
		return listener;
	}

	@Override
	public boolean isComplete() {
		return completed.isSelected();
	}

	@Override
	public Component getGuiComponent() {
		// Since this class extends JPanel, it is itself a GUI component, and thus we
		// can return "this".
		return this;
	}

}