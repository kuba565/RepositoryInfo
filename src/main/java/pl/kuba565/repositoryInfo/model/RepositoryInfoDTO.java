package pl.kuba565.repositoryInfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryInfoDTO {
    private String full_name;
    private String description;
    private String clone_url;
    private Integer stargazers_count;
    private String created_at;

}

