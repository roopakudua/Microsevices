#!/bin/bash
echo Enter the gateway file name
read filename
echo Enter Virtual service Name
read virtual_ser
echo Enter Mapping points to access the service
read map_pts
echo Enter container port
read container_port
echo Enter service name which you want to expose
read ser_name
cat >> $filename.yaml << EOF
apiVersion: networking.istio.io/v1alpha3
kind: Gateway
metadata:
  name: $filename
spec:
  selector:
    istio: ingressgateway # use istio default controller
  servers:
  - port:
      number: 80
      name: http
      protocol: HTTP
    hosts:
    - "*"
---
apiVersion: networking.istio.io/v1alpha3
kind: VirtualService
metadata:
  name: $virtual_ser
spec:
  hosts:
  - "*"
  gateways:
  - $filename
  http:
  - match:
    - uri:
        exact: $map_pts
    - uri:
        exact: /actuator/health
    route:
    - destination:
        host: $ser_name
        port:
          number: $container_port
EOF
