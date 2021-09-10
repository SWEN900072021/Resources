# Security: Simple Spring Security Example - SWEN90007 

This project demonstrates the use of Spring Security in a JEE (non-spring based) Web Application.

## User Details and Password Encoding

This project uses a custom user detail service to load user details for auth* purposes. The users are created in memory, see UserDetailsServiceImpl for details.

Passwords are encoded using PBKDF2.

## Useful Resources

Spring security architecture:
https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-applications
https://spring.io/guides/topicals/spring-security-architecture/

Security expressions:
https://www.baeldung.com/spring-security-expressions

Ant-based path expressions:
https://docs.spring.io/spring-framework/docs/4.3.2.RELEASE_to_4.3.3.RELEASE/Spring%20Framework%204.3.3.RELEASE/org/springframework/util/AntPathMatcher.html

