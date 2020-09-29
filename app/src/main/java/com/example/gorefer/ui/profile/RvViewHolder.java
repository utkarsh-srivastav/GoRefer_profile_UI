package com.example.gorefer.ui.profile;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gorefer.R;

public class RvViewHolder extends RecyclerView.ViewHolder {

    TextView txt_userId, txt_id, txt_title_rv, txt_body;
    public RvViewHolder(@NonNull View itemView) {
        super(itemView);

        txt_userId = itemView.findViewById(R.id.txtuserId);
        txt_id = itemView.findViewById(R.id.txtid);
        txt_title_rv = itemView.findViewById(R.id.txttitle_rv);
        txt_body = itemView.findViewById(R.id.txtbody);
    }
}
