package com.example.book_record;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText book,auther;
    Button save;
    MyDBHelper db=new MyDBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       book= findViewById(R.id.book);
       auther=findViewById(R.id.auther);
       save=findViewById(R.id.save);
       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                String book1=book.getText().toString();
               String auther1=auther.getText().toString();
//              Access insert method into MyDBHelper class
                   db.insert(book1,auther1);
                   book.setText("");
                   auther.setText("");



           }
       });
    }
}