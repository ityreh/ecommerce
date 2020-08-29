# E-Commerce Platform

This project implements an E-Commerce Platfrom based on Quarkus.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```
mvn quarkus:dev
```

## Packaging and running the application

The application can be packaged using 

```
mvn package
```

It produces the `ecommerce-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/ecommerce-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 

```
mvn package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 

```
mvn package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/ecommerce-1.0.0-SNAPSHOT-runner`

## Add Quarkus extensions

You can add Quarkus extensions with

```
mvn quarkus:add-extension -Dextensions="hibernate-validator"
```