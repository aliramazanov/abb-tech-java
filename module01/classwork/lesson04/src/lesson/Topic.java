package lesson;

import animals.Dog;

public class Topic {
    
    static void main () {
        Dog dog = new Dog("Dog", 5, "Owner", 5, "Retriever");
        // System.out.println(dog.owner); -> 'owner' has private access in 'animals.Dog' but constructor is public
        // System.out.println(dog.type);  -> 'type' has protected access in 'animals.Dog' but constructor is public
    }
}
