package pl.kuba565.RepositoryInfo.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryInfo {
    private String fullName;
    private String description;
    private String cloneUrl;
    private Integer stars;
    private String createdAt;
}
