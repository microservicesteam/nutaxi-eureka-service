# nutaxi-eureka-service

[![Build Status](https://travis-ci.org/microservicesteam/nutaxi-eureka-service.svg?branch=master)](https://travis-ci.org/microservicesteam/nutaxi-eureka-service) [![codecov](https://codecov.io/gh/microservicesteam/nutaxi-eureka-service/branch/master/graph/badge.svg)](https://codecov.io/gh/microservicesteam/nutaxi-eureka-service)

Spring boot Eureka server implementation.

## Build locally
```
mvn clean install
```
This will execute all the checks and tests.

## Run locally
```
mvn clean spring-boot:run
```

## Create local docker image
```
mvn clean install docker:build
```
The new docker image will be pushed to the local image repository named  `microservicesteam/nutaxi-route-service` labelled with `${project.version}` and `latest` tags.

Note that the docker plugin is not bound to any lifecycle events, therefore it should be executed alongside with `package` or `install` goals.

The created image will execute the application with `default` profile. In case you would like to use another profile, use `-Ddocker-spring-profile=<profile>` parameter as below:

```
mvn clean install docker:build -Ddocker-spring-profile=docker-aws
```

## Publish docker image to remote repository
```
mvn clean install docker:build -DpushImageTag
```
Note that you have to logged in to push images to the remote repository using
```
docker login
```