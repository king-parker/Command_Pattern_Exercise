public interface Command {
    /**
     * Custom exception class to handle exceptions specific to command interface implementation class
     */
    class CommandExecutionException extends Exception {}

    /**
     * Do command
     */
    void execute() throws CommandExecutionException;

    /**
     * Undo command
     */
    void reverse();
}
