package app.example.kiit.fetching;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button b;
    Button b1;
    Button b2;
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
        tv=findViewById(R.id.tv);
        b=findViewById(R.id.b);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        sp=getSharedPreferences("shared",MODE_PRIVATE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedata();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveData();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteData();
            }
        });


    }
    private void retrieveData(){
        String data=sp.getString("name","");
        tv.setText(data);
    }
    private void savedata(){
        SharedPreferences.Editor editor;
        String data=et.getText().toString();
        editor=sp.edit();
        editor.putString("name",data);
        editor.putString("roll","1234");
        editor.apply();
        et.setText("");
        Toast.makeText(this,"DATA INSERTED SUCCESSFULLY",Toast.LENGTH_SHORT).show();
    }
    private void deleteData(){
        SharedPreferences.Editor editor;
        editor=sp.edit();
        editor.clear();
        editor.apply();
        Toast.makeText(this,"Data cleared",Toast.LENGTH_SHORT).show();
    }
}
