# todo-api

- http://localhost:8080/graphiql?path=/grpahql

## DB:
-  docker exec -it askCartDB psql -U postgres
- CREATE DATABASE tododb;

- `docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' <container-name>`.