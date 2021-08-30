FROM openjdk:8-jdk
EXPOSE 8081:8081
RUN mkdir /app
COPY ./build/install/sunrise/ /app/
WORKDIR /app/bin
CMD ["./sunrise"]