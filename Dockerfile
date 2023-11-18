#
# Build stage
#
FROM maven:3.8.1-openjdk-17-slim AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/Telegram_GPT_Bot-0.0.1-SNAPSHOT.jar Telegram_GPT_Bot.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","Telegram_GPT_Bot.jar"]