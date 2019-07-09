package pl.kuba565.repositoryInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.kuba565.repositoryInfo.service.RepositoryInfoGetter;
import pl.kuba565.repositoryInfo.service.ServiceConfig;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class RepositoryInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoryInfoApplication.class, args);
    }

}
