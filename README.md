# spring-boot-web-support
An support project for Spring Boot Web



## Dependencies & Compatibility

| Dependencies   | Compatibility |
| -------------- | ------------- |
| Java           | 1.7 +         |
| Servlet        | 3.0 +         |
| Spring Boot    | 1.4 +         |
| [Alibaba Spring WebMVC Support](https://github.com/alibaba/spring-webmvc-support) | 1.0.0 + |
| [Alibaba Spring Context Support](https://github.com/alibaba/spring-context-support) | 1.0.0 + |


## Downstream Projects

* [Alibaba Spring WebMVC Support](https://github.com/alibaba/spring-webmvc-support)
    * [Alibaba Spring Context Support](https://github.com/alibaba/spring-context-support)





## Release version

````xml
<dependencies>

    ......

     <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <version>${spring-boot.version}</version>
    </dependency>

    <!-- Spring Boot Web Support -->
    <dependency>
        <groupId>com.alibaba.boot</groupId>
        <artifactId>spring-boot-web-support</artifactId>
        <version>0.1.0</version>
    </dependency>

    ......

</dependencies>
````



If your project failed to resolve the dependency, try to add the following repository:
```xml
    <repositories>
        <repository>
            <id>sonatype-nexus</id>
            <url>https://oss.sonatype.org/content/repositories/releases</url>
            <releases>
                <enabled>true</enabled>
            </releases>
        </repository>
    </repositories>
```




## Documents

TODO