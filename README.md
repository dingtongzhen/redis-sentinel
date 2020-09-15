# 接上两篇文章:https://my.oschina.net/dtz/blog/4467089 ;https://my.oschina.net/dtz/blog/4467179

参考资料：https://docs.spring.io/spring-data/redis/docs/2.3.2.RELEASE/reference/html/#redis:sentinel

redis-sentinel

1、一主两从三哨兵模式，实现springboot项目的链接使用示例

2、maven主要依赖：
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-redis</artifactId>
            <version>2.3.2.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>redis.clients</groupId>
            <artifactId>jedis</artifactId>
            <version>3.3.0</version>
        </dependency>
        <dependency>
        
3、哨兵配置：

 #哨兵的配置列表
 
spring.redis.sentinel.master=mymaster

spring.redis.sentinel.nodes=192.168.111.129:27000,192.168.111.130:27001,192.168.111.131:27002

spring.redis.sentinel.password=123456

spring.redis.password=123456

4、测试示例：

 @Test
    public void testString (){
        stringRedis.set("name", "dingzhen");
        System.out.println(stringRedis.get("name"));
    }
    
5、成功输出展示：

2020-08-08 11:21:13.511  INFO 7884 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-08-08 11:21:14.012  INFO 7884 --- [           main] redis.clients.jedis.JedisSentinelPool    : Trying to find master from available Sentinels...
2020-08-08 11:21:14.074  INFO 7884 --- [           main] redis.clients.jedis.JedisSentinelPool    : Redis master running at 192.168.111.131:7002, starting Sentinel listeners...
2020-08-08 11:21:14.144  INFO 7884 --- [           main] redis.clients.jedis.JedisSentinelPool    : Created JedisPool to master at 192.168.111.131:7002
2020-08-08 11:21:14.712  INFO 7884 --- [           main] com.dingzhen.DemoApplicationTests        : Started DemoApplicationTests in 3.831 seconds (JVM running for 5.642)

dingzhen
