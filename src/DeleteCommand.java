public class DeleteCommand implements Command {
    private IDocument _document;
    private int _deletionIndex;
    private int _deletionDistance;
    private String _deletionSequence;

    public DeleteCommand(IDocument document, int deletionIndex, int deletionDistance) {
        _document = document;
        _deletionIndex = deletionIndex;
        _deletionDistance = deletionDistance;
    }

    @Override
    public void execute() throws CommandExecutionException {
        _deletionSequence = _document.delete(_deletionIndex, _deletionDistance);
        if (_deletionSequence == null) {
            throw new CommandExecutionException();
        }
    }

    @Override
    public void reverse() {
        _document.insert(_deletionIndex, _deletionSequence);
    }
}
