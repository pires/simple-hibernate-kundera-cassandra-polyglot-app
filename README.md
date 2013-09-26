simple-hibernate-kundera-cassandra-polyglot-app
===============================================

Simple polyglot proof-of-concept with Hibernate (PostgreSQL) and Kundera (Cassandra) support.

## Prerequisites ##
- JDK 7
- Maven 3.1.0 or newer
- Java EE 7 container (I recommend Glassfish 4, more especifically 4.0.1-b04, nightly as of Sep 25, 2013).

*Note* that this app won't work with a prior version of Java EE container.

## Test ##
```
mvn clean package
```
Deploy the resulting WAR file available at ```target/``` folder.
