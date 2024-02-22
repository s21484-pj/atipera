package pl.atipera.atipera.github_pojos.repository;

import lombok.Data;

@Data
public class License {
    private String key;
    private String name;
    private String spdx_id;
    private String url;
    private String node_id;
}
