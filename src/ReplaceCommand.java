public class ReplaceCommand implements Command {
    private IDocument _document;
    private int _replaceIndex;
    private int _replaceDistance;
    private String _replaceSequence;
    private String _removedSequence;
    private int _removedDistance;

    public ReplaceCommand(IDocument document, int replaceIndex, int replaceDistance, String replaceSequence) {
        _document = document;
        _replaceIndex = replaceIndex;
        _replaceDistance = replaceDistance;
        _replaceSequence = replaceSequence;
    }

    @Override
    public void execute() {
        _removedSequence = _document.delete(_replaceIndex, _replaceDistance);
        _removedDistance = _replaceSequence.length();
        _document.insert(_replaceIndex, _replaceSequence);
    }

    @Override
    public void reverse() {
        _document.delete(_replaceIndex, _removedDistance);
        _document.insert(_replaceIndex, _removedSequence);
    }
}
