import java.util.Stack;

public class UndoRedoManager implements IUndoRedoManager {
    private Stack<Command> _undoStack;
    private Stack<Command> _redoStack;

    public UndoRedoManager() {
        _undoStack = new Stack<>();
        _redoStack = new Stack<>();
    }

    @Override
    public void executeCommand(Command command) {
        try {
            command.execute();
        }
        catch (Command.CommandExecutionException e) {
            System.out.println("Action unsuccessful");
            return;
        }
        _redoStack.clear();
        _undoStack.push(command);
    }

    @Override
    public void undo() {
        if (canUndo()) {
            Command command = _undoStack.pop();
            command.reverse();
            _redoStack.push(command);
        }
    }

    @Override
    public void redo() {
        if (canRedo()) {
            Command command = _redoStack.pop();
            try {
                command.execute();
            }
            catch (Command.CommandExecutionException e) {
                _redoStack.clear();
                System.out.println("Redo failed");
                return;
            }
            _undoStack.push(command);
        }
    }

    @Override
    public boolean canUndo() {
        return !_undoStack.isEmpty();
    }

    @Override
    public boolean canRedo() {
        return !_redoStack.isEmpty();
    }

    @Override
    public void clear() {
        _undoStack.clear();
        _redoStack.clear();
    }
}
