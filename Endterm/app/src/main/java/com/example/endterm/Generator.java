package com.example.endterm;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;

import com.example.endterm.models.Model;

class Generator {

    ArrayList<Model> NewsList;

    private static Generator instance;

    private Generator(){}

    static Generator getInstance(){
        if(instance != null){
            return instance;
        }
        else{
            instance = new Generator();
            instance.NewsList = new ArrayList<>();
            for (int i = 0; i< 1000; i++){
                instance.NewsList.add(
                        new Model(
                                i,
                                "Title 1",
                                "Short description",
                                "Long description \n ",
                                "https://s9.stc.all.kpcdn.net/share/i/4/1237988/inx960x640.jpg?w=1600",
                                Calendar.getInstance().getTime()
                        )
                );
            }
        }

        return instance;
    }

    ArrayList<Model> getNewsList(){
        return NewsList;
    }


    @Nullable
    Model getNews(int id){

        if(id<NewsList.size()){
            return NewsList.get(id);
        }
        return null;
    }

}
