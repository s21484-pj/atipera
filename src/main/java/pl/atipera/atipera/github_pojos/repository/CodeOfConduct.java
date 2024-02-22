package pl.atipera.atipera.github_pojos.repository;

import lombok.Data;

@Data
public class CodeOfConduct {
    private String key;
    private String name;
    private String url;
    private String body;
    private String html_url;
}
