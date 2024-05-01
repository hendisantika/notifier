SET
search_path TO NOTIFIER;

DROP SCHEMA notifier CASCADE;
CREATE SCHEMA notifier;

-- CUSTOMER
CREATE SEQUENCE s_customer START WITH 1 INCREMENT BY 1;
CREATE TABLE customer
(
    id         INTEGER DEFAULT nextval('S_CUSTOMER') PRIMARY KEY,
    first_name text,
    last_name  text,
    email      text,
    mobile     text
);

-- BILLING
CREATE SEQUENCE s_billing START WITH 1 INCREMENT BY 1;
CREATE TABLE billing
(
    id                  INTEGER DEFAULT nextval('S_BILLING') PRIMARY KEY,
    amount              NUMERIC,
    customer_id         INTEGER REFERENCES customer (id),
    due_date            TIMESTAMP,
    notification_status text,
    created_date        TIMESTAMP,
    changed_date        TIMESTAMP
);
