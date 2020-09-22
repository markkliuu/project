package au.edu.unsw.infs3634.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private int age = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       // Log.d(TAG, msg:"onCreate line 15, Age = " + String.)
       // setContentView(R.layout.activity_main);

    Button button = findViewById(R.id.btLaunchActivity);

    button.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
            MainActivity.this.launchDetailActivity("test");
            }
        });
}

    private void launchDetailActivity(String message){
        Intent intent = new Intent( this, DetailActivity.class);
        intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
        startActivity(intent);
    }
        }
