package com.example.retrofittest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReposListFragment extends Fragment {
    private RecyclerView mReposRecyclerView;
    private ReposAdapter mAdapter;
    private GitHubRepo mGitHubRepo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_repos_list,container,false);

        mReposRecyclerView = (RecyclerView) view.findViewById(R.id.repos_recycler_view);
        mReposRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }
    private void updateUI(){
        mAdapter = new ReposAdapter()
    }

    private class ReposHolder extends RecyclerView.ViewHolder{
        public ReposHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_repos,parent,false));
        }
    }

    public class ReposAdapter extends RecyclerView.Adapter<ReposHolder>{
        private List<GitHubRepoList> mGitHubRepos;

        public ReposAdapter(List<GitHubRepoList> gitHubRepos){
            mGitHubRepos = gitHubRepos;
        }
        @Override
        public ReposHolder onCreateViewHolder(ViewGroup parent,int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new ReposHolder(layoutInflater,parent);
        }

        @Override
        public void onBindViewHolder(ReposHolder holder,int position){

        }
        @Override
        public int getItemCount(){
            return mGitHubRepos.size();
        }

    }


}
