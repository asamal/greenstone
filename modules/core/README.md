![Java CI with Maven (core)](https://github.com/asamal/greenstone/workflows/Java%20CI%20with%20Maven%20(core)/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=greenstone&metric=alert_status)](https://sonarcloud.io/dashboard?id=greenstone)

# GreenStone

## Build docker container 

Run from root directory:  
Build jars:  
`./build-modules.sh`  
Start docker-compose:   
`docker-compose -f docker/dc-local.yml up -d --force-recreate`  

## Naming convention 

List of names:  
`greenstone` - internal name used in the code  
`GreenStone` - user friendly name  
`green-stone` - deprecated, used only when it is imossible to change  
