-- Додавання працівників
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('John Doe', '1985-01-01', 'Senior', 5500),
('Jane Smith', '1990-02-02', 'Middle', 4000),
('Emily Johnson', '1995-03-03', 'Junior', 3000),
('Michael Brown', '2000-04-04', 'Trainee', 800),
('Sarah Davis', '1986-05-05', 'Senior', 6000),
('William Miller', '1991-06-06', 'Middle', 3500),
('Taisa Dubina', '1996-07-07', 'Junior', 2000),
('Volodymr Dubina', '2001-08-08', 'Trainee', 900),
('Margaryta Vlasenko', '1987-09-09', 'Senior', 5200),
('Alina Panasenko', '1992-10-10', 'Middle', 4500);

-- Додавання клієнтів
INSERT INTO client (NAME) VALUES
('Alpha Corp'),
('Beta LLC'),
('Gamma Inc'),
('Delta Ltd'),
('Epsilon GmbH');

-- Додавання проєктів
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(1, '2023-01-01', '2024-02-01'),
(2, '2023-03-01', '2023-04-01'),
(3, '2023-05-01', '2023-12-01'),
(4, '2023-06-01', '2023-09-01'),
(1, '2023-07-01', '2023-10-01'),
(2, '2023-08-01', '2023-11-01'),
(3, '2023-09-01', '2024-03-01'),
(4, '2023-10-01', '2024-01-01'),
(1, '2023-11-01', '2024-07-01'),
(2, '2023-12-01', '2024-02-01');

-- Назначення працівників на проєкти
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(3, 5),
(3, 6),
(4, 7),
(4, 8),
(5, 9),
(5, 10),
(6, 1),
(6, 3),
(7, 2),
(7, 4),
(8, 5),
(8, 7),
(9, 6),
(9, 8),
(10, 9),
(10, 10);

