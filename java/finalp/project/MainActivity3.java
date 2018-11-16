package finalp.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;


public class MainActivity3 extends Activity {

    private List<Competition> competitions = DataProvider.CompList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        String[] items = getResources().getStringArray(R.array.comps);
        /*ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        items);*/
        CompetitionListAdapter adapter = new CompetitionListAdapter(
                this, R.layout.list_item, competitions);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }

    public void launch(View view){

        Intent myIntent = new Intent(view.getContext(), MainActivity4.class);
        startActivityForResult(myIntent, 0);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity3, menu);
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
