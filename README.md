| | CI | Sonar | Coverage
|:---|---:|---:|---:
| gs-tree | ![CI (gs-tree)](https://github.com/asamal/greenstone/workflows/CI%20(gs-tree)/badge.svg) | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gs-tree&metric=alert_status)](https://sonarcloud.io/dashboard?id=gs-tree) | [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=gs-tree&metric=coverage)](https://sonarcloud.io/dashboard?id=gs-tree)
| gs-user| ![CI (gs-user)](https://github.com/asamal/greenstone/workflows/CI%20(gs-user)/badge.svg) | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gs-user&metric=alert_status)](https://sonarcloud.io/dashboard?id=gs-user) | [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=gs-user&metric=coverage)](https://sonarcloud.io/dashboard?id=gs-user)
| gs-gateway | ![CI (gs-gateway)](https://github.com/asamal/greenstone/workflows/CI%20(gs-gateway)/badge.svg) | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gs-gateway&metric=alert_status)](https://sonarcloud.io/dashboard?id=gs-gateway) | [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=gs-gateway&metric=coverage)](https://sonarcloud.io/dashboard?id=gs-gateway)
| gs-user-q | [![CI (gs-user-q)](https://github.com/asamal/greenstone/actions/workflows/gs-user-q.yml/badge.svg)](https://github.com/asamal/greenstone/actions/workflows/gs-user-q.yml) | [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gs-user-q&metric=alert_status)](https://sonarcloud.io/dashboard?id=gs-user-q) | [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=gs-user-q&metric=coverage)](https://sonarcloud.io/dashboard?id=gs-user-q)

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

## K8S

Regenerate k8s deployment scripts from docker-compose:  
`kompose -f dc-remote.yml`  

Start deployment (in k8s directory):  
`kubectl kustomize . | kubectl apply -f -`  

Test deployed service (gs-user exposed as example):  
http://localhost:30003/

Stop deployment:  
`kubectl kustomize . | kubectl delete -f -`
