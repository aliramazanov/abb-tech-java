import animals.Dog;

public class ObjectsPractice {
    
    static void main () {
        animals.Cat cat = new animals.Cat();
        System.out.println(cat);
        cat.name = "Kitten";
        cat.age = 2;
        
        animals.Cat anotherCat = new animals.Cat();
        anotherCat.name = "animals.Cat";
        anotherCat.age = 3;
        System.out.println(anotherCat.name);

        // anotherCat = null;
        
        Dog dog = new Dog("Doggy", 3, "Owner", 2, "Retriever");
        System.out.println(dog);
        System.out.println(dog.name);
        
        Dog anotherDog = new Dog("Alabash");
        System.out.println(anotherDog.age);
        
        Dog newDog = new Dog(4);
        System.out.println(newDog.name);
        
        dog.run(50L, (short) 8);
        
        Dog.eat(10);
        
        System.out.println(Dog.food);
    }
}
