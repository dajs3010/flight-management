Please follow these instructions to test the program in Tomcat Server:

1. Execute ``mvn clean package`` at root directory.

2. Execute ``npm install`` at ``/app`` directory.

3. Execute ``mvn clean package`` at ``/app`` directory.

4. Copy ``flight-management.war`` from ``/target`` directory and paste it in ``webapps`` Tomcat folder.

5. Copy ``flight-management-web.war`` from ``/app/target`` directory and paste it in ``webapps`` Tomcat folder.

6. Start your Tomcat Server:
    - Windows: ``.\startup.bat``
    - Linux: ``.\startup.sh``
    
7. Open in browser ``http://localhost:8080/flight-management-web/``

Notes:

- Tested with default Tomcat 9 configurations.
- PostgreSQL database hosted by https://api.elephantsql.com (version 11.3, no mayor differences with version 9.0 at least as far as the functionality is used in this exercise)
