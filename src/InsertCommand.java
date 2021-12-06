public class InsertCommand implements Command {
    private IDocument _document;
    private int _insertionIndex;
    private String _sequenceInput;

    public InsertCommand(IDocument document, int insertionIndex, String sequenceInput) {
        _document = document;
        _insertionIndex = insertionIndex;
        _sequenceInput = sequenceInput;
    }

    @Override
    public void execute() {
        _document.insert(_insertionIndex, _sequenceInput);
    }

    @Override
    public void reverse() {
        _document.delete(_insertionIndex, _sequenceInput.length());
    }
}
