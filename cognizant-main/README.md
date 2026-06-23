# Week 1 — Design Patterns and Principles
## Java FSE Deep Skilling (Digital Nurture 5.0)
## Cognizant Digital Nurture 5.0 Program

---

## Program Details

| Field | Details |
|---|---|
| Program | Digital Nurture 5.0 — Deep Skilling |
| Track | Java Full Stack Engineer (Java FSE) |
| Module | Module 1 — Design Patterns and Principles |
| Week | Week 1 |
| Compiler Used | Programiz Online Java Compiler |

---

## Exercises Completed

### Exercise 1: Implementing the Singleton Pattern

**Files:**
- `singleton/DatabaseConnection.java`
- `singleton/SingletonDemo.java`

**Pattern:** Singleton (Creational Design Pattern)

**What the Singleton Pattern does:**
- Ensures a class has only ONE instance throughout the entire application
- Provides a global access point to that single instance
- Uses double-checked locking for thread safety
- Private constructor prevents external instantiation

**Real World Use Case:**
Database connections — creating multiple connections wastes resources.
A single shared connection instance is efficient and consistent.

**Execution Output:**
```
---- Singleton Pattern Demo ----
Creating new DatabaseConnection instance: DB-CONN-1
DB-CONN-1 => Connected to database.
DB-CONN-1 => Executing query: SELECT * FROM students
DB-CONN-1 => Executing query: SELECT * FROM courses

conn1 id: DB-CONN-1
conn2 id: DB-CONN-1
conn1 == conn2 ? true
SUCCESS: Both references point to the same Singleton instance.

=== Code Execution Successful ===
```

**Key Proof:**
- "Creating new DatabaseConnection instance" printed only ONCE
- Both conn1 and conn2 have the same ID: DB-CONN-1
- conn1 == conn2 returns TRUE confirming same object in memory

**Status:** ✅ Executed Successfully

---

### Exercise 2: Implementing the Factory Method Pattern

**Files:**
- `factory/Notification.java`
- `factory/EmailNotification.java`
- `factory/SMSNotification.java`
- `factory/PushNotification.java`
- `factory/NotificationFactory.java`
- `factory/FactoryDemo.java`

**Pattern:** Factory Method (Creational Design Pattern)

**What the Factory Method Pattern does:**
- Defines an interface for creating objects
- Subclasses or factory methods decide which class to instantiate
- Client code never uses "new" directly on concrete classes
- Makes it easy to add new types without changing existing code

**Real World Use Case:**
Notification system — application needs to send Email, SMS, or Push
notifications. The factory decides which notification object to create
based on the type passed in, without the client knowing the details.

**Execution Output:**
```
---- Factory Method Pattern Demo ----
[EMAIL] Sending email notification: Your enrollment in Java FSE Deep Skilling is confirmed.
[SMS] Sending SMS notification: Reminder: SME connect session at 5 PM today.
[PUSH] Sending push notification: New hands-on exercise has been posted.

Class of email object: EmailNotification
Class of sms object:   SMSNotification
Class of push object:  PushNotification

Expected error caught: Unknown notification type: FAX

=== Code Execution Successful ===
```

**Key Proof:**
- Factory correctly created 3 different notification objects
- Each object is of its correct concrete class
- Invalid type "FAX" was handled gracefully with an error message

**Status:** ✅ Executed Successfully

---

## Repository Structure

```
Week1_DesignPatterns/
│
├── singleton/
│   ├── DatabaseConnection.java      # Singleton class with thread-safe getInstance()
│   └── SingletonDemo.java           # Demo/test class proving single instance
│
├── factory/
│   ├── Notification.java            # Product interface
│   ├── EmailNotification.java       # Concrete product - Email
│   ├── SMSNotification.java         # Concrete product - SMS
│   ├── PushNotification.java        # Concrete product - Push
│   ├── NotificationFactory.java     # Factory class with createNotification()
│   └── FactoryDemo.java             # Demo/test class for factory pattern
│
└── README.md                        # This file
```

---

## Concepts Covered

| Concept | Description |
|---|---|
| Singleton Pattern | One instance, global access point, private constructor |
| Factory Method Pattern | Object creation via factory, loose coupling |
| Creational Patterns | Patterns that deal with object creation mechanisms |
| Thread Safety | volatile keyword + double-checked locking in Singleton |
| Interface | Notification interface implemented by concrete classes |
| Polymorphism | Factory returns Notification type, actual object varies |

---

## Learning References

- SOLID Principles: https://www.baeldung.com/solid-principles
- Design Patterns Overview: https://medium.com/@softwaretechsolution/design-pattern-81ef65829de2
- GeeksForGeeks DSA: https://www.geeksforgeeks.org/design-and-analysis-of-algorithms/

---

## Tools Used

| Tool | Purpose |
|---|---|
| Programiz Online Java Compiler | Writing and executing Java code |
| GitHub | Version control and submission |
| Java | Programming language |

