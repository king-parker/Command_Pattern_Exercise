public class StartCommand implements Command {
    private IDocument _document;
    private String _sequence;

    public StartCommand(IDocument document) {
        _document = document;
        _sequence = _document.sequence().toString();
    }

    @Override
    public void execute() {
        _document.clear();
    }

    @Override
    public void reverse() {
        _document.clear();
        _document.insert(0, _sequence);
    }
}
