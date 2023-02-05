FROM openjdk:17 as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:17
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY --from=build /workspace/app/target/filesmanagment-0.0.1-SNAPSHOT.jar /app/filesmanagment-0.0.1-SNAPSHOT.jar
EXPOSE 2023
ENTRYPOINT ["java","-jar","app/filesmanagment-0.0.1-SNAPSHOT.jar"]