#!/bin/sh

## База для медиатора
docker run -d --name mediator-db -p 5432:5432 -e POSTGRES_PASSWORD=123123 -e POSTGRES_USER=superadmin -e POSTGRES_DB=mediator postgres:alpine
sleep 2

## База для service-card
docker run -d --name mediator-service-card-db -p 5433:5432 -e POSTGRES_PASSWORD=123123 -e POSTGRES_USER=superadmin -e POSTGRES_DB=card postgres:alpine
sleep 2

## База для service-credit
docker run -d --name mediator-service-credit-db -p 5434:5432 -e POSTGRES_PASSWORD=123123 -e POSTGRES_USER=superadmin -e POSTGRES_DB=credit postgres:alpine
sleep 2

## База для service-deposit
docker run -d --name mediator-service-deposit-db -p 5435:5432 -e POSTGRES_PASSWORD=123123 -e POSTGRES_USER=superadmin -e POSTGRES_DB=deposit postgres:alpine
sleep 2
read -n 1 -s -r -p "Press any key to continue"