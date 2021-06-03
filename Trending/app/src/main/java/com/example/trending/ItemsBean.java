package com.example.trending;

import java.util.List;


public class ItemsBean {
    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getRepo_link() {
        return repo_link;
    }

    public void setRepo_link(String repo_link) {
        this.repo_link = repo_link;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getForks() {
        return forks;
    }

    public void setForks(String forks) {
        this.forks = forks;
    }

    public String getAdded_stars() {
        return added_stars;
    }

    public void setAdded_stars(String added_stars) {
        this.added_stars = added_stars;
    }

    public List<String> getAvatars() {
        return avatars;
    }

    public void setAvatars(List<String> avatars) {
        this.avatars = avatars;
    }

    /**
     * repo : doocs/leetcode
     * repo_link : https://github.com/doocs/leetcode
     * desc :
     * lang : Java
     * stars : 5,465
     * forks : 1,097
     * added_stars : 799 stars this week
     * avatars : ["https://avatars.githubusercontent.com/u/21008209?s=40&v=4","https://avatars.githubusercontent.com/u/17448306?s=40&v=4","https://avatars.githubusercontent.com/u/22535595?s=40&v=4","https://avatars.githubusercontent.com/in/15368?s=40&v=4","https://avatars.githubusercontent.com/u/42513350?s=40&v=4"]
     */

    private String repo;
    private String repo_link;
    private String desc;
    private String lang;
    private String stars;
    private String forks;
    private String added_stars;
    private List<String> avatars;
}

