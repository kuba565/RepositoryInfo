package pl.kuba565.RepositoryInfo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
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

