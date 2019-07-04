package pl.kuba565.RepositoryInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class RepositoryRequest {
    @NotNull
    @NotBlank
    private String owner;
    @NotNull
    @NotBlank
    private String repositoryName;
}
