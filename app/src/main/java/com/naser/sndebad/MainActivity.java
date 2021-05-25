package com.naser.sndebad;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
String[]item;
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= findViewById(R.id.list);
        title= findViewById(R.id.txt_title);
        item=getResources().getStringArray(R.array.index);//getting array from string resource

        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,R.layout.row,R.id.txt_item,item);// adapter
        listView.setAdapter(arrayAdapter);
        ///////////////////////////change the font/////////////////////////////
        Typeface  typeface=Typeface.createFromAsset(getAssets(),"font.ttf");
        title.setTypeface(typeface);
        //////////////////////////////change the font/////////////////////////////
        //////////////////////////////////on click//////////////////////////////
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in=new Intent(MainActivity.this,WebHtml.class);
                in.putExtra("page",position);
                startActivity(in);
            }
        });
        //////////////////////////////////on click//////////////////////////////

    }

    public void onClickShare(View view) {
        String txtShare ="تطبيق حكايات السندباد";
        String shareLink = "https://play.google.com/store/apps/details?id=com.naser.sndebad";
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT,txtShare +"\n" + shareLink);
        startActivity(share);
    }

    public void onClickMore(View view) {
        Intent more=new Intent(Intent.ACTION_VIEW);
        more.setData(Uri.parse("https://play.google.com/store/apps/developer?id=Qays3DD"));
        startActivity(more);
    }



    public void onClickEmail(View view) {
        try {
            String txt=" اقتراحي هه \n والسلام عليكم ورحمة الله وبركات";
            Intent email = new Intent(Intent.ACTION_SEND);
            email.setData(Uri.parse("mailto:"));
            email.setType("message/rfc822");
            email.putExtra(Intent.EXTRA_EMAIL, "n.abkar9@gmail.com");
            email.putExtra(Intent.EXTRA_SUBJECT, "تطبيق حكايات السندباد");
            email.putExtra(Intent.EXTRA_TEXT, txt);
            startActivity(email);
        }
        catch (Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }



    }

    public void onClickClose(View view) {
        finish();
    }
}