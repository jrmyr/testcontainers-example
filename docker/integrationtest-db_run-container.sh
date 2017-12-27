#!/bin/bash

# To be executed from the inside the docker folder (due to volume path)!
docker run --name tc-manual-test \
    --volume $PWD/integrationtest-db-init:/docker-entrypoint-initdb.d \
    --publish 54323:5432 \
    --env POSTGRES_USER=testuser --env POSTGRES_PASSWORD=password --env POSTGRES_DB=testdb \
    --detach \
    postgres:9.6
