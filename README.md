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


gmall-manage-web这个服务是商品后台的控制层
gmall-manage-service这个服务是商品后台管理的业务层代码
商品后台的bean和interface分别在gmall-bean和gmall-interface里面

数据库：gmall.sql

数据库设计模型见数据库模型.dmx

订单服务调用后台服务需要启动
1.gmall-order-web
2.gmall-user-manage

后期见博客：https://my.oschina.net/architectliuyuanyuan



多个sku组成了spu，
spu上有描述商品的通用图片
sku上又有描述商品的特定的图片
SKU与SPU的图片资源
另外同一个SPU下的SKU可以共用一些资源，比如商品图片，海报等等。毕竟
同一种商品，大部分图片都是共用的只有因为颜色尺寸等，很少的差别。那么
一般来说商品图片都是在新增SPU时上传的，在新增SKU时从该SPU已上传的图片
中选择。而海报几乎是所有SPU下的SKU都一样。


点击某一个sku，那么会有不同的销售属性和销售属性值让选

当选中某个三级分类后，会加载对应的平台属性和spu，spu下面是所有的sku的
集合。

三级分类下面有平台属性和一些spu
这时候在添加spu信息(spuInfo)时候就会报三级分类给传过去
spuInfo下面又有又有
商品spu名称 spuName;
商品描述信息：private String description;
三级分类(catalog3Id)，
图片列表:
(private List<SpuImage> spuImageList;)，
销售属性值列表:
(private  List<SpuSaleAttr> spuSaleAttrList;)
销售属性列表下面又有销售属性值列表:
(List<SpuSaleAttrValue> spuSaleAttrValueList;)


基本销售属性？干嘛用的，只有一个id，name




碰到一个很坑的问题，土坯阿年在不了，用的vue，vue生产环境默认走的是
localhost：8888，在前端页面配置上加上http//
<img :src="'http://'+scope.row.imgUrl" :alt="scope.row.imgName" width="178">