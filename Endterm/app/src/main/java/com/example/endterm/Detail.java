package com.example.endterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.example.endterm.models.Model;

public class Detail extends AppCompatActivity {

    Model News;

    TextView title;
    TextView description;
    TextView createdAt;
    ImageView mainImage;
    Button shareBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title = findViewById(R.id.newsTitle);
        description = findViewById(R.id.descriptionTextView);
        mainImage = findViewById(R.id.mainImage);
        shareBtn = findViewById(R.id.shareBtn);
        createdAt = findViewById(R.id.newsCreationDate);

        int NewsId = getIntent().getIntExtra("NewsId", -1);

        Generator NewsGenerator = Generator.getInstance();

        if(NewsId != -1){
            News = NewsGenerator.getNews(NewsId);

            if(News != null){
                title.setText(News.getTitle());
                description.setText(News.getLongDescription());
                createdAt.setText( "Дата создания: " +
                        DateJ.getFormattedStringFromDate(News.getCratetion_date()));

                Glide.with(this)
                        .load(News.getImage_url())
                        .placeholder(R.drawable.ic_ball_load)
                        .into(mainImage);


                shareBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showToast("Не получилось сделать");
                    }
                });


            }

        }
    }

    private void showToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
