**Instructions**

Please follow these instructions to run the application in Tomcat Server:

Make sure you have installed ``maven``, ``npm`` and ``node.js``

1. Execute ``mvn clean package`` at root directory.

2. Execute ``npm install`` at ``/app`` directory.

3. Execute ``mvn clean package`` at ``/app`` directory.

4. Copy ``flight-management.war`` from ``/target`` directory and paste it in ``webapps`` Tomcat folder.

5. Copy ``flight-management-web.war`` from ``/app/target`` directory and paste it in ``webapps`` Tomcat folder.

6. Start your Tomcat Server.

7. Open in browser ``http://localhost:8080/flight-management-web/``

Notes:

- PostgreSQL database hosted by https://api.elephantsql.com (version 11.3, no mayor differences with version 9.0 at least as far as the functionality is used in this exercise)
- Tested with:
    - Tomcat 9 with default configurations.
    - Apache Maven version: 3.6.1
    - Java version: 1.8.0_212
    - NPM version: 6.4.1
    - Node version: 10.15.3
    
**Architecture**

- Backend developed with SpringBoot following DDD principles.
- Frontend developed with React.js as a Single Page Application.
- Backend and Frontend developed and compiled separately to maintain their independence.
- Integration via API RESTFUL.
- Database on the cloud using elephantsql