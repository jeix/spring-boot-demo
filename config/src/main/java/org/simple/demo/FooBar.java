package org.simple.demo;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Builder
public record FooBar(
    String foo,
    Integer bar,
    List<String> qux
) {

    public static FooBar getInstance() {
        FooBarConfigProperties properties = FooBarBeanUtil.getBean(FooBarConfigProperties.class);
        return FooBar.builder()
                .foo(properties.getFoo())
                .bar(properties.getBar())
                //.qux(List.of(properties.getQux()))
                .qux(properties.getQux())
                .build();
    }

    @Component
    @ConfigurationProperties(prefix = "vinyl.foobar")
    @Getter
    @Setter
    private static class FooBarConfigProperties {
        private String foo;
        private Integer bar;
        //private String[] qux;
        private List<String> qux;
    }

    @Service
    private static class FooBarBeanUtil implements ApplicationContextAware {

        private static ApplicationContext context;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) {
            context = applicationContext;
        }

        static <T> T getBean(Class<T> klass) {
            return context.getBean(klass);
        }
    }
}
