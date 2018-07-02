#!/bin/sh
echo enter file name
read file_name
echo docker Image loaction along with tag
read image_add
echo Enter conatiner name
read container_name
echo Enter Service Name
read servicename
echo Enter Deployment Name
read deploy_name
echo Enter Deployment Version
read deploy_ver
echo Enter No of Deployment replicas
read deploy_replicas
echo Enter Service API version
read ser_api_ver
echo Container port No of dockerised image
read portno
cat >> $file_name.yaml << EOF
apiVersion: $ser_api_ver
kind: Service
metadata:
  name: $servicename
  labels:
    app: $servicename
spec:
  ports:
  - port: $portno
    name: http
  selector:
    app: $servicename
---
apiVersion: extensions/v1beta1
kind: Deployment
metadata:
  name: $deploy_name
spec:
  replicas: $deploy_replicas
  template:
    metadata:
      labels:
        app: $servicename
        version: $deploy_ver
    spec:
      containers:
      - name: $container_name
        image: $image_add
        imagePullPolicy: IfNotPresent
        ports:
        - containerPort: $portno
EOF
echo ###########################################################################################3
echo applying the deployment
kubectl apply -f <(istioctl kube-inject -f $file_name.yaml)
