package pl.kuba565.RepositoryInfo.service;

import org.springframework.stereotype.Service;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.util.URLUtil;

@Service
public class GithubRepositoryGetter {
    private HttpClient httpClient;

    public GithubRepositoryGetter(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public RepositoryInfo getRepository(String owner, String repositoryName) {
        String URL = URLUtil.getURL(owner, repositoryName);

        return httpClient.get(URL);
    }
}
