package pl.kuba565.RepositoryInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@Validated
public class RepositoryRequest {
    @NonNull
    private String owner;
    @NonNull
    private String repositoryName;
}
