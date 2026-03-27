# CGPA_Calculator-

## Description

This project is a desktop-based CGPA Calculator developed using Java Swing. The main objective is to provide a simple and interactive way for users to calculate their CGPA based on multiple subjects, grades, and credit values using a weighted average approach.

---

## Technologies Used

* Java (Core programming language)
* Java Swing (JFrame, JLabel, JTextField, JButton, JTextArea, JScrollPane)
* Event-driven programming using ActionListener

---

## Features

* Simple and user-friendly graphical interface
* Input validation for grade (0–4) and credit (>0)
* Dynamic addition of multiple subjects
* Scrollable display area for subject entries
* CGPA calculation with precision up to 4 decimal places
* Reset option to clear all inputs and results

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
* Splits them into individual lines
* Extracts grade and credit values using string parsing
* Computes CGPA using the formula:

`CGPA = Σ(grade × credits) / Σ(credits)`

The result is then displayed in the CGPA field.

---

## Challenges Faced

* Handling user input errors such as invalid numbers and empty fields
* Managing string parsing reliably based on fixed formatting
* Ensuring proper GUI behavior using event-driven programming

---

## Limitations

* Relies on strict string formatting for parsing
* Uses null layout, which is not responsive
* No persistent storage (data is lost after closing the application)

---

## Possible Improvements

* Replace string-based storage with object-oriented structures (e.g., ArrayList)
* Use layout managers for better UI responsiveness
* Add file or database support for saving and retrieving data

---

## Author

Developed as a Java Swing project to demonstrate GUI design, input validation, event handling, and CGPA calculation logic.
