package com.example.retrofittest;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class GitHubRepoList {
    private static GitHubRepoList sGitHubRepo;
    private List<GitHubRepo> mGitHubRepos;

    public static GitHubRepoList get(Context context){
        if(sGitHubRepo == null){
            sGitHubRepo = new GitHubRepoList(context);
        }
        return sGitHubRepo;
    }
    private GitHubRepoList(Context context){
        mGitHubRepos = new ArrayList<>();
    }
    public List<GitHubRepo> getGitHubRepos(){
        return mGitHubRepos;
    }


}