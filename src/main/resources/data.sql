SET
search_path TO NOTIFIER;

-- CUSTOMER
INSERT INTO customer (first_name, last_name, email, mobile)
VALUES ('mina', 'rashidi', 'mina.rashidi.86@gmail.com', '0790469860');

-- BILLING

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (2000, 1, '2017-10-10', 'NEW', '2017-08-19', NULL);

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (4000, 1, '2017-10-10', 'NEW', '2017-08-19', NULL);

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (3000, 1, '2017-10-11', 'NEW', '2017-08-20', NULL);

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (3500, 1, '2017-10-12', 'NEW', '2017-08-20', NULL);

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (1000, 1, '2017-10-13', 'NEW', '2017-08-21', NULL);

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (5000, 1, '2017-10-14', 'NEW', '2017-08-21', NULL);

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (5000, 1, '2017-10-15', 'NEW', '2017-08-21', NULL);

INSERT INTO billing (amount, customer_id, due_date, notification_status, created_date, changed_date)
VALUES (5000, 1, '2017-10-17', 'NEW', '2017-08-21', NULL);
