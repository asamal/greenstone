![CI (core)](https://github.com/asamal/greenstone/workflows/Java%20CI%20with%20Maven%20(core)/badge.svg)
[![Sonar QG (core)](https://sonarcloud.io/api/project_badges/measure?project=greenstone&metric=alert_status)](https://sonarcloud.io/dashboard?id=greenstone)  
![CI (gateway)](https://github.com/asamal/greenstone/workflows/Java%20CI%20with%20Maven%20(gateway)/badge.svg)

# GreenStone

## Build docker container 

Run from root directory:  
`docker build -t greenstone:v1 . -f docker/Dockerfile`

## Naming convention 

List of names:  
`greenstone` - internal name used in the code  
`GreenStone` - user friendly name  
`green-stone` - deprecated, used only when it is imossible to change  
