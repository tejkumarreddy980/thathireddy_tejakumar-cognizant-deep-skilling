# Week 1 — PL/SQL Programming

## Java FSE Deep Skilling (Digital Nurture 5.0)

### Cognizant Digital Nurture 5.0 Program

---

# Program Details

| Field         | Details                             |
| ------------- | ----------------------------------- |
| Program       | Digital Nurture 5.0 — Deep Skilling |
| Track         | Java Full Stack Engineer (Java FSE) |
| Module        | Module 1 — PL/SQL Programming       |
| Week          | Week 1                              |
| Platform Used | Oracle Live SQL                     |

---

# Exercises Completed

## Exercise 1: Control Structures

**File:** `Exercise1_ControlStructures.sql`

### What it does

* Demonstrates decision making using IF-ELSIF-ELSE statements
* Assigns grades based on student marks
* Uses FOR LOOP for iterative execution
* Displays output using DBMS_OUTPUT.PUT_LINE

### Concepts Covered

| Concept      | Description                                         |
| ------------ | --------------------------------------------------- |
| IF Statement | Executes a block when a condition is true           |
| ELSIF        | Checks multiple conditions sequentially             |
| ELSE         | Executes when no condition matches                  |
| FOR LOOP     | Repeats statements for a fixed number of iterations |
| DBMS_OUTPUT  | Displays output from PL/SQL programs                |

### Execution Output

```text
Student Name : Student
Marks : 78
Grade B

--------------------

Numbers from 1 to 5

1
2
3
4
5
```

**Status:** ✅ Implemented Successfully

---

## Exercise 3: Stored Procedures

**File:** `Exercise3_StoredProcedures.sql`

### What it does

* Creates a reusable PL/SQL stored procedure
* Displays employee information
* Demonstrates procedure structure and execution logic
* Uses DBMS_OUTPUT for displaying results

### Concepts Covered

| Concept             | Description                               |
| ------------------- | ----------------------------------------- |
| Stored Procedure    | Named PL/SQL block stored in database     |
| CREATE PROCEDURE    | Used to define a procedure                |
| Procedure Execution | Invoking a procedure when required        |
| Reusability         | Same logic can be executed multiple times |
| DBMS_OUTPUT         | Displays procedure output                 |

### Procedure Logic

```sql
CREATE OR REPLACE PROCEDURE display_employee
AS
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee ID   : 101');
    DBMS_OUTPUT.PUT_LINE('Employee Name : John');
    DBMS_OUTPUT.PUT_LINE('Salary        : 50000');
END;
/
```

### Expected Output

```text
Employee ID   : 101
Employee Name : John
Salary        : 50000
```

**Status:** ✅ Implemented Successfully

**Note:** Procedure creation may require CREATE PROCEDURE privilege depending on the Oracle environment being used.

---

# Repository Structure

```text
Week1_PLSQL/
│
├── Exercise1_ControlStructures.sql
├── Exercise3_StoredProcedures.sql
│
└── README.md
```

---

# Key Learnings from Module 1

* PL/SQL combines SQL statements with procedural programming features.
* IF-ELSIF-ELSE enables decision-making logic.
* FOR LOOP simplifies repetitive operations.
* Stored procedures improve code reusability and maintainability.
* DBMS_OUTPUT.PUT_LINE is used to display execution results.
* Procedures can be executed multiple times without rewriting code.
* Oracle stores procedures within the database for future use.
* PL/SQL blocks improve modular programming and readability.

---

# Tools Used

| Tool            | Purpose                               |
| --------------- | ------------------------------------- |
| Oracle Live SQL | Writing and executing PL/SQL programs |
| GitHub          | Version control and submission        |
| PL/SQL          | Database programming language         |

---

# Learning References

* Oracle PL/SQL Documentation
* Oracle Live SQL
* Oracle Database Concepts Guide
* CTS Deep Skilling Learning Portal
