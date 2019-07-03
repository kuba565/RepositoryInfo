package pl.kuba565.RepositoryInfo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
// TODO: @Builder lets you automatically produce the code required to have your class be instantiable with code such as:
//RepositoryInfo.builder().name("Adam Savage").city("San Francisco").job("Mythbusters").job("Unchained Reaction").build();

// or functional interface in controller
public class RepositoryInfo {
    private String full_name; //TODO: object mapping
    private String description;
    private String clone_url;
    private Integer stargazers_count;
    private String created_at;
}
