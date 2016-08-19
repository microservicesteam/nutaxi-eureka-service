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

## Docker integration
TO BE DONE

*Dockerization should be implemented with conjunction of the config server, as it seems currently both services would need EIPs to function normally in AWS.*

## Notes on AWS
EIP self association will work only if the service is running on instances with the following IAM role:
```
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "Stmt1471561180000",
            "Effect": "Allow",
            "Action": [
                "ec2:AssociateAddress",
                "ec2:DescribeNetworkInterfaces",
                "ec2:DisassociateAddress",
                "ec2:DescribeAddresses",
                "ec2:DescribeInstances"
            ],
            "Resource": [
                "*"
            ]
        }
    ]
}
```
