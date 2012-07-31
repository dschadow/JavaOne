INSERT INTO employees VALUES (10001, null, 'Alice', 'Manager', '', '01.01.2008');
INSERT INTO employees VALUES (10002, 10001, 'Bob', 'Administrator', 'IT', '01.06.2005');
INSERT INTO employees VALUES (10003, 10001, 'Paul', 'Assistant', 'HR', '01.06.2012');

INSERT INTO accounting VALUES (1, 10001, 10000);
INSERT INTO accounting VALUES (2, 10002, 5000);
INSERT INTO accounting VALUES (3, 10003, 3700);
