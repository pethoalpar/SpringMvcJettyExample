<H1>Spring MVC Jetty Example</h1>

<h3>Add to pom.xml</h3>

```xml
<dependencies>
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>5.1.1.RELEASE</version>
   </dependency>
   <dependency>
       <groupId>org.eclipse.jetty</groupId>
       <artifactId>jetty-server</artifactId>
       <version>9.4.12.v20180830</version>
    </dependency>
    <dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-servlet</artifactId>
        <version>9.4.12.v20180830</version>
     </dependency>
     <dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-webapp</artifactId>
        <version>9.4.12.v20180830</version>
     </dependency>
</dependencies>
```    

<h3>Build config</h3>

```java
@EnableWebMvc
@Configuration
@ComponentScan({"com.pethoalpar.ctrl"})
public class Config {
}
```

<h3>Add controller</h3>

```java
@Controller
public class WebController {

    @RequestMapping(path = "/get/{name}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@PathVariable("name") String name){
        return "Hello "+name;
    }

    @RequestMapping(path = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test(){
        return "Success";
    }
}
```

<h3>Main.java</h3>

```java
public class Main {

    public static void main(String [] args) throws Exception {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.pethoalpar.config");

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.setErrorHandler(null);
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(context)),"/");

        Server server = new Server(8080);
        server.setHandler(contextHandler);
        server.start();
        server.join();
    }
}
```
