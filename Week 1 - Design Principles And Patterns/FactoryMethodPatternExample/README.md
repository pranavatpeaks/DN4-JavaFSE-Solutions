# Design Patterns in Java

This repository demonstrates the implementation of two common design patterns in Java:

1. ✅ Singleton Pattern  
2. ✅ Factory Method Pattern  

Each example is structured in its own folder and includes source files and a `Main` class to run the pattern in action.

---

## 📁 Project Structure

```
DesignPatternsJava/
├── SingletonPatternExample/
│   ├── com/
│   │   └── singleton/
│   │       ├── Logger.java
│   │       └── Main.java
├── FactoryMethodPatternExample/
│   ├── Document.java
│   ├── WordDocument.java
│   ├── PdfDocument.java
│   ├── ExcelDocument.java
│   ├── DocumentFactory.java
│   ├── WordDocumentFactory.java
│   ├── PdfDocumentFactory.java
│   ├── ExcelDocumentFactory.java
│   └── Main.java
```

---

## 🧩 Exercise 1: Singleton Pattern

### 📜 Description
The `Logger` class ensures only one instance is created and used across the application using the **Singleton Pattern**.

### 🧪 How to Run

```bash
cd SingletonPatternExample
javac com/singleton/*.java
java com.singleton.Main
```

### 🖥️ Expected Output
```
Logger Initialized
[LOG]: First Message
[LOG]: Second Message
Both logger instances are the same. Singleton successful
```

### 🔁 Optional Terminal Demo

Embed `.cast` file if available (e.g., asciinema):

[![asciicast](https://asciinema.org/a/NOjCq863wXd3DZbACcDH6QUem.svg)](https://asciinema.org/a/NOjCq863wXd3DZbACcDH6QUem)

---

## 🏭 Exercise 2: Factory Method Pattern

### 📜 Description
This exercise uses the **Factory Method Pattern** to create different types of documents (`Word`, `PDF`, `Excel`) without tightly coupling the client code with specific classes.

### 🧪 How to Run

```bash
cd FactoryMethodPatternExample
javac *.java
java Main
```

### 🖥️ Expected Output
```
Opening Word document...
Opening PDF document...
Opening Excel document...
```

### 🔁 Optional Terminal Demo

Embed `.cast` file if available:

```html
<iframe src="https://asciinema.org/a/your_cast_id/embed" width="640" height="320" frameborder="0"></iframe>
```

---

## ✅ Requirements

- Java JDK 8 or above
- Terminal or IDE (IntelliJ / Eclipse / VS Code)
- (Optional) [Asciinema](https://asciinema.org/) for terminal recording

---

## 💡 Concepts Demonstrated

- **Singleton Pattern**: Global point of access, one instance enforced using private constructor and static method.
- **Factory Method Pattern**: Creation logic abstracted in separate factory classes, adhering to OCP (Open/Closed Principle).

---

## 📬 Contact

For questions or improvements, feel free to open an issue or pull request.

---

© 2025 DesignPatternsJava Project. MIT License.
