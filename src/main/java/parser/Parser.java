package parser;

import command.*;
import exception.DukeException;

import java.util.Scanner;

/**
 * Represents the reader of the commands.
 */
public class Parser {

    /**
     * Reader of the commands.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Reads the command.
     * @param fullCommand command
     * @return a command
     * @throws DukeException error exception
     */
    public static Command parse(String fullCommand) throws DukeException {
        if (fullCommand.equals("bye")) {
            return new CommandExit(fullCommand);
        } else if (fullCommand.split(" ")[0].equals("delete")) {
            return new CommandDel(Integer.parseInt(fullCommand.split(" ")[1]));
        } else if (fullCommand.split(" ")[0].equals("list")) {
            return new CommandList();
        } else if (fullCommand.split(" ")[0].equals("done")) {
            return new CommandDone(Integer.parseInt(fullCommand.split(" ")[1]));
        } else if (fullCommand.split(" ")[0].equals("todo") ||
                    fullCommand.split(" ")[0].equals("deadline") ||
                    fullCommand.split(" ")[0].equals("event")) {
            return new CommandAdd(fullCommand);
        } else if (fullCommand.split(" ")[0].equals("find")) {
            return new CommandFind(fullCommand.split(" ", 2)[1]);
        } else if (fullCommand.split(" ")[0].equals("help")) {
            return new CommandHelp(fullCommand);
        } else {
            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        }
    }
}
