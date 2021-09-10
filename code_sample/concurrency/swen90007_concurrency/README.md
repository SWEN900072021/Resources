# Concurrency Examples - SWEN90007 

This project has 6 different concurrency examples:

- No ACID transfer, multiple system transactions
- ACID transfer, single system transaction
- Optimistic wrong: optimistic offline lock (multiple system transactions) with updates in different sys. transactions
- Optimistic: optimistic offline lock (multiple system transactions) with updates in same sys. transaction
- Pessimistic exception: pessimistic offline lock (multiple system transactions), exception is thrown if row is locked
- Pessimistic wait: pessimistic offline lock (multiple system transactions), thread waits until it can access lock so that transaction can proceed

You can switch between examples by changing the TransferType in test.ConcurrentTransfers.java

## Database 

Before you run an example make sure you set your Postgres URL and credentials in utils.DBUtils.java and that you have the account and account_optimistic
tables created in your DB:

CREATE TABLE account
(
    account_name character varying NOT NULL,
    balance integer NOT NULL,
    CONSTRAINT account_pkey PRIMARY KEY (account_name)
);

INSERT INTO account VALUES ('Alice', 100);

INSERT INTO account VALUES ('Bob', 0);

CREATE TABLE account_optimistic
(
    account_name character varying NOT NULL,
    version integer NOT NULL DEFAULT 0,
    balance integer NOT NULL,
    CONSTRAINT account_optimistic_pkey PRIMARY KEY (account_name)
);

INSERT INTO account_optimistic VALUES ('Alice', 0, 100);

INSERT INTO account_optimistic VALUES ('Bob', 0, 0);

## Useful Resources

https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html#transactions_data_integrity

https://www.postgresql.org/docs/9.4/explicit-locking.html

https://www.postgresql.org/docs/9.5/transaction-iso.html

https://docs.jboss.org/hibernate/core/3.3/reference/en/html/transactions.html
