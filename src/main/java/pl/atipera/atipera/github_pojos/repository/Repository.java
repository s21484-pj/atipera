package pl.atipera.atipera.github_pojos.repository;

import lombok.Data;

import java.util.List;

@Data
public class Repository {
    private int id;
    private String node_id;
    private String name;
    private String full_name;
    private Owner owner;
    private boolean _private;
    private String html_url;
    private String description;
    private boolean fork;
    private String url;
    private String archive_url;
    private String assignees_url;
    private String blobs_url;
    private String branches_url;
    private String collaborators_url;
    private String comments_url;
    private String commits_url;
    private String compare_url;
    private String contents_url;
    private String contributors_url;
    private String deployments_url;
    private String downloads_url;
    private String events_url;
    private String forks_url;
    private String git_commits_url;
    private String git_refs_url;
    private String git_tags_url;
    private String hooks_url;
    private String issue_comment_url;
    private String issue_events_url;
    private String issues_url;
    private String keys_url;
    private String labels_url;
    private String languages_url;
    private String merges_url;
    private String milestones_url;
    private String notifications_url;
    private String pulls_url;
    private String releases_url;
    private String stargazers_url;
    private String statuses_url;
    private String subscribers_url;
    private String subscription_url;
    private String tags_url;
    private String teams_url;
    private String trees_url;
    private String clone_url;
    private String mirror_url;
    private String svn_url;
    private String homepage;
    private String language;
    private int forks_count;
    private int stargazers_count;
    private int watchers_count;
    private int size;
    private String default_branch;
    private int open_issues_count;
    private boolean is_template;
    private List<String> topics;
    private boolean has_issues;
    private boolean has_projects;
    private boolean has_wiki;
    private boolean has_pages;
    private boolean has_downloads;
    private boolean has_discussions;
    private boolean archived;
    private boolean disabled;
    private String visibility;
    private String pushed_at;
    private String created_at;
    private String updated_at;
    private Permissions permissions;
    private String role_name;
    private String temp_clone_token;
    private boolean delete_branch_on_merge;
    private int subscribers_count;
    private int network_count;
    private CodeOfConduct code_of_conduct;
    private License license;
    private SecurityAndAnalysis security_and_analysis;
}
