CREATE TABLE STUDENT(
  EMPLID NUMBER(8) PRIMARY KEY,
  LAST_NAME VARCHAR(50) NOT NULL,
  FIRST_NAME VARCHAR(50) NOT NULL,
  DOB DATE NOT NULL,
  CREDITS NUMBER(3) CHECK (CREDITS >= 0 AND CREDITS <=120) NOT NULL,
  GENDER VARCHAR(6) NOT NULL,
  UNPAID_TUITION NUMBER(6,2),
  EMAIL VARCHAR(50) NOT NULL,
  PHONE NUMBER(10) NOT NULL,
  STARTING_SEMESTER VARCHAR(11) NOT NULL,
  EXPECTED_GRADUATION VARCHAR(14) NOT NULL,
  ADDRESS VARCHAR(50) NOT NULL,
  MAJOR VARCHAR(50) NOT NULL
);

CREATE TABLE DEPARTMENT(
  DEPARTMENT VARCHAR(4) PRIMARY KEY ,
  DEPARTMENT_CHAIR VARCHAR(50) NOT NULL,
  BUDGET NUMBER(8) NOT NULL
);

CREATE TABLE COURSE(
    CLASS_NUMBER NUMBER(5) PRIMARY KEY,
    DEPARTMENT_NAME VARCHAR(4) NOT NULL REFERENCES  DEPARTMENT(DEPARTMENT),
    COURSE_NUMBER NUMBER(4) NOT NULL,
    TITLE VARCHAR(50)NOT NULL,
    INSTRUCTOR_NAME VARCHAR(50) NOT NULL,
    TIME_BEGIN varchar2(5) NOT NULL,
    TIME_END varchar2(5) NOT NULL,
    ROOM VARCHAR(10) NOT NULL,
    CREDITS NUMBER(1) CHECK (CREDITS >=1 AND CREDITS <=5) NOT NULL,
    SECTION VARCHAR(4) NOT NULL,
    MODE_OF_INSTRUCTION VARCHAR(20) NOT NULL,
    CLASS_CAPACITY NUMBER(3) CHECK (CLASS_CAPACITY>=25 AND CLASS_CAPACITY<=160) NOT NULL,
    SEMESTER VARCHAR(11) NOT NULL,
    SPECIAL_INFORMATION VARCHAR(200)
);

CREATE TABLE REGISTERED_CLASSES(
    EMPLID NUMBER(8) REFERENCES STUDENT(EMPlID) NOT NULL,
    GRADE VARCHAR(1) NOT NULL,
    CREDITS NUMBER(4) CHECK(CREDITS >=2 AND CREDITS <=5) NOT NULL,
    DEPARTMENT VARCHAR(4) REFERENCES DEPARTMENT(DEPARTMENT) NOT NULL,
    CLASS_NUMBER NUMBER(4) PRIMARY KEY
);

CREATE TABLE INSTRUCTOR(
    TITLE VARCHAR(25) NOT NULL,
    INSTRUCTOR_NAME VARCHAR(50) PRIMARY KEY,
    GENDER VARCHAR(6) NOT NULL,
    DEPARTMENT VARCHAR(4) REFERENCES DEPARTMENT(DEPARTMENT) NOT NULL,
    SALARY NUMBER(7) NOT NULL
);


CREATE TABLE TUITION_PAYMENTS(
    EMPLID NUMBER(8) REFERENCES STUDENT(EMPLID) NOT NULL,
    AMOUNT_PAID NUMBER(6) NOT NULL,
    DATE_PAID DATE NOT NULL
);

CREATE TABLE FINANICAL_AID(
    EMPLID NUMBER(8) REFERENCES STUDENT(EMPLID) PRIMARY KEY,
    GRANT_MONEY NUMBER(6),
    GRANT_NAME VARCHAR(50),
    DATE_APPLIED DATE
);
