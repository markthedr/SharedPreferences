package markhu.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "last word";
    private static final String KEY_WORD = "KEY_WORD";

    private SharedPreferences mPrefs;
    private EditText mWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrefs = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        mWord = (EditText) findViewById(R.id.etPreference);

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.save_preferences:
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString(KEY_WORD, mWord.getText().toString());
                editor.commit();
                break;
            case R.id.read_preferences:
                Toast.makeText(view.getContext(),mPrefs.getString(KEY_WORD,"No word yet"),Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
