public interface Command {
    /**
     * Do command
     */
    void execute();

    /**
     * Undo command
     */
    void reverse();
}
