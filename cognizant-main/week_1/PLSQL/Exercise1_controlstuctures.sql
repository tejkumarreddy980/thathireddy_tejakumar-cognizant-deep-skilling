SET SERVEROUTPUT ON;

DECLARE
    student_name VARCHAR2(30) := 'Student';
    marks NUMBER := 78;
BEGIN

    DBMS_OUTPUT.PUT_LINE('Student Name : ' || student_name);
    DBMS_OUTPUT.PUT_LINE('Marks        : ' || marks);

    IF marks >= 90 THEN
        DBMS_OUTPUT.PUT_LINE('Grade A');
    ELSIF marks >= 75 THEN
        DBMS_OUTPUT.PUT_LINE('Grade B');
    ELSIF marks >= 50 THEN
        DBMS_OUTPUT.PUT_LINE('Grade C');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Fail');
    END IF;

    DBMS_OUTPUT.PUT_LINE('--------------------');
    DBMS_OUTPUT.PUT_LINE('Numbers from 1 to 5');

    FOR i IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(i);
    END LOOP;

END;
/
