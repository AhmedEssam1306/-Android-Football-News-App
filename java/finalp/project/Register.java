package finalp.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Mohammed on 07-Dec-16.
 */
public class Register extends Activity {

    EditText ET_NAME, ET_USER_NAME, ET_USER_PASS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        ET_NAME = (EditText) findViewById(R.id.editText3);
        ET_USER_NAME = (EditText) findViewById(R.id.editText4);
        ET_USER_PASS = (EditText) findViewById(R.id.editText5);

    }

}
