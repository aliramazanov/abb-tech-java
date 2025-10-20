package animals;

public class Practice {
    
    static void main () {
        Dog dog = new Dog("Dog", 5, "Owner", 5, "Retriever");
        System.out.println(dog.type); // because it is protected, accessible
        // System.out.println(dog.owner); -> 'owner' has private access in 'animals.Dog'
    }
}
