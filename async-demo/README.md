# async-demo

```
2024-10-11T16:15:04.300+09:00  INFO 14949 --- [async-demo] [           main] org.simple.demo.Application              : Starting Application using Java 17.0.12 with PID 14949 (/home/jay/_doc/spike/java-framework/spring-boot/playground/async-demo/build/classes/java/main started by jay in /home/jay/_doc/spike/java-framework/spring-boot/playground/async-demo)
2024-10-11T16:15:04.304+09:00  INFO 14949 --- [async-demo] [           main] org.simple.demo.Application              : No active profile set, falling back to 1 default profile: "default"
2024-10-11T16:15:05.115+09:00  INFO 14949 --- [async-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-10-11T16:15:05.126+09:00  INFO 14949 --- [async-demo] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-10-11T16:15:05.126+09:00  INFO 14949 --- [async-demo] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.30]
2024-10-11T16:15:05.172+09:00  INFO 14949 --- [async-demo] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-10-11T16:15:05.173+09:00  INFO 14949 --- [async-demo] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 814 ms
// 스레드 풀
2024-10-11T16:15:05.252+09:00  INFO 14949 --- [async-demo] [           main] o.simple.demo.RootContextConfiguration   : Setting up thread pool task scheduler with 20 threads.
2024-10-11T16:15:05.569+09:00  INFO 14949 --- [async-demo] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
// 스케줄
2024-10-11T16:15:05.578+09:00  INFO 14949 --- [async-demo] [           main] o.simple.demo.RootContextConfiguration   : Configuring scheduled method executor org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler@2016f509.
2024-10-11T16:15:05.583+09:00  INFO 14949 --- [async-demo] [           main] org.simple.demo.Application              : Started Application in 1.706 seconds (process running for 2.036)
2024-10-11T16:15:08.748+09:00  INFO 14949 --- [async-demo] [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2024-10-11T16:15:08.749+09:00  INFO 14949 --- [async-demo] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2024-10-11T16:15:08.750+09:00  INFO 14949 --- [async-demo] [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms

2024-10-11T16:15:08.776+09:00  INFO 14949 --- [async-demo] [nio-8080-exec-1] org.simple.demo.PlayWorkService          : requested calling
2024-10-11T16:15:08.779+09:00  INFO 14949 --- [async-demo] [nio-8080-exec-1] o.simple.demo.RootContextConfiguration   : Configuring asynchronous method executor org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler@2016f509.
2024-10-11T16:15:08.780+09:00  INFO 14949 --- [async-demo] [         task-1] org.simple.demo.VinylWorkService         : async started with Requested
2024-10-11T16:15:08.780+09:00  INFO 14949 --- [async-demo] [nio-8080-exec-1] org.simple.demo.PlayWorkService          : requested called
2024-10-11T16:15:11.780+09:00  INFO 14949 --- [async-demo] [         task-1] org.simple.demo.VinylWorkService         : async finished

2024-10-11T16:15:20.589+09:00  INFO 14949 --- [async-demo] [         task-2] org.simple.demo.PlayWorkService          : scheduled calling
2024-10-11T16:15:20.589+09:00  INFO 14949 --- [async-demo] [         task-1] org.simple.demo.VinylWorkService         : async started with Scheduled
2024-10-11T16:15:20.589+09:00  INFO 14949 --- [async-demo] [         task-2] org.simple.demo.PlayWorkService          : scheduled called
2024-10-11T16:15:23.589+09:00  INFO 14949 --- [async-demo] [         task-1] org.simple.demo.VinylWorkService         : async finished

2024-10-11T16:15:35.590+09:00  INFO 14949 --- [async-demo] [         task-3] org.simple.demo.PlayWorkService          : scheduled calling
2024-10-11T16:15:35.591+09:00  INFO 14949 --- [async-demo] [         task-2] org.simple.demo.VinylWorkService         : async started with Scheduled
2024-10-11T16:15:35.591+09:00  INFO 14949 --- [async-demo] [         task-3] org.simple.demo.PlayWorkService          : scheduled called
2024-10-11T16:15:38.591+09:00  INFO 14949 --- [async-demo] [         task-2] org.simple.demo.VinylWorkService         : async finished
```