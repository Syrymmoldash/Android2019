package com.labawsrh.aws.Midterm;

import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    RecyclerView NewsRecyclerview;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    FloatingActionButton fabSwitcher;
    boolean isDark = false;
    ConstraintLayout rootLayout;
    EditText searchInput ;
    CharSequence search="";
    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        fabSwitcher = findViewById(R.id.fab_switcher);
        rootLayout = findViewById(R.id.root_layout);
        searchInput = findViewById(R.id.search_input);
        NewsRecyclerview = findViewById(R.id.news_rv);
        mData = new ArrayList<>();

        isDark = getThemeStatePref();
        if(isDark) {

            searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        }
        else
        {

            searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));

        }




        mData.add(new NewsItem("Заголовок 1","Здравствуйте! Агай, я не смог сделать так, чтобы элемнт открывался в новым окне, если нажать на него, прошу не судить строго. Просто я сейчас работаю(У меня свободное посещение) и времени совсем нет, к эндке всё сделаю, даю слово!",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 2","ылдфалдфьалдфьалдфыьладыфтлатфлдатлдфтаылдфыаыфа",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 3","ыфдлаьфлаьыфьафыщзьащзфьащзыфьащзфьыщзаьыфсщзьщфзсьщзьфсщзьф",currentDate,R.drawable.uservoyager));
        mData.add(new NewsItem("Заголовок 4","зыфщаьфщзьащфзыьащызфьащзьфыщзаьыщфзьащзфцьащзьа",currentDate,R.drawable.useillust));
        mData.add(new NewsItem("Заголовок 5","щтфыщатыфштщшзтзщсьщфзьцщзфцьщзцфьзцьфсзьщфцзьщ2ьвщзь2щзь2зщьзщ2ьщз2ьщзь2щзь",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 6","аывммльывмьывзмьызмьызьмзыьмзыьмзщыьмщзьывщмьзымывмвымвымывмвымкаипаиат пра пааиапиап",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 7","ререкркркнкепасмсисистаптатпататпатпатпапататап",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 8","тпатаптпаттттттттттттаптаптпатаптпатапта",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 9","тпатпататпатаатпатааптатататаптпатап",currentDate,R.drawable.uservoyager));
        mData.add(new NewsItem("Заголовок 10","патпатаьаьпаьпаьььььььмтвааааааааааааааааттеееетарапатммптваиисисиатпататаарарап",currentDate,R.drawable.useillust));
        mData.add(new NewsItem("Заголовок 11","парерараписпимисивапыфкцфуаыаыаыаыпуыкпвпвпвпвкркверррврврерврв",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 12","рврвркрвпвпквпкапоапоаопаопаоапоапопаоапоапоапоав",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 13","пывпкврврвкрапттмтмтарапраоапопрпиваивисисиарапапооапопаоап",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 14","оапоапоапоеаоааараравпавпыкпыпыпвыпуфаываыуаыафауыаыуаыупвпвпврварв",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 15","арврварврвараравраврврврвраврвывпфывфаыфафафафафафавфаыафафафафыафаыфыафыаф",currentDate,R.drawable.uservoyager));
        mData.add(new NewsItem("Заголовок 16","выпфыпыфафаыфаыфаафыаыфаыфафыафыафаффыафыаыфафыаыфафыаыфаыфафыафыафыафыаыфафыафыафаыфаыфафа",currentDate,R.drawable.useillust));
        mData.add(new NewsItem("Заголовок 17","lрыаваыпвыпыпвырврварвррврвртвптвтвтватвиививравраврварваврварварварварва",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 7","ререкркркнкепасмсисистаптатпататпатпатпапататап",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 8","тпатаптпаттттттттттттаптаптпатаптпатапта",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 9","тпатпататпатаатпатааптатататаптпатап",currentDate,R.drawable.uservoyager));
        mData.add(new NewsItem("Заголовок 10","патпатаьаьпаьпаьььььььмтвааааааааааааааааттеееетарапатммптваиисисиатпататаарарап",currentDate,R.drawable.useillust));
        mData.add(new NewsItem("Заголовок 11","парерараписпимисивапыфкцфуаыаыаыаыпуыкпвпвпвпвкркверррврврерврв",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 12","рврвркрвпвпквпкапоапоаопаопаоапоапопаоапоапоапоав",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 13","пывпкврврвкрапттмтмтарапраоапопрпиваивисисиарапапооапопаоап",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 14","оапоапоапоеаоааараравпавпыкпыпыпвыпуфаываыуаыафауыаыуаыупвпвпврварв",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 15","арврварврвараравраврврврвраврвывпфывфаыфафафафафафавфаыафафафафыафаыфыафыаф",currentDate,R.drawable.uservoyager));
        mData.add(new NewsItem("Заголовок 16","выпфыпыфафаыфаыфаафыаыфаыфафыафыафаффыафыаыфафыаыфафыаыфаыфафыафыафыафыаыфафыафыафаыфаыфафа",currentDate,R.drawable.useillust));
        mData.add(new NewsItem("Заголовок 17","lрыаваыпвыпыпвырврварвррврвртвптвтвтватвиививравраврварваврварварварварва",currentDate,R.drawable.circul6));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));
        mData.add(new NewsItem("Заголовок 18","равраврврврвравррвоавоавивиавиаыпыпыввывыпфвафафауецекнквпвпвапвравиаварвраварва",currentDate,R.drawable.user));


        newsAdapter = new NewsAdapter(this,mData,isDark);
        NewsRecyclerview.setAdapter(newsAdapter);
        NewsRecyclerview.setLayoutManager(new LinearLayoutManager(this));


        fabSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDark = !isDark ;
                if (isDark) {

                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);

                }
                else {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }

                newsAdapter = new NewsAdapter(getApplicationContext(),mData,isDark);
                if (!search.toString().isEmpty()){

                    newsAdapter.getFilter().filter(search);

                }
                NewsRecyclerview.setAdapter(newsAdapter);
                saveThemeStatePref(isDark);




            }
        });



        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                newsAdapter.getFilter().filter(s);
                search = s;


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }

    private void saveThemeStatePref(boolean isDark) {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }

    private boolean getThemeStatePref () {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPref",MODE_PRIVATE);
        boolean isDark = pref.getBoolean("isDark",false) ;
        return isDark;

    }



}
