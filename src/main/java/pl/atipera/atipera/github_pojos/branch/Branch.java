package pl.atipera.atipera.github_pojos.branch;

import lombok.Data;

@Data
public class Branch {

    private String name;

    private Commit commit;

    private boolean _protected;
}
