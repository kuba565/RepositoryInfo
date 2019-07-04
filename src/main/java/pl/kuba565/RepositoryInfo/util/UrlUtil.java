package pl.kuba565.RepositoryInfo.util;

import pl.kuba565.RepositoryInfo.model.RepositoryRequest;

public class UrlUtil {
    public static String getUrl(RepositoryRequest repositoryRequest) {
        return String.format("https://api.github.com/repos/%s/%s", repositoryRequest.getOwner(), repositoryRequest.getRepositoryName());

    }
}
