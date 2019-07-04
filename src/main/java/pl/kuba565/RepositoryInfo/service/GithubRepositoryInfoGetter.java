package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;
import pl.kuba565.RepositoryInfo.util.UrlUtil;
import pl.kuba565.RepositoryInfo.validation.RepositoryRequestValidator;

@Service
public class GithubRepositoryInfoGetter implements RepositoryInfoGetter {
    private HttpClient httpClient;
    private RepositoryRequestValidator repositoryRequestValidator;

    public GithubRepositoryInfoGetter(HttpClient httpClient, RepositoryRequestValidator repositoryRequestValidator) {
        this.httpClient = httpClient;
        this.repositoryRequestValidator = repositoryRequestValidator;
    }

    public RepositoryInfoDTO getRepository(RepositoryRequest repositoryRequest) {
        //TODO: TESTS FOR VALIDATION IN SERVICE
        BeanPropertyBindingResult beanPropertyBindingResult = new BeanPropertyBindingResult(repositoryRequest, "repositoryRequest");

        repositoryRequestValidator.validate(repositoryRequest, beanPropertyBindingResult);
        String URL = UrlUtil.getUrl(repositoryRequest);

        return httpClient.get(URL);
    }
}
