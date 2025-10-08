# ABB Tech Java Program

This repository contains all my coursework organized by modules, with homework and classwork projects separated. Each lesson is an independent Java project that can be cloned and opened separately.

## Structure

```
abb-tech-java/
├── module01/
│   ├── classwork/
│   │   ├── lesson01/          # Independent IntelliJ project
│   │   │   ├── src/
│   │   ├── lesson02/
│   │   └── ...
│   └── homework/
│       ├── lesson01/          # Independent IntelliJ project
│       ├── lesson02/
│       └── ...
├── module02/
│   ├── classwork/
│   └── homework/
├── module03/
│   ├── classwork/
│   └── homework/
├── module04/
│   ├── classwork/
│   └── homework/
├── .gitignore
└── README.md
```

## Cloning Options

### Clone Everything

```bash
git clone https://github.com/aliramazanov/abb-tech-java.git
```

### Clone Specific Lesson (Sparse Checkout)

**For a single lesson:**

```bash
git clone --no-checkout https://github.com/aliramazanov/abb-tech-java.git

cd abb-tech-java

git sparse-checkout init --cone
git sparse-checkout set module01/classwork/lesson01

git checkout main
```

**For multiple specific lessons:**

```bash
git clone --no-checkout https://github.com/aliramazanov/abb-tech-java.git

cd abb-tech-java

git sparse-checkout init --cone
git sparse-checkout set module01/classwork/lesson01 module01/homework/lesson01

git checkout main
```

### Clone All Classwork (No Homework)

```bash
git clone --no-checkout https://github.com/aliramazanov/abb-tech-java.git

cd abb-tech-java

git sparse-checkout init --cone
git sparse-checkout set module01/classwork module02/classwork module03/classwork module04/classwork

git checkout main
```

### Clone All Homework (No Classwork)

```bash
git clone --no-checkout https://github.com/aliramazanov/abb-tech-java.git

cd abb-tech-java

git sparse-checkout init --cone
git sparse-checkout set module01/homework module02/homework module03/homework module04/homework

git checkout main
```

### Clone Entire Module (Both Classwork and Homework)

```bash
git clone --no-checkout https://github.com/aliramazanov/abb-tech-java.git

cd abb-tech-java

git sparse-checkout init --cone
git sparse-checkout set module01

git checkout main
```

## Opening a Lesson in IntelliJ IDEA

After cloning a specific lesson:

1. Open IntelliJ IDEA
2. **File** → **Open**
3. Navigate to the lesson folder (e.g., `abb-tech-java/module01/classwork/lesson01/`)
4. Click **Open**
5. The lesson will open as a complete, independent project

## Modules

- **Module 01**: Basic Java
- **Module 02**: Java Web
- **Module 03**: Java Frameworks
- **Module 04**: Microservice Foundation
