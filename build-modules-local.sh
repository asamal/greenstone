mvn -f modules/gs-tree/pom.xml clean package
./modules/gs-gateway/gradlew -p modules/gs-gateway clean build
./modules/gs-user/gradlew -p modules/gs-user clean build
docker-compose -f docker/dc-local.yml build --no-cache