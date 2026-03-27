# CGPA Calculator (Java Swing)

## Description

This project is a desktop-based CGPA Calculator developed using Java Swing. The main objective is to provide a simple and interactive way for users to calculate their CGPA based on multiple subjects, grades, and credit values using a weighted average approach.

---

## Technologies Used

* Java (Core programming language)
* Java Swing (JFrame, JLabel, JTextField, JButton, JTextArea, JScrollPane)
* Event-driven programming using ActionListener

---

## Features

* Simple and user-friendly graphical user interface
* Input validation for grade (0–4) and credit
* Addition of multiple subjects
* Scrollable display area for subject entries
* CGPA calculation with precision up to 4 decimal places
* Remove option to clear all inputs and results

---

## How to Set Up and Run

1. Make sure Java (JDK 8 or higher) is installed on your system.
2. Compile the program using:

```
javac CGPACalculator.java
```

3. Run the program using:

```
java CGPACalculator
```

---

## How It Works

The user enters subject details (name, grade, and credit) and clicks **Add Subject**. The application validates the input and stores it in a formatted way in the display area.

When **Calculate CGPA** is clicked, the program:

* Reads all stored subject entries
* Splits them into individual lines and slices grade and credits strings
* Extracts grade and credit values using string parsing
* Computes CGPA using the formula:

`CGPA = Σ(grade × credits) / Σ(credits)`

The result is then displayed in the CGPA field.

---

## Challenges Faced

* Handling user input errors such as invalid numbers
* Managing string parsing reliably based on fixed formatting, and slicing specific portions form the text area
* Ensuring proper GUI behavior using event-driven programming

---

## Limitations

* Relies on strict string formatting for parsing
* Uses null layout, manually setting coordinates
* No persistent storage (data is lost after closing the application)

---

## Possible Improvements

* Replacing string-based storage with object-oriented structures like Arraylist.
* Using layout managers for better UI responsiveness as they adjust the components according to the screen resolution.
* Adding a import option to import data from CSV fils or adding multiple user profile option to store sessions.

---

## Author

Developed as a Java Swing project to demonstrate GUI design, input validation, event handling, and CGPA calculation logic.
