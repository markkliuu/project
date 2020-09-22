package au.edu.unsw.infs3634.covidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;



public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.covidtracker.intent_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


    Intent intent = getIntent();
    if(intent.hasExtra(INTENT_MESSAGE))

    {
        TextView detailMessage = findViewById(R.id.tvDetailMessage);
        detailMessage.setText(intent.getStringExtra(INTENT_MESSAGE));
    }


    // detailMessage.setText(intent.getStringExtra(INTENT_MESSAGE));


    Button button = findViewById(R.id.btShowVideo);

    button.setOnClickListener(new View.OnClickListener()
    {
        @Override
        public void onClick (View v){
        DetailActivity.this.showVideo("https://www.youtube.com/watch?v=ieU8EGiTBa4");
    }
    });
}
    private void showVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}












