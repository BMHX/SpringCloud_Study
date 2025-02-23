# Spring Cloud 实战学习仓库

## 📚 当前能力图谱
```
[已掌握]
├── 服务注册发现(Nacos)
├── RESTful API设计
├── 多环境配置(dev/test)
├── 基础服务通信(OpenFeign)
└── Maven多模块管理

[进行中]
└── 配置中心(Nacos Config)

[待解锁]
├── 服务熔断(Sentinel)
├── 网关路由(Gateway)
└── 链路追踪(Sleuth)
```

## 🛠️ 项目结构
```bash
springcloud-lab/
├── nacos-server/     # Nacos服务端配置
├── service-common/   # 公共依赖模块
├── product-service/  # 商品服务（已完成）
├── order-service/    # 订单服务（已完成）
└── user-service/     # 用户服务（已完成）
```

## 🚀 快速启动
```bash
# 1. 启动Nacos服务
cd nacos-server && sh startup.sh -m standalone

# 2. 编译公共模块
cd service-common && mvn clean install

# 3. 启动商品服务（端口8081）
cd product-service && mvn spring-boot:run -Dspring.profiles.active=dev
```
