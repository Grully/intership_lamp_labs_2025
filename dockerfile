FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

COPY src ./src

RUN ./gradlew bootJar -x test

CMD ["java", "-jar", "build/libs/notes-api.jar"]