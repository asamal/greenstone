kubectl port-forward svc/gs-gateway -n greenstone 8080:44401 &
kubectl port-forward svc/argocd-server -n argocd 3001:443 &
kubectl port-forward svc/jaeger -n greenstone 3002:16686 &
kubectl port-forward svc/prometheus-service -n greenstone 3003:8080 &
kubectl port-forward svc/grafana -n greenstone 3004:3000 &
kubectl port-forward svc/gs-tree -n greenstone 3005:44402 &
kubectl port-forward svc/gs-user -n greenstone 3006:44403 &
kubectl port-forward svc/gs-user-q -n greenstone 3007:44404