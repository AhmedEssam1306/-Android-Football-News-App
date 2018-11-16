package finalp.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class activity_club_profile extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_club_profile);

        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("6muDU9tdtZ70LcH8ScOxamSkbdjwTBkOlqJ02NVp")
                        .clientKey("D0bNY9lHOaSm5heDMqM42w22CzlajACydKcPNtJd")
                        .server("https://parseapi.back4app.com/") // The trailing slash is important.

                        .build()
        );





        ParseQuery<ParseObject> query = ParseQuery.getQuery("epl");
      //  query.addAscendingOrder("teamName");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for (int i=0; i<objects.size(); ++i) {
                        Log.d("tag", "Team: " + objects.get(i).getInt("ranking") + " " + objects.get(i).getString("teamName") + " " );
                    }
                }
            }
        });

//        ParseAnalytics.trackAppOpenedInBackground(getIntent());
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("epl");
//        query.addAscendingOrder("ranking");
//        query.findInBackground(new FindCallback<ParseObject>()
//        {
//            public void done(List<ParseObject> teamList, ParseException e)
//            {
//                if (e == null)
//                {
//                    Log.d("Teams ", "Retrieved " + teamList.size() + " Teams");
//                }
//                else
//                {
//                    Log.d("Teams", "Error: " + e.getMessage());
//                }
//            }
//        }
//        );

//        ParseObject score = new ParseObject("Score");
//        score.put("User","Amer");
//        score.put("Score","90");
//        score.put("User","Essam");
//        score.put("Score","100");
//        score.saveInBackground();
    }

    public void launchTable(View view){

        Intent myIntent = new Intent(view.getContext(), activity_team_table.class);
        startActivityForResult(myIntent, 0);

    }

    public void launchSquad(View view){
        Intent myIntent = new Intent(view.getContext(), activity_sqaud_table.class);
        startActivityForResult(myIntent, 0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_club_profile, menu);
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
