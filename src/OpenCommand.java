public class OpenCommand implements Command {
    private IDocument _document;
    private String _fileName;
    private String _sequence;

    public OpenCommand(IDocument document, String fileName) {
        _document = document;
        _fileName = fileName;
        _sequence = _document.sequence().toString();
    }

    @Override
    public void execute() {
        _document.open(_fileName);
    }

    @Override
    public void reverse() {
        _document.clear();
        _document.insert(0,_sequence);
    }
}
