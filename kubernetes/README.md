# Kubernetes related information

This folder contains information related to Kubernetes.


Kubernetes guide
=================

## Contents
- [Prerequisite](#prerequisite)
- [Installation](#installation)
- [Setup](#setup)
- [Tools](#tools)


## Prerequisite:

## Installation:

- If it is a **KAAS** (Kubernetes as a Service) cluster, get access from your team wherein they add your credentials to the clusterrole (managed by rancher usually)and you can then download the kubeconfig file with certificate, key and CA for authentication and clusterrole(rbac) permission for authorization.

### Tip:

If you have multiple clusters instead of having separate kubeconfig file, manage it in single file like below

```
apiVersion: v1
clusters:
- cluster:
    certificate-authority-data: DATA+OMITTED
    server: https://<cluster-1>:6443
  name: <cluster-1>
- cluster:
    certificate-authority-data: DATA+OMITTED
    server: https://<cluster-2>:6443
  name: <cluster-1>
contexts:
- context:
    cluster: <cluster-1>
    namespace: default
    user: <user-1>
  name: <user-1>@<cluster-1>
- context:
    cluster: <cluster-2>
    namespace: default
    user: <user-1>
  name: <user-1>@<cluster-2>
current-context: <user-1>@<cluster-1>
kind: Config
preferences:
  colors: true
users:
- name: <user-1>
  user:
    client-certificate-data: REDACTED
    client-key-data: REDACTED
```

## Setup:

## Tools:

- Below are the list of useful kubectl plugins from krew

```
cert-manager                    Manage cert-manager resources inside your cluster
cost                            View cluster cost information
df-pv                           Show disk usage (like unix df) for pvc   ---> very useful 
graph                           Visualize Kubernetes resources and relationships. ---> very useful
oomd                            Show recently OOMKilled pods           ---> very useful 
pod-dive                        Shows a pod's workload tree and info inside a node       
pod-lens                        Show pod-related resources         ---> very useful             
rbac-lookup                     Reverse lookup for RBAC                             
rbac-tool                       Plugin to analyze RBAC permissions and generate
ttsum                           Visualize taints and tolerations       
view-cert                       View certificate information stored in secrets      
view-secret                     Decode Kubernetes secrets
```

- Most useful tools for kubernetes development are k9s, kubectx and kubens

**Note**: https://www.cloudzero.com/blog/kubernetes-tools
