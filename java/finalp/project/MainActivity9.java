package finalp.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;


public class MainActivity9 extends Activity {

    TableLayout tb;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8,tv9,tv10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity9);


        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("6muDU9tdtZ70LcH8ScOxamSkbdjwTBkOlqJ02NVp")
                        .clientKey("D0bNY9lHOaSm5heDMqM42w22CzlajACydKcPNtJd")
                        .server("https://parseapi.back4app.com/") // The trailing slash is important.

                        .build()
        );

        tb = (TableLayout) findViewById(R.id.ligue1Table);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("ligue1");

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    // ArrayList<String> arrayTeam = new ArrayList<String>();
                    for (int i=0; i<objects.size(); ++i) {
                        Log.d("tag", "Team: " + objects.get(i).getString("ranking") + " " + objects.get(i).getString("teamName") + " ");
                        // arrayTeam.add(objects.get(i).getString("teamName"));
                        //tv1.setText(arrayTeam.get(i));
                        TableRow.LayoutParams ip = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                        TableRow row = new TableRow(getApplicationContext());
                        TableRow row1 = new TableRow(getApplicationContext());

                        row.setLayoutParams(ip);
                        row1.setLayoutParams(ip);

                        tv1 = new TextView(getApplicationContext());
                        tv2 = new TextView(getApplicationContext());
                        tv3 = new TextView(getApplicationContext());
                        tv4 = new TextView(getApplicationContext());
                        tv5 = new TextView(getApplicationContext());
                        tv6 = new TextView(getApplicationContext());
                        tv7 = new TextView(getApplicationContext());
                        tv8 = new TextView(getApplicationContext());
                        tv9 = new TextView(getApplicationContext());
                        tv10 = new TextView(getApplicationContext());

                        tv1.setTextColor(0xFF000000);
                        tv2.setTextColor(0xFF000000);
                        tv3.setTextColor(0xFF000000);
                        tv4.setTextColor(0xFF000000);
                        tv5.setTextColor(0xFF000000);
                        tv6.setTextColor(0xFF000000);
                        tv7.setTextColor(0xFF000000);
                        tv8.setTextColor(0xFF000000);
                        tv9.setTextColor(0xFF000000);

                        tv1.setText(objects.get(i).getString("ranking") + "\t");
                        tv2.setText(objects.get(i).getString("teamName") + "\t");
                        tv3.setText(objects.get(i).getString("matchesPl") + "\t");
                        tv4.setText(objects.get(i).getString("matchesW") + "\t");
                        tv5.setText(objects.get(i).getString("matchesD") + "\t");
                        tv6.setText(objects.get(i).getString("matchesL") + "\t");
                        tv7.setText(objects.get(i).getString("goalsFor") + "\t");
                        tv8.setText(objects.get(i).getString("goalsCon") + "\t");
                        tv9.setText(objects.get(i).getString("points") + "\t");
                        tv10.setText(" /t ");

                        row.addView(tv1);
                        row.addView(tv2);
                        row.addView(tv3);
                        row.addView(tv4);
                        row.addView(tv5);
                        row.addView(tv6);
                        row.addView(tv7);
                        row.addView(tv8);
                        row.addView(tv9);
                        row1.addView(tv10);

                        tb.addView(row,i+(i+1));
                        tb.addView(row1,i+(i+2));

                    }
                }
            }
        });




    }

    public void TEST(View view){
        Intent myIntent = new Intent(view.getContext(), activity_club_profile.class);
        startActivityForResult(myIntent, 0);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity9, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
