package patterns.Abstract_Factory;

public class Main {
    
    static void main () {
        
        Employee ali = new Employee("E001", "Ali");
        Employee sara = new Employee("E002", "Sara");
        
        DocumentFactory paymentFactoryForAli = new PaymentFactory(5000);
        DocumentFactory paymentFactoryForSara = new PaymentFactory(5500);
        
        System.out.println(paymentFactoryForAli.createDocument(ali));
        System.out.println(paymentFactoryForSara.createDocument(sara));
        
        DocumentFactory contractFactoryForAli = new ContractFactory("Software Developer", "2025-01-15");
        DocumentFactory contractFactoryForSara = new ContractFactory("Database Administrator", "2025-01-25");
        
        System.out.println(contractFactoryForAli.createDocument(ali));
        System.out.println(contractFactoryForSara.createDocument(sara));
    }
}