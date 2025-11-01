void main () {
    
    List<Elephant> elephants = new ArrayList<>();
    
    Elephant elephantOne = new Elephant("ElOne", 10, "grey", 4);
    Elephant elephantTwo = new Elephant("ElTwo", 27, "red", 4);
    Elephant elephantThree = new Elephant("ElThree", 17, "blue", 4);
    Elephant elephantFour = new Elephant("ElThree", 17, "blue", 4);
    
    elephants.add(elephantOne);
    elephants.add(elephantTwo);
    elephants.add(elephantThree);
    
    //noinspection ForLoopReplaceableByForEach
    for (int i = 0; i < elephants.size(); i++) {
        IO.println(elephants.get(i).toString());
    }
    
    for (Elephant elephant : elephants) {
        IO.println("elephant.toString() " + elephant.toString());
    }
    
    //        Iterator<Elephant> elIterator = elephants.iterator();
    //        while (elIterator.hasNext()) {
    //            System.out.println(elephants.getFirst());
    //        }
    //
    elephants.remove(elephantTwo);
    
    LinkedList<Elephant> elephantLinkedList = new LinkedList<>();
    
    elephantLinkedList.add(elephantOne);
    elephantLinkedList.add(elephantTwo);
    elephantLinkedList.add(elephantThree);
    
    //noinspection ForLoopReplaceableByForEach
    for (int i = 0; i < elephantLinkedList.size(); i++) {
        IO.println("elephantLinkedList.get(i) " + elephantLinkedList.get(i) );
    }
    
    for (Elephant elephant : elephantLinkedList) {
        IO.println(elephant);
    }
    
    Stack<Elephant> elephantStack = new Stack<>();
    
    elephantStack.push(elephantOne);
    elephantStack.push(elephantTwo);
    elephantStack.push(elephantThree);
    
    int initialSize = elephantStack.size();
    
    for (int i = 0; i < initialSize; i++) {
        System.out.println("elephantStack.pop(): " + elephantStack.pop());
    }
    
    for (Elephant elephant: elephantStack) {
        System.out.println("forEach: " + elephant);
    }
    
    while (!elephantStack.isEmpty()) {
        System.out.println(elephantStack.pop());
    }
    
    PriorityQueue<Elephant> queueElephants = new PriorityQueue<>();
    
    queueElephants.add(elephantOne);
    queueElephants.add(elephantTwo);
    queueElephants.add(elephantThree);
    
    while (queueElephants.isEmpty()){
        System.out.println("queueElephants.poll() " + queueElephants.poll());
    }
    
    HashSet<Elephant>  elephantHashSet = new HashSet<>();
    
    elephantHashSet.add(elephantOne);
    elephantHashSet.add(elephantTwo);
    elephantHashSet.add(elephantThree);
    elephantHashSet.add(elephantFour);
    
    for (Elephant elephant: elephantHashSet){
        System.out.println("elephant HashSet: " + elephant);
        System.out.println(elephant.hashCode());
    }
}
