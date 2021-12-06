public interface IUndoRedoManager {
    /**
     * Executes the command given to the manage
     * @param command Command to be executed
     */
    void executeCommand(Command command);

    /**
     * Undo the most recently executed command, if any
     */
    void undo();

    /**
     * Redo the most recently reversed command, if any
     */
    void redo();

    /**
     * Check if there is any command that can be undone
     * @return true if any commands can be redone, false if otherwise
     */
    boolean canUndo();

    /**
     * Check if there is any command that can be redone
     * @return true if any commands can be redone, false if otherwise
     */
    boolean canRedo();

    /**
     * Reset the manager in order to reflect a newly opened state
     */
    void clear();
}
