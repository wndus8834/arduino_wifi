package losemap.co.kr.letspark;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by sonu on 10/04/17.
 */

public class AlarmNotificationService extends IntentService {
    private NotificationManager alarmNotificationManager;

    //Notification ID for Alarm
    public static final int NOTIFICATION_ID = 1;

    public AlarmNotificationService() {
        super("AlarmNotificationService");
    }

    @Override
    public void onHandleIntent(Intent intent) {

        //Send notification
        sendNotification("알람을 꺼주세요. 상단바를 클릭하면 앱으로 이동됩니다.");
    }

    //handle notification
    private void sendNotification(String msg) {
        alarmNotificationManager = (NotificationManager) this
                .getSystemService(Context.NOTIFICATION_SERVICE);

        //get pending intent
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        //Create notification
        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("시간이 만료되었습니다!").setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg).setAutoCancel(true);
        alamNotificationBuilder.setContentIntent(contentIntent);

        //notiy notification manager about new notification
        alarmNotificationManager.notify(NOTIFICATION_ID, alamNotificationBuilder.build());
    }


}
