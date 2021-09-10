# Security: Container-based Auth* and Secure Pipe Example - SWEN90007 

This project is a simple example on container-based authentication and authorization. It also implements the Secure Pipe pattern. 

## Realm and Credential Handler

This example uses Tomcat's default user store: tomcat-users.xml. 

Passwords in the file are hashed using PBKDF2. This is configured in the META-INF/context.xml file.

To get the hashed value of a password, you can run the following command:

 <path to Tomcat>/bin/digest.sh -a "PBKDF2WithHmacSHA512" -i 100000 -s 16 -k 256 -h "org.apache.catalina.realm.SecretKeyCredentialHandler" "my secret password"


## Useful Resources

Credential handler: https://tomcat.apache.org/tomcat-9.0-doc/config/credentialhandler.html

PBKDF2: https://tools.ietf.org/html/rfc8018#section-5.2

Configuring realms: https://tomcat.apache.org/tomcat-9.0-doc/realm-howto.html

Tomcat TLS configuration: https://tomcat.apache.org/tomcat-9.0-doc/ssl-howto.html
