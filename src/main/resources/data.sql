-- Insert initial users
INSERT INTO app_user (name, email) VALUES ('John Doe', 'john@example.com');
INSERT INTO app_user (name, email) VALUES ('Jane Smith', 'jane@example.com');

-- Insert initial categories
INSERT INTO category (name) VALUES ('Food');
INSERT INTO category (name) VALUES ('Transport');
INSERT INTO category (name) VALUES ('Utilities');

-- Insert initial expenses
INSERT INTO expense (description, amount, date, user_id, category_id) VALUES ('Lunch', 15.00, '2023-06-11', 1, 1);
INSERT INTO expense (description, amount, date, user_id, category_id) VALUES ('Bus ticket', 2.50, '2023-06-11', 2, 2);
INSERT INTO expense (description, amount, date, user_id, category_id) VALUES ('Electricity bill', 45.00, '2023-06-11', 1, 3);