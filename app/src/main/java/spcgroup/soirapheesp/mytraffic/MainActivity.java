package spcgroup.soirapheesp.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private ListView trafficListView;
    private Button aboutmeButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        bindWidget();

        //button controller
        buttonController();

        //Listview COntroller
        ListViewController();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }   // Main Method

    private void ListViewController() {
        // For Icon
        final int[] intIcon = {R.drawable.traffic_01, R.drawable.traffic_02, R.drawable.traffic_03
                , R.drawable.traffic_04, R.drawable.traffic_05, R.drawable.traffic_06
                , R.drawable.traffic_07, R.drawable.traffic_08, R.drawable.traffic_09
                , R.drawable.traffic_10, R.drawable.traffic_11, R.drawable.traffic_12
                , R.drawable.traffic_13, R.drawable.traffic_14, R.drawable.traffic_15
                , R.drawable.traffic_16, R.drawable.traffic_17, R.drawable.traffic_18
                , R.drawable.traffic_19, R.drawable.traffic_20};
        //For Title

        final String[] titleStrings = new String[20];
        titleStrings[0] = "หัวข้อที่ 1";
        titleStrings[1] = "หัวข้อที่ 2";
        titleStrings[2] = "หัวข้อที่ 3";
        titleStrings[3] = "หัวข้อที่ 4";
        titleStrings[4] = "หัวข้อที่ 5";
        titleStrings[5] = "หัวข้อที่ 6";
        titleStrings[6] = "หัวข้อที่ 7";
        titleStrings[7] = "หัวข้อที่ 8";
        titleStrings[8] = "หัวข้อที่ 9";
        titleStrings[9] = "หัวข้อที่ 10";
        titleStrings[10] = "หัวข้อที่ 11";
        titleStrings[11] = "หัวข้อที่ 12";
        titleStrings[12] = "หัวข้อที่ 13";
        titleStrings[13] = "หัวข้อที่ 14";
        titleStrings[14] = "หัวข้อที่ 15";
        titleStrings[15] = "หัวข้อที่ 16";
        titleStrings[16] = "หัวข้อที่ 17";
        titleStrings[17] = "หัวข้อที่ 18";
        titleStrings[18] = "หัวข้อที่ 19";
        titleStrings[19] = "หัวข้อที่ 20";

        //For Detail
        String[] detailStrings = getResources().getStringArray(R.array.detail_short);

        MyAdapter objMyAdapter = new MyAdapter(MainActivity.this, titleStrings, detailStrings, intIcon);

        trafficListView.setAdapter(objMyAdapter);

        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent objIntent = new Intent(MainActivity.this, DetailActivity.class);
                objIntent.putExtra("Title", titleStrings[position]);
                objIntent.putExtra("Image",intIcon[position]);
                objIntent.putExtra("Index", position);
                startActivity(objIntent);


            }
        });

    } //ListViewController

    private void buttonController() {
        aboutmeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sound effect
                MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.cat);
                buttonMediaPlayer.start();

                //intent to WebView
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setData(Uri.parse("https://youtu.be/0KSOMA3QBU0"));
                startActivity(objIntent);

            }
        });
    }

    private void bindWidget() {
        trafficListView = (ListView) findViewById(R.id.listView);
        aboutmeButton = (Button) findViewById(R.id.button);

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://spcgroup.soirapheesp.mytraffic/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://spcgroup.soirapheesp.mytraffic/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}       // Main Class คลาสหลัก

