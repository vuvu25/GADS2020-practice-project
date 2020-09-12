package com.example.gads2020;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LearningLeaders extends Fragment {

    ArrayList<LeaderModel> leaderModel;
    private static final String TAG = "LearningLeaders";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState, URI GsonConverterFactory) {

        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        Log.d(TAG, "onCreateView: Layout Inflated");
        //Implementing recyclerview;
        RecyclerView recyclerView = view.findViewById(R.id.leader_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), linearLayoutManager.getOrientation()));

//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        leaderModel = new ArrayList<>();

        Log.d(TAG, "onCreateView: Adapter Set");

        // getting network Requests
        getPosts(GsonConverterFactory);


        recyclerView.setAdapter(new LearningLeadersAdapter(leaderModel, getActivity()));
        return view;
    }

    private  void getPosts(URI GsonConverterFactory){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://gadsapi.herokuapp.com/");
        final Retrofit.Builder builder1;
        Retrofit retrofit = builder
                .build();
        Log.d(TAG, "onCreateView: Retrofit Gotten");
        Api api = retrofit.create(Api.class);
        Call<ArrayList<LeaderModel>> call = api.getHours();
        Log.d(TAG, "onCreateView: Repo Created Gotten");
        call.enqueue(new Callback<ArrayList<LeaderModel>>() {
            @Override
            public void onResponse(Call<ArrayList<LeaderModel>> call, Response<ArrayList<LeaderModel>> response) {
                Log.d(TAG, "onCreateView: Data Gotten");
                if(!response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+response.message());
                }
                for(LeaderModel model : response.body()){
                    leaderModel.add(model);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<LeaderModel>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());

            }
        });


    }
}