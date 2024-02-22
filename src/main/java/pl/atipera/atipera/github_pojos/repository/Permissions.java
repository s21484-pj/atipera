package pl.atipera.atipera.github_pojos.repository;

import lombok.Data;

@Data
public class Permissions {
    private boolean admin;
    private boolean maintain;
    private boolean push;
    private boolean triage;
    private boolean pull;
}
