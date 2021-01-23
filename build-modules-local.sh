mvn -f modules/core/pom.xml clean package
./modules/gateway/gradlew -p modules/gateway clean build
docker-compose -f docker/dc-local.yml build --no-cache