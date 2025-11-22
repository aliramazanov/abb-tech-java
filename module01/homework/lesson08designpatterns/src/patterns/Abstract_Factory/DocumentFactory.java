package patterns.Abstract_Factory;

abstract public class DocumentFactory {
    
    public String createDocument (Employee employee) {
        validate(employee);
        Document doc = makeDocument(employee);
        return doc.generate();
    }
    
    protected abstract Document makeDocument (Employee employee);
    
    protected void validate (Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
    }
}
