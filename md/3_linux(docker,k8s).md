### problems list
1. 云原生有了解吗，容器和k8s优缺点
2. ulimit -a 查看栈、cpu、文件等资源的大小限制

### docker

```
docker build -t my-dolphinsheduler-master:v1.0.1 -f src/main/docker/Dockerfile .

docker tag my-dolphinsheduler-master:v1.0.1 695717815/my-dolphinscheduler-master:v1.0.0
docker push 695717815/my-dolphinscheduler-master:v1.0.0
```







K8S

```shell
kubectl get pod --all-namespaces -o wide |grep kms-server
2.2 获得 group
kubectl -n test logs -f config-platform-6684f6bfcb-grft4
2.3 查看pod 实时日志
kubectl -n test logs -f --tail=100 kms-server-7fb5b7c47-n4qcz -c group-lba25pak-docker
2.4 下载日志
kubectl -n test logs  kms-server-7fb5b7c47-n4qcz  -c group-lba25pak-docker >test.log
2.5 登录
kubectl -n test exec -it config-platform-6684f6bfcb-grft4 -c  group-6ymbq95v-docker bash
```
### reference answer
