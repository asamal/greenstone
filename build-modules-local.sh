mvn -f modules/core/pom.xml package
./modules/gateway/gradlew -p modules/gateway build
docker-compose -f docker/dc-local.yml build --no-cache