package pl.kuba565.repositoryInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryRequest {
    private String owner;
    private String repositoryName;
}
