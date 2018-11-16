package finalp.project;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class testClass extends Activity {
    ListView lv;
    TableLayout ty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("6muDU9tdtZ70LcH8ScOxamSkbdjwTBkOlqJ02NVp")
                        .clientKey("D0bNY9lHOaSm5heDMqM42w22CzlajACydKcPNtJd")
                        .server("https://parseapi.back4app.com/") // The trailing slash is important.

                        .build()
        );
        lv = (ListView) findViewById(R.id.listView3);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("epl");
        //  query.addAscendingOrder("teamName");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    ArrayList<String> arrayTeam = new ArrayList<String>();
                    ArrayList<String> arrayRank = new ArrayList<String>();
                    for (int i=0; i<objects.size(); ++i) {
                        Log.d("tag", "Team: " + objects.get(i).getInt("ranking") + " " + objects.get(i).getString("teamName") + " ");
                        arrayTeam.add(objects.get(i).getString("teamName"));
                        arrayRank.add(objects.get(i).getString("ranking"));
                    }
                    ArrayAdapter adapter = new ArrayAdapter(testClass.this,android.R.layout.simple_list_item_1,arrayTeam);
                    lv.setAdapter(adapter);
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_class, menu);
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
