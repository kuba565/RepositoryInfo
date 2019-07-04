package pl.kuba565.RepositoryInfo.util;

public class UrlUtil {
    public static String getUrl(String owner, String repositoryName) {
        return String.format("https://api.github.com/repos/%s/%s", owner, repositoryName);

    }
}
