import java.util.Stack;

public class UndoRedoManager {
    private Stack<Command> undoStack;
    private Stack<Command> redoStack;

    public UndoRedoManager() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void executeCommand(Command command) {
        redoStack.clear();
        command.execute();
        undoStack.push(command);
    }

    public void undo() {
        if (canUndo()) {
            Command command = undoStack.pop();
            command.reverse();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (canRedo()) {
            Command command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }
    }

    public boolean canUndo() {
        return !undoStack.isEmpty();
    }

    public boolean canRedo() {
        return !redoStack.isEmpty();
    }
}
