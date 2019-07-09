package pl.kuba565.repositoryInfo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import pl.kuba565.repositoryInfo.aspect.LogAspect;
import pl.kuba565.repositoryInfo.client.HttpClient;
import pl.kuba565.repositoryInfo.validation.RepositoryRequestValidator;

import static javax.management.timer.Timer.ONE_HOUR;
import static javax.management.timer.Timer.ONE_MINUTE;

@Configuration
@ComponentScan
public class ServiceConfig {

    @Bean
    public HttpClient HttpClient() {
        return new HttpClient();
    }

    @Bean
    public RepositoryRequestValidator RepositoryRequestValidator() {
        return new RepositoryRequestValidator();
    }

    @Bean
    public RepositoryInfoDTOToRepositoryInfoTransformer RepositoryInfoDTOToRepositoryInfoTransformer() {
        return new RepositoryInfoDTOToRepositoryInfoTransformer();
    }


    @Bean
    public GithubRepositoryInfoGetter GithubRepositoryInfoGetter(HttpClient httpClient,
                                                                 RepositoryRequestValidator repositoryRequestValidator,
                                                                 RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer) {
        return new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator, repositoryInfoDTOToRepositoryInfoTransformer);
    }


    @Scheduled(fixedRate = ONE_HOUR)
    @CacheEvict(value = {"repositories"})
    public void clearRepositoriesCache() {
        final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
        LOG.info("---CACHE CLEARED---");
    }
}
