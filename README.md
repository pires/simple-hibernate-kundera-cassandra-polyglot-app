simple-hibernate-kundera-cassandra-polyglot-app
===============================================

Simple polyglot proof-of-concept with Hibernate (PostgreSQL) and Kundera (Cassandra) support.

## Prerequisites ##
- JDK 7
- Maven 3.1.0 or newer
- Java EE 7 container (I recommend Glassfish 4, more especifically 4.0.1-b04, nightly as of Sep 25, 2013).
- PostgreSQL 9.2 JDBC4 driver available at _÷{GLASSFISH_ROOT}/glassfish/domain/domain1/lib/
- A JDBC Connection Pool configured in Glassfish with JNDI Resource ```jdbc/PolyglotDS```, properly linked to a PostgreSQL database
- Change ```src/main/resource/META-INF/persistence.xml``` and change property ```kundera.nodes``` to match your environment.

*Note* that this app won't work with a prior version of Java EE container.

## Test ##
```
mvn clean package
```
Deploy the resulting WAR file available at ```target/``` folder.
