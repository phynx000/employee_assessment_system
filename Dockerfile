FROM eclipse-temurin:17-jdk-jammy as build

WORKDIR /app

# Sao chép file pom.xml và tải dependencies
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

# Sao chép source code và build ứng dụng
COPY src src
RUN ./mvnw package -DskipTests

# Sử dụng JRE cho image chạy
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Sao chép JAR từ giai đoạn build
COPY --from=build /app/target/*.jar app.jar

# Biến môi trường
ENV SPRING_PROFILES_ACTIVE=prod
ENV JAVA_OPTS=""

# Port mà ứng dụng sẽ chạy
EXPOSE 8080

# Chạy ứng dụng
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]