# Security: Simple Shiro Example - SWEN90007 

This project demonstrates the use of Apache Shiro for authentication and authorization purposes.

## Realm and Password Hashing

This example uses a JDBC Realm backed by a PostgreSQL data source. Database connection details can be configured in shiro.ini.

The database table can be created using:

CREATE TABLE users
(
    user_name character varying NOT NULL,
    user_password character NOT NULL,
    user_role character NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_name)
)

Passwords in the table are expected to be hashed using Shiro's password hasher. 

Details on how to use Shiro's command line tool to hash passwords: https://shiro.apache.org/command-line-hasher.html#command-line-hasher

Refer to the documentation for Shiro's PasswordMatcher and PasswordService classes to understand how to hash passwords programmatically. 

## Useful Resources

Realms: https://shiro.apache.org/realm.html

Web INI configuration ([urls] in shiro.ini): https://shiro.apache.org/web.html#web-ini-configuration



