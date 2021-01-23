mvn -f modules/gs-tree/pom.xml clean package
./modules/gateway/gradlew -p modules/gateway clean build
./modules/gateway/gradlew -p modules/gs-user clean build
docker-compose -f docker/dc-local.yml build --no-cache