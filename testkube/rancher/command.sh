helm repo add rancher-latest https://releases.rancher.com/server-charts/latest

helm install rancher rancher-latest/rancher \
   --namespace cattle-system \
   --create-namespace \
   --values=values.yaml

# chay xong apply cai rancher.yaml de tao ingress nha ba
