package losemap.co.kr.letspark;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CurrentActivity extends AppCompatActivity implements View.OnClickListener{
    AQuery aq;
    Gson gson;
    ImageView img1, img2, img3, img4, img5, img6;
    //주차구역 이미지변경관련
    TextView tx1, tx2, tx3, tx4, tx5, tx6;
    //주차구역 텍스트 관련
    String phone;
    //내 폰번호


    int refreshTime=2000; //5초마다 새로 정보를 불러온다.

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            settingLayout();

            mHandler.sendEmptyMessageDelayed(0,refreshTime);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        aq = new AQuery(getApplicationContext());
        gson = new Gson();
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        tx1 = findViewById(R.id.tx1);
        tx2 = findViewById(R.id.tx2);
        tx3 = findViewById(R.id.tx3);
        tx4 = findViewById(R.id.tx4);
        tx5 = findViewById(R.id.tx5);
        tx6 = findViewById(R.id.tx6);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_SMS,Manifest.permission.READ_PHONE_STATE},1);

        }
        //퍼미션 정보 가져오기
        else{
            settingLayout();
            TelephonyManager tm = (TelephonyManager) getApplicationContext().getSystemService(TELEPHONY_SERVICE);
            phone = tm.getLine1Number();
            mHandler.sendEmptyMessage(0);

        }
