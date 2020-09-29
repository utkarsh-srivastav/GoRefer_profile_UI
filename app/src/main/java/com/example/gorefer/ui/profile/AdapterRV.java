package com.example.gorefer.ui.profile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gorefer.R;
import java.util.ArrayList;

public class AdapterRV extends RecyclerView.Adapter<RvViewHolder> {

    ArrayList<DataRV> dataRVS;

    public AdapterRV() {
        dataRVS = new ArrayList<>();
    }

    public void setData(ArrayList<DataRV> dataRVS) {
        this.dataRVS = dataRVS;
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.container_rv, parent, false);
        return new RvViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        DataRV dataRV = dataRVS.get(position);
        holder.txt_userId.setText("UserId: " + dataRV.userId);
        holder.txt_id.setText("Id: " + dataRV.id);
        holder.txt_title_rv.setText(String.valueOf(dataRV.title));
        holder.txt_body.setText(String.valueOf(dataRV.body));
    }

    @Override
    public int getItemCount() {
        return dataRVS.size();
    }
}