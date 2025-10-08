# ABB Tech Java Program

This repository contains all my coursework organized by modules, \
with homework and classroom projects separated.

## Structure

abb-tech-java/\
├── module1/\
│   ├── classwork/\
│   │   ├── lesson1/\
│   │   └── lesson2/\
│   └── homework/\
│       ├── lesson1/\
│       └── lesson2/\
├── module2/\
│   ├── classwork/\
│   └── homework/

## Cloning Options

### Clone Everything

```bash
git clone https://github.com/YOUR_USERNAME/abb-tech-java.git
```

### Clone Specific Lesson (Sparse Checkout)

```bash
git clone --no-checkout https://github.com/YOUR_USERNAME/abb-tech-java.git

cd abb-tech-java

git sparse-checkout init --cone
git sparse-checkout set module1/homework/lesson1

git checkout main
```

### Clone All Homework (No Classwork):

```bash
git clone --no-checkout https://github.com/YOUR_USERNAME/abb-tech-java.git

cd abb-tech-java

git sparse-checkout init --cone
git sparse-checkout set module1/homework module2/homework

git checkout main
```

## Modules

Module 1: [Basic Java] \
Module 2: [Java Web] \
Module 3: [Java Frameworks] \
Module 4: [Microservice Foundation] 