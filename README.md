![CI (core)](https://github.com/asamal/greenstone/workflows/CI%20(core)/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=greenstone&metric=alert_status)](https://sonarcloud.io/dashboard?id=greenstone)  
![CI (gateway)](https://github.com/asamal/greenstone/workflows/CI%20(gateway)/badge.svg)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gs-gateway&metric=alert_status)](https://sonarcloud.io/dashboard?id=gs-gateway)

# GreenStone

## Start the application

### Local (build docker images locally)

Run from root directory:  
Build jars:  
`./build-modules-local.sh`  
Start docker-compose:   
`./start-modules-local.sh`

#### Links
Login page:
http://localhost:44401  
Customers' page (via gateway):  
http://localhost:44401/customers  
Customers' page (directly):  
http://localhost:44402/customers  
Jaeger:
http://localhost:16686  
Grafana:
http://localhost:3000  
Prometheus:
http://localhost:9090  

### Remote (pull docker images from the repository)

Run from root directory:  
Pull images:  
`./build-modules-remote.sh`  
Start docker-compose:   
`./start-modules-remote.sh`

## Naming convention

List of names:  
`greenstone` - internal name used in the code  
`GreenStone` - user-friendly name  
`green-stone` - deprecated, used only when it is imossible to change  

[]: http://localhost:44401