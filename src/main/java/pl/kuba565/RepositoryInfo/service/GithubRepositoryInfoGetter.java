package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;
import pl.kuba565.RepositoryInfo.util.UrlUtil;

@Service
public class GithubRepositoryInfoGetter implements RepositoryInfoGetter {
    private HttpClient httpClient;

    public GithubRepositoryInfoGetter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public RepositoryInfoDTO getRepository(RepositoryRequest repositoryRequest) {
        String URL = UrlUtil.getUrl(repositoryRequest);

        return httpClient.get(URL);
    }
}
