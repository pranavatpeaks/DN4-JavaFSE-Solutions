
# 📘 Cognizant Digital Nurture Program 4.0 – Java FSE

## Week 1 – Design Patterns and Principles

---

## 🧩 Exercise 1: Implementing the Singleton Pattern

### 📜 Scenario
You need to ensure that a logging utility class in your application has only **one instance** throughout the application lifecycle to ensure consistent logging.

---

### 🛠 Steps
1. Create a new Java project named `SingletonPatternExample`.
2. Define a Singleton class `Logger`:
   - Private static instance of itself.
   - Private constructor.
   - Public static method to return the instance.
3. Implement the Singleton logic.
4. Create a test class `Main` to verify only one instance is used.

---

### 📁 Project Structure

```
SingletonPatternExample/
└── com/
    └── singleton/
        ├── Logger.java
        └── Main.java
```

---

### 📄 Logger.java

```java
package com.singleton;

public class Logger {
    private static Logger instance;

    private Logger() {
        System.out.println("Logger Initialized");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}
```

---

### 📄 Main.java

```java
package com.singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First Message");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second Message");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same. Singleton successful");
        } else {
            System.out.println("Different instances. Singleton failed.");
        }
    }
}
```

---

### 🖥 Output

```
Logger Initialized
[LOG]: First Message
[LOG]: Second Message
Both logger instances are the same. Singleton successful
```

---

### 🎥 Terminal Demo (.cast)

[![asciicast](https://asciinema.org/a/7kpyKmfQ9cXwC1ILCJHkNTm5N.svg)](https://asciinema.org/a/7kpyKmfQ9cXwC1ILCJHkNTm5N)

---

### ✅ Key Concept

- Ensures a single instance of a class is used throughout the application.
- Constructor is private to prevent external instantiation.
- `getInstance()` method controls access and instantiation.

---

## 🏭 Exercise 2: Implementing the Factory Method Pattern

### 📜 Scenario
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the **Factory Method Pattern** to achieve this.

---

### 🛠 Steps
1. Create a new Java project named `FactoryMethodPatternExample`.
2. Define an interface `Document` with method `open()`.
3. Implement concrete document classes:
   - `WordDocument`
   - `PdfDocument`
   - `ExcelDocument`
4. Create an abstract factory class `DocumentFactory` with method `createDocument()`.
5. Implement specific factory classes for each document type.
6. Test the implementation in the `Main` class.

---

### 📁 Project Structure

```
FactoryMethodPatternExample/
├── Document.java
├── WordDocument.java
├── PdfDocument.java
├── ExcelDocument.java
├── DocumentFactory.java
├── WordDocumentFactory.java
├── PdfDocumentFactory.java
├── ExcelDocumentFactory.java
└── Main.java
```

---

### 📄 Document.java

```java
public interface Document {
    void open();
}
```

---

### 📄 WordDocument.java

```java
public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }
}
```

---

### 📄 PdfDocument.java

```java
public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }
}
```

---

### 📄 ExcelDocument.java

```java
public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document...");
    }
}
```

---

### 📄 DocumentFactory.java

```java
public abstract class DocumentFactory {
    public abstract Document createDocument();
}
```

---

### 📄 WordDocumentFactory.java

```java
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
```

---

### 📄 PdfDocumentFactory.java

```java
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
```

---

### 📄 ExcelDocumentFactory.java

```java
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
```

---

### 📄 Main.java

```java
public class Main {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
```

---

### 🖥 Expected Output

```
Opening Word document...
Opening PDF document...
Opening Excel document...
```

---

### 🎥 Terminal Demo (.cast)

[![asciicast](https://asciinema.org/a/NOjCq863wXd3DZbACcDH6QUem.svg)](https://asciinema.org/a/NOjCq863wXd3DZbACcDH6QUem)

---

### ✅ Key Concept

- Factory Method Pattern encapsulates object creation.
- It promotes flexibility and separation of concerns by delegating the instantiation to subclasses.
