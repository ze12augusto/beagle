#!/bin/bash

#
# Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

# Send image to ECR
FULL_IMAGE=$(echo "$REGISTRY/$BFF_NAME:$VERSION" | tr [:upper:] [:lower:])
docker tag ""$BFF_NAME"" "$FULL_IMAGE"
docker push "$FULL_IMAGE"

# Deploy image in EKS
aws eks update-kubeconfig --name "$CLUSTER"
kubectl -n "$NAMESPACE" apply -f - << EOF
apiVersion: apps/v1
kind: Deployment
metadata:
  name: "$BFF_NAME"
  labels:
    app: "$BFF_NAME"
    version: "$VERSION"
spec:
  replicas: 1
  selector:
    matchLabels:
      app: "$BFF_NAME"
  template:
    metadata:
      labels:
        app: "$BFF_NAME"
    spec:
      containers:
        - name: "$BFF_NAME"
          image: "$FULL_IMAGE"
          livenessProbe:
            failureThreshold: 3
            httpGet:
              path: /actuator/health
              port: 8080
              scheme: HTTP
            initialDelaySeconds: 30
            periodSeconds: 20
            successThreshold: 1
            timeoutSeconds: 1
          readinessProbe:
            failureThreshold: 3
            httpGet:
              path: /actuator/health
              port: 8080
              scheme: HTTP
            initialDelaySeconds: 30
            periodSeconds: 20
            successThreshold: 1
            timeoutSeconds: 1
          imagePullPolicy: Always

---

apiVersion: v1
kind: Service
metadata:
  labels:
    app: "$BFF_NAME"
    service: "$BFF_NAME"
  name: "$BFF_NAME"
spec:
  ports:
    - name: http
      port: 8080
      targetPort: 8080
  selector:
    app: "$BFF_NAME"
EOF
