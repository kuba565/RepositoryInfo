package pl.kuba565.RepositoryInfo.util;

public class URLUtil { // do przemyślenia
    public static String getURL(String owner, String repositoryName) { //naming convention
        return String.format("https://api.github.com/repos/%s/%s", owner, repositoryName);
    }
}
