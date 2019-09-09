# shop
分布式电商

gmall-order-web服务调gmall-user-mannager调不通原因是zookeeper启动失败了

服务介绍：
gmall-parent服务提供了所需要的所有的jar包，是个pom类型的

gmall-bean需要依赖于gmall-parent;
gmall-bean聚合在gmall-parent里

gmall-interface存放的服务的接口，即service层的的接口


gmall-order-web里面的UserController里面引入@Reference注解，用的是
dubbo提供的jar包，这个注解是将这个服务作为了消费端服务

gmall-user-manager服务的UserServiceImpl这个类上加个注解@Service
这个注解引得包是
import com.alibaba.dubbo.config.annotation.Service;
这个注解相当与发布服务，告诉dubbo我这个服务是一个提供端服务

gmall-util-common这个服务是提供了工具类，可以供前后端都来用


gmall-util-service这个服务提供了
后台的工具类，依赖于gmall-util-common这个服务

gmall-util-web这个服务提供了和
前端交互的工具类，依赖于gmall-util-common这个服务

数据库：gmall.sql

数据库设计模型见数据库模型.dmx


