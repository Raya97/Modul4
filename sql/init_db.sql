-- Створення таблиці для працівників
CREATE TABLE IF NOT EXISTS worker (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    BIRTHDAY DATE,
    LEVEL VARCHAR(255),
    SALARY DECIMAL(10, 2)
);


-- Створення таблиці для клієнтів
CREATE TABLE client (
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) >= 2 AND LENGTH(NAME) <= 1000)
);

-- Створення таблиці для проєктів
CREATE TABLE project (
    ID SERIAL PRIMARY KEY,
    CLIENT_ID INT,
    START_DATE DATE,
    FINISH_DATE DATE,
    FOREIGN KEY (CLIENT_ID) REFERENCES client(ID)
);

-- Створення таблиці для зв'язку працівників і проєктів
CREATE TABLE project_worker (
    PROJECT_ID INT,
    WORKER_ID INT,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES project(ID),
    FOREIGN KEY (WORKER_ID) REFERENCES worker(ID)
);