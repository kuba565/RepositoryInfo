package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.exception.ValidationException;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;
import pl.kuba565.RepositoryInfo.util.UrlUtil;
import pl.kuba565.RepositoryInfo.validation.RepositoryRequestValidator;

import java.util.List;

@Service
public class GithubRepositoryInfoGetter implements RepositoryInfoGetter {
    private HttpClient httpClient;
    private RepositoryRequestValidator repositoryRequestValidator;

    public GithubRepositoryInfoGetter(HttpClient httpClient, RepositoryRequestValidator repositoryRequestValidator) {
        this.httpClient = httpClient;
        this.repositoryRequestValidator = repositoryRequestValidator;
    }

    public RepositoryInfoDTO getRepository(RepositoryRequest repositoryRequest) {
        Errors errors = new BeanPropertyBindingResult(repositoryRequest, "repositoryRequest");

        repositoryRequestValidator.validate(repositoryRequest, errors);

        List<ObjectError> allErrors = errors.getAllErrors();

        if (allErrors.size() > 0) {
            throw new ValidationException(allErrors);
        } else {
            String URL = UrlUtil.getUrl(repositoryRequest);
            return httpClient.get(URL);
        }

    }
}
