package com.example.endterm.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.endterm.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.example.endterm.api.model.GitHubRepo;

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {

    private Context context;
    private List<GitHubRepo> values;

    public GitHubRepoAdapter(Context context, List<GitHubRepo> values) {
        super(context, R.layout.activity_details, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.activity_details, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.newsTitle);

        GitHubRepo item = values.get(position);
        String message = item.getName();
        textView.setText(message);

        return row;
    }
}
