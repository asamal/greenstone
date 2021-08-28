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

### Remote (pull docker images from the repository)

Run from root directory:  
Pull images:  
`./build-modules-remote.sh`  
Start docker-compose:   
`./start-modules-remote.sh`

#### Links

| Service | Link
|:---|:---
|Login page|http://localhost:44401
|Customers' page (via gateway)|http://localhost:44401/customers
|Customers' page (directly)|http://localhost:44402/customers
|Jaeger|http://localhost:16686
|Grafana|http://localhost:3000
|Prometheus|http://localhost:9090

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

## Setup Argo CD

Original guide https://argoproj.github.io/argo-cd/getting_started/

### Install Argo CD:
`kubectl create namespace argocd`  

`kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml`

### Download Argo CD CLI
`brew install argocd`

### Access The Argo CD API Server
#### Change the argocd-server service type to LoadBalancer:
`kubectl patch svc argocd-server -n argocd -p '{"spec": {"type": "LoadBalancer"}}'`

#### Port Forwarding
`kubectl port-forward svc/argocd-server -n argocd 8080:443`

### Login Using The CLI
The initial password for the admin account is auto-generated and stored as clear text in the field password in a secret 
named argocd-initial-admin-secret in your Argo CD installation namespace. 
You can simply retrieve this password using kubectl  
`kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -D`

`argocd login <inital-password>`

`argocd account update-password`

### Register A Cluster To Deploy Apps To (Optional)

`argocd cluster add docker-desktop`

### Create An Application From A Git Repository

`kubectl create namespace greenstone`

Note  
You can access Argo CD using port forwarding: add --port-forward-namespace argocd flag to every CLI command or set 
ARGOCD_OPTS environment variable: `export ARGOCD_OPTS='--port-forward-namespace argocd'`:

`argocd app create greenstone --repo https://github.com/asamal/greenstone.git --path k8s --dest-server https://kubernetes.default.svc --dest-namespace greenstone`