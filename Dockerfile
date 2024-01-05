# Use the official OpenJDK base image
FROM openjdk:11

# Set the working directory
WORKDIR /usr/app

# Copy the JAR file into the container at /usr/app
COPY target/institutemanagementsystem.jar /usr/app

# Command to run the application
ENTRYPOINT ["java", "-jar", "institutemanagementsystem.jar"]
