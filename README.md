#Run command (build first and run to make it run locally)
java -jar target/docker-0.0.1-SNAPSHOT.jar

#use below postman command
POST
http://localhost:8080/api/v1/movie
body:
{
"movieName": "Hero",
"category": "test"
}

For debugging:

For me these steps work:

Select menu Run -> Edit Configurations...
Create new Remote Configuration. By default you don't need to change settings:
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005. But if you want for example to suspend JVM before you connects, you can change suspend=y. Or you can chage port etc.
Copy command line depending your JVM version and save configuration.
In Terminal window run your app with (in Maven usage case and JVM 1.5 and higher) mvn clean spring-boot:run -Dspring-boot.run.jvmArguments="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
Connect to your app by running your Remote Configuration created prviously on step 2. Now you can debug your app.
