package pl.kuba565.RepositoryInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RepositoryRequest {
    private String owner;
    private String repositoryName;
}
