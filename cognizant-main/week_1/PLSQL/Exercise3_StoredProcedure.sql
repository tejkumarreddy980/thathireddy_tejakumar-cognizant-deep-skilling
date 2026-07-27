# /*

Exercise 3: Stored Procedures
Module: PL/SQL Programming
Digital Nurture 5.0 - Java FSE
==============================

Objective:
To understand the creation and usage of Stored Procedures in PL/SQL.

Description:
This program creates a stored procedure named
DISPLAY_EMPLOYEE which displays sample employee
details using DBMS_OUTPUT.PUT_LINE.

Concepts Covered:

1. CREATE OR REPLACE PROCEDURE
2. PL/SQL Block Structure
3. DBMS_OUTPUT.PUT_LINE
4. Reusable Database Objects

Expected Output:

Employee ID   : 101
Employee Name : John
Salary        : 50000

Note:
Execution of CREATE PROCEDURE may require
CREATE PROCEDURE privilege depending on the
Oracle environment being used.

====================================================
*/

CREATE OR REPLACE PROCEDURE display_employee
AS
BEGIN
DBMS_OUTPUT.PUT_LINE('Employee ID   : 101');
DBMS_OUTPUT.PUT_LINE('Employee Name : John');
DBMS_OUTPUT.PUT_LINE('Salary        : 50000');
END;
/
