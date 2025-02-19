package command;

import command.Command;
import storage.Storage;
import task.TaskList;
import ui.Ui;

/**
 * Represents the adder command to delete the task from the task list.
 */
public class CommandDel extends Command {

    /**
     * Represents the position of the pointer.
     */
    private int position;

    /**
     * Constructor of the delete command.
     * @param i position of the task to be deleted.
     */
    public CommandDel (int i) {
        position = i;
    }

    /**
     * Executes the delete command.
     * @param tasks the task list
     * @param ui the UI
     * @param storage the storage writer
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        String curr = tasks.getList().get(position - 1).toString();
        tasks.delete(position);
        storage.save(tasks.getList(), tasks.getNoOfTasks());
        ui.printString("Noted. I've removed this task:");
        ui.printString(curr);
        ui.printString("Now you have " + tasks.getNoOfTasks() + " tasks in the list.");
        storage.save(tasks.getList(), tasks.getNoOfTasks());
    }

    /**
     * Executes the delete command on GUI.
     * @param tasks the task list
     * @param storage the storage writer
     * @return string
     */
    @Override
    public String executeForGUI(TaskList tasks, Storage storage) {
        String string = "Noted. I've removed thi task:" + "\n";
        string = string + tasks.getList().get(position - 1).toString() + "\n";
        tasks.delete(position);
        storage.save(tasks.getList(), tasks.getNoOfTasks());
        string = string + "Now you have " + tasks.getNoOfTasks() + " tasks in the list.";
        storage.save(tasks.getList(), tasks.getNoOfTasks());
        return string;
    }
}
