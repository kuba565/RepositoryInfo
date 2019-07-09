package pl.kuba565.repositoryInfo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import pl.kuba565.repositoryInfo.client.HttpClient;
import pl.kuba565.repositoryInfo.exception.ValidationException;
import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryRequest;
import pl.kuba565.repositoryInfo.util.UrlUtil;
import pl.kuba565.repositoryInfo.validation.RepositoryRequestValidator;

import java.util.List;

public class GithubRepositoryInfoGetter implements RepositoryInfoGetter {
    private HttpClient httpClient;
    private RepositoryRequestValidator repositoryRequestValidator;
    private RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer;

    public GithubRepositoryInfoGetter(HttpClient httpClient,
                                      RepositoryRequestValidator repositoryRequestValidator,
                                      RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer) {
        this.httpClient = httpClient;
        this.repositoryRequestValidator = repositoryRequestValidator;
        this.repositoryInfoDTOToRepositoryInfoTransformer = repositoryInfoDTOToRepositoryInfoTransformer;
    }

    @Cacheable("repositories")
    public RepositoryInfo getRepository(RepositoryRequest repositoryRequest) {
        List<ObjectError> errors = validate(repositoryRequest);
        if (errors.size() > 0) {
            throw new ValidationException(errors);
        } else {
            return repositoryInfoDTOToRepositoryInfoTransformer.apply(httpClient.get(UrlUtil.getUrl(repositoryRequest)));
        }
    }

    private List<ObjectError> validate(RepositoryRequest repositoryRequest) {
        Errors errors = new BeanPropertyBindingResult(repositoryRequest, "repositoryRequest");
        repositoryRequestValidator.validate(repositoryRequest, errors);

        return errors.getAllErrors();
    }
}
