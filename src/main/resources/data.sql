-- Create users table
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Create category table
CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Create expense table
CREATE TABLE expense (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    date DATE NOT NULL,
    user_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

-- Insert data into users table
INSERT INTO users (id, name, age, email) VALUES
(1, 'John Doe', 30, 'john.doe@example.com'),
(2, 'Jane Smith', 25, 'jane.smith@example.com');

-- Insert data into category table
INSERT INTO category (id, name) VALUES
(1, 'Food'),
(2, 'Utilities'),
(3, 'Entertainment'),
(4, 'Health');

-- Insert data into expense table
INSERT INTO expense (id, description, amount, date, user_id, category_id) VALUES
(1, 'Grocery shopping', 50.00, '2023-01-15', 1, 1),
(2, 'Gym membership', 30.00, '2023-02-10', 1, 4),
(3, 'Electricity bill', 100.00, '2023-03-05', 2, 2),
(4, 'Internet subscription', 40.00, '2023-04-01', 2, 2),
(5, 'Movie tickets', 20.00, '2023-05-20', 1, 3);
