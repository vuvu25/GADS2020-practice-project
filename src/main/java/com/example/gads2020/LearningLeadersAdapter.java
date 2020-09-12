package com.example.gads2020;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {
    private static final String TAG = "LearningLeadersAdapter";

    private ArrayList<LeaderModel> leaderModelList;
    private Context mContext;

    public LearningLeadersAdapter(ArrayList<LeaderModel> leaderModelList, Context context) {
        Log.d(TAG, "LearningLeadersAdapter: Called");
        this.leaderModelList = leaderModelList;
        this.mContext = context;
    }


    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: created");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.learning_leader_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        LeaderModel leaderModel = leaderModelList.get(position);
        Log.d(TAG, "onBindViewHolder: Setting Items");
        Picasso.get().load(leaderModel.getLeaderImage()).into(holder.leaderImage);
        holder.leader.setText(leaderModel.getLeaderName());
        holder.hours.setText(leaderModel.getLearningHrs());
        holder.location.setText(leaderModel.getLeaderLocation());

        notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return leaderModelList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView leaderImage;
        TextView leader, hours, location;
        CardView cardView;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            leaderImage = itemView.findViewById(R.id.leader_image);
            leader = itemView.findViewById(R.id.leader);
            hours = itemView.findViewById(R.id.learning_hrs);
            location = itemView.findViewById(R.id.location);
            cardView = itemView.findViewById(R.id.card_view);
            leaderImage = itemView.findViewById(R.id.leader_image);
        }
    }
}