//데이터 구조로 받는 방법
    }


    public void settingLayout(){
        Map<String, Object> map = new HashMap<String, Object>();
        aq.ajax("http://dna110.dothome.co.kr/work/letspark/park_list.php", map, String.class, new AjaxCallback<String>() {

            @Override
            public void callback(String url, String objects, AjaxStatus status) {
                if (objects != null) {
//                    JsonArray jsonArray=gson.fromJson(objects.toString().replace("[","").replace("]",""),JsonArray.class);
                    try {
                        JSONArray jarr = new JSONArray(objects);
                        for (int i = 0; i < jarr.length(); i++) {
                            JSONObject job = (JSONObject) jarr.get(i);
                            setScreen(job.get("parknum"), job.get("onoff"), job.get("dt"),job.get("phone"));

                        }
                        jarr.get(0);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
    }

    private void setScreen(Object parknum, Object onoff, Object dt, Object myphone) throws ParseException {
        if (parknum.toString().equals("1")) {
            if (onoff.toString().equals("on")) {
                if(myphone.toString().equals(phone)){
                    img1.setImageResource(R.drawable.car_my);
                    tx1.setText("내차 주차중\n 시작:" + dt+"\n 요금:" +gettax(dt));
                }
                else if(!myphone.toString().trim().equals("")){
                    tx1.setText("다른 사용자 주차중");
                    img1.setImageResource(R.drawable.car_o);
                }
                else{
                    tx1.setText("사용자 주차중");
                    img1.setImageResource(R.drawable.car_o);

                }


            } else {
                tx1.setText("주차가능");
                img1.setImageResource(R.drawable.car_x);
            }

        }
        if (parknum.toString().equals("2")) {
            if (onoff.toString().equals("on")) {

                if(myphone.toString().equals(phone)){
                    img2.setImageResource(R.drawable.car_my);
                    tx2.setText("내차 주차중\n 시작:" + dt+"\n 요금:" +gettax(dt));
                }
                else if(!myphone.toString().trim().equals("")){
                    tx2.setText("다른 사용자 주차중");
                    img2.setImageResource(R.drawable.car_o);
                }
                else{
                    tx2.setText("사용자 주차중");
                    img2.setImageResource(R.drawable.car_o);

                }
            } else {
                tx2.setText("주차가능");
                img2.setImageResource(R.drawable.car_x);
            }

        }
        if (parknum.toString().equals("3")) {
            if (onoff.toString().equals("on")) {
                if(myphone.toString().equals(phone)){
                    img3.setImageResource(R.drawable.car_my);
                    tx3.setText("내차 주차중\n 시작:" + dt+"\n 요금:" +gettax(dt));
                }
                else if(!myphone.toString().trim().equals("")){
                    tx3.setText("다른 사용자 주차중");
                    img3.setImageResource(R.drawable.car_o);
                }
                else{
                    tx3.setText("사용자 주차중");
                    img3.setImageResource(R.drawable.car_o);

                }
            } else {
                tx3.setText("주차가능");
                img3.setImageResource(R.drawable.car_x);
            }
        }
        if (parknum.toString().equals("4")) {
            if (onoff.toString().equals("on")) {
                if(myphone.toString().equals(phone)){
                    img4.setImageResource(R.drawable.car_my);
                    tx4.setText("내차 주차중\n 시작:" + dt+"\n 요금:" +gettax(dt));
                }
                else if(!myphone.toString().trim().equals("")){
                    tx4.setText("다른 사용자 주차중");
                    img4.setImageResource(R.drawable.car_o);
                }
                else{
                    tx4.setText("사용자 주차중");
                    img4.setImageResource(R.drawable.car_o);

                }
            } else {
                tx4.setText("주차가능");
                img4.setImageResource(R.drawable.car_x);
            }

        }
        if (parknum.toString().equals("5")) {
            if (onoff.toString().equals("on")) {
                if(myphone.toString().equals(phone)){
                    img5.setImageResource(R.drawable.car_my);
                    tx5.setText("내차 주차중\n 시작:" + dt+"\n 요금:" +gettax(dt));
                }
                else if(!myphone.toString().trim().equals("")){
                    tx5.setText("다른 사용자 주차중");
                    img5.setImageResource(R.drawable.car_o);
                }
                else{
                    tx5.setText("사용자 주차중");
                    img5.setImageResource(R.drawable.car_o);

                }
            } else {
                tx5.setText("주차가능");
                img5.setImageResource(R.drawable.car_x);
            }

        }
        if (parknum.toString().equals("6")) {
            if (onoff.toString().equals("on")) {
                if(myphone.toString().equals(phone)){
                    img6.setImageResource(R.drawable.car_my);
                    tx6.setText("내차 주차중\n 시작:" + dt+"\n 요금:" +gettax(dt));
                }
                else if(!myphone.toString().trim().equals("")){
                    tx6.setText("다른 사용자 주차중");
                    img6.setImageResource(R.drawable.car_o);
                }
                else{
                    tx6.setText("사용자 주차중");
                    img6.setImageResource(R.drawable.car_o);

                }
            } else {
                tx6.setText("주차가능");
                img6.setImageResource(R.drawable.car_x);
            }

        }


    }

    private boolean Ismycar() {
            if(tx1.getText().toString().startsWith("내차")||
                tx2.getText().toString().startsWith("내차")||
                tx3.getText().toString().startsWith("내차")||
                tx4.getText().toString().startsWith("내차")||
                tx5.getText().toString().startsWith("내차")||
                tx6.getText().toString().startsWith("내차"))return false;
            else{
                return true;
            }
    }

    private String gettax(Object dt) throws ParseException {
        //요금계산하기

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dte=sdf.parse(dt.toString());
        Date nowDate=new Date();
        long gap=nowDate.getTime()-dte.getTime();
        int gapMin= (int) (gap/(60*1000));

        if(gapMin<30){
            return "3000원";
        }
        else{
            return (3000+((gapMin-30)/10+1)*1000)+"원";
        }


    };

    @Override
    public void onClick(View view) {
        int ids = view.getId();
        String text_park="사용자";
        if(!Ismycar())return;
            //내차가 주차되어있을경우에는 밑에를 실행하지않는다.
        switch (ids) {
            case R.id.img1:
                if(tx1.getText().toString().startsWith(text_park))
                createDialog(1).show();
                break;
            case R.id.img2:
                if(tx2.getText().toString().startsWith(text_park))
                createDialog(2).show();
                break;
            case R.id.img3:
                if(tx3.getText().toString().startsWith(text_park))
                createDialog(3).show();
                break;
            case R.id.img4:
                if(tx4.getText().toString().startsWith(text_park))
                createDialog(4).show();
                break;
            case R.id.img5:
                if(tx5.getText().toString().startsWith(text_park))
                createDialog(5).show();
                break;
            case R.id.img6:
                if(tx6.getText().toString().startsWith(text_park))
                createDialog(6).show();
                break;

        }

    }

    private AlertDialog createDialog(final int j) {
        final AlertDialog.Builder alg = new AlertDialog.Builder(CurrentActivity.this);
        alg.setTitle("확인");
        alg.setMessage(j + " 구역에 주차하시겠습니까?");
        alg.setCancelable(false);
        alg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Map<String, Object> map = new HashMap<String, Object>();

                map.put("parknum",j+"");
                map.put("phone",phone+"");

                aq.ajax("http://dna110.dothome.co.kr/work/letspark/park_update.php", map, String.class, new AjaxCallback<String>() {

                    @Override
                    public void callback(String url, String objects, AjaxStatus status) {
                        if (objects != null) {
                            settingLayout();

                        }


                    }
                });
            }});
        alg.setNegativeButton("취소",null);

        return alg.create();


    }


}
