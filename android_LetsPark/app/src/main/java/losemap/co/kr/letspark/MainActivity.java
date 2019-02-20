package losemap.co.kr.letspark;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView Parking_Check,Notice,Instructions,Push;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parking_Check=findViewById(R.id.Parking_Check);
        Notice =findViewById(R.id.Notice);
        Instructions=findViewById(R.id.Instructions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Push=findViewById(R.id.Push);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS,Manifest.permission.READ_PHONE_STATE},1);

        }

        Parking_Check.setOnClickListener(this);
        Notice.setOnClickListener(this);
        Instructions.setOnClickListener(this);
        Push.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.Parking_Check:
                startActivity(new Intent(getApplicationContext(),CurrentActivity.class));
                break;
            case R.id.Notice:
                startActivity(new Intent(getApplicationContext(),NoticeActivity.class));
                break;
            case R.id.Push:
                startActivity(new Intent(getApplicationContext(),AlarmMainActivity.class));
                break;
            case R.id.Instructions:
                PrefManager prefManager = new PrefManager(getApplicationContext());
                // make first time launch TRUE
                prefManager.setFirstTimeLaunch(true);
                startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
                break;
        }

    }
}
