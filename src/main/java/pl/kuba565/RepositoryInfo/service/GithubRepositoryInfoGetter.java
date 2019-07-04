package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.util.UrlUtil;

import javax.validation.constraints.NotBlank;

@Service
@Validated
public class GithubRepositoryInfoGetter implements RepositoryInfoGetter {
    private HttpClient httpClient;

    public GithubRepositoryInfoGetter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public RepositoryInfoDTO getRepository(@NotBlank String owner, @NotBlank String repositoryName) {
        String URL = UrlUtil.getUrl(owner, repositoryName);

        return httpClient.get(URL);
    }
}
