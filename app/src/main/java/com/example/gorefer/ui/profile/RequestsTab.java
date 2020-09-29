package com.example.gorefer.ui.profile;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.Volley;
import com.example.gorefer.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class RequestsTab extends Fragment {

    String url = "https://jsonplaceholder.typicode.com/posts";
    RecyclerView recyclerView;
    AdapterRV adapterRV;
    ArrayList<DataRV> dataRVS;

    ProgressBar progressBar;

    TextView txt_home;

    public RequestsTab() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
    }

    private void getData() {
        progressBar.setAlpha(1);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        DataRV dataRV = new DataRV();
                        dataRV.setUserId(jsonObject.getInt("userId"));
                        dataRV.setUserId(jsonObject.getInt("id"));
                        dataRV.setTitle(jsonObject.getString("title"));
                        dataRV.setBody(jsonObject.getString("body"));
                        dataRVS.add(dataRV);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Json is not valid", Toast.LENGTH_SHORT).show();
                    txt_home.setAlpha(1);
                }
                adapterRV.setData(dataRVS);
                adapterRV.notifyDataSetChanged();
                progressBar.setAlpha(0);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setAlpha(0);
                Toast.makeText(getContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
                txt_home.setAlpha(1);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));
        requestQueue.add(jsonArrayRequest);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_requests, container, false);

        txt_home = view.findViewById(R.id.text_home);
        progressBar = view.findViewById(R.id.progressBar);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterRV = new AdapterRV();
        recyclerView.setAdapter(adapterRV);
        dataRVS = new ArrayList<>();
        getData();
        // Inflate the layout for this fragment
        return view;
    }
}

