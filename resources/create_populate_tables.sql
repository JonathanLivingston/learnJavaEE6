-- Создание базы данных и подключение к ней.
connect 'jdbc:derby://localhost:1527/customerdb;create=true';

-- Добавление пользователя в базу данных: username dev, password dev
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user.jonny','jonny');

-- Предоставить все привилегии для пользователя dev
CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.database.fullAccessUsers','jonny');

-- Отсоединени от новой созданной базы данных
disconnect;

-- Переподключение к новой созданной базе данных с пользователем dev
connect 'jdbc:derby://localhost:1527/customerdb;user=jonny;password=jonny';

-- Создание таблиц
CREATE TABLE CUSTOMERS (ID INT PRIMARY KEY, FIRST_NAME VARCHAR(20), LAST_NAME VARCHAR(20), EMAIL VARCHAR(30));
CREATE TABLE TELEPHONE_TYPES(ID INT PRIMARY KEY, CODE CHAR(1), NAME VARCHAR(20));
CREATE TABLE TELEPHONES (ID INT PRIMARY KEY, TYPE_ID INT REFERENCES TELEPHONE_TYPES, CUSTOMER_ID INT REFERENCES CUSTOMERS, TELEPHONE_NUMBER CHAR(12));
CREATE TABLE ADDRESS_TYPES (ID INT PRIMARY KEY, CODE CHAR(1), NAME VARCHAR(20));
CREATE TABLE COUNTRIES(ID INT PRIMARY KEY, CODE CHAR(3) NOT NULL, NAME VARCHAR(60) NOT NULL);
CREATE TABLE ADDRESSES (ID INT PRIMARY KEY, TYPE_ID INT REFERENCES ADDRESS_TYPES, CUSTOMER_ID INT REFERENCES CUSTOMERS,
STREET VARCHAR(100), HOUSE_NUM INT, CITY VARCHAR (100), COUNTRY_ID INT REFERENCES COUNTRIES, POSTAL_CODE CHAR(6));
CREATE TABLE LOGIN_INFO (ID INT PRIMARY KEY, CUSTOMER_ID INT REFERENCES CUSTOMERS, LOGIN_NAME VARCHAR(15), PASSWORD VARCHAR (25));
CREATE TABLE ORDERS(ID INT PRIMARY KEY, CUSTOMER_ID INT REFERENCES CUSTOMERS, ORDER_NUMBER VARCHAR (15), ORDER_DESCRIPTION VARCHAR(200));
CREATE TABLE ITEMS(ID INT PRIMARY KEY, ITEM_NUMBER VARCHAR(15), ITEM_SHORT_DESC VARCHAR(100), ITEM_LONG_DESC VARCHAR(500));
CREATE TABLE ORDER_ITEMS(ID INT REFERENCES ORDERS, ITEM_ID INT REFERENCES ITEMS, ITEM_QTY INTEGER);

-- Заполнение таблиц
INSERT INTO TELEPHONE_TYPES (ID, CODE, NAME) VALUES (1, 'H', 'Home');
INSERT INTO TELEPHONE_TYPES (ID, CODE, NAME) VALUES (2, 'W', 'Work');
INSERT INTO TELEPHONE_TYPES (ID, CODE, NAME) VALUES (3, 'C', 'Cell');

INSERT INTO ADDRESS_TYPES(ID, CODE, NAME) VALUES (1, 'H', 'Home');
INSERT INTO ADDRESS_TYPES(ID, CODE, NAME) VALUES (2, 'M', 'Mailing');
INSERT INTO ADDRESS_TYPES(ID, CODE, NAME) VALUES (3, 'S', 'Shipping');

INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (1,'ABH','Abkhazia');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (2,'AUS','Australia');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (3,'AUT','Austria');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (4,'ALB','Albania');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (5,'AND','Andorra');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (6,'BEL','Belgium');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (7,'BRA','Brazil');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (8,'DEU','Germany');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (9,'ITA','Italy');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (10,'CAN','Canada');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (11,'CUB','Cuba');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (12,'NLD','Netherlands');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (13,'NZL','New Zealand');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (14,'PRT','Portugal');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (15,'RUS','Russian Federation');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (16,'GBR','United Kingdom');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (17,'HRV','Croatia');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (18,'MNE','Montenegro');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (19,'CZE','Czech Republic');
INSERT INTO COUNTRIES (ID,CODE,NAME) VALUES (20,'CHL','Chile');