package ca.yorku.eecs.mack.mainlistviewscroll;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class MainListViewActivity extends ListActivity
{
    final static String MYDEBUG = "MYDEBUG"; // for Log.i messages
    String scrolMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // make the ListVew the UI for the application
        setContentView(R.layout.list_view_layout);

        //get scroll method form setting
        Intent intentRecieved = getIntent();
        Bundle b = intentRecieved.getExtras();
        scrolMethod = b.getString("userScrollMethod");


        // get the array of words to present in the ListView
        String[] words = getResources().getStringArray(R.array.words);

        // create a word adapter bound to the array of words
        NumberAdapter wa = new NumberAdapter(words);

        // get a reference to the ListView
        ListView lv = (ListView)findViewById(android.R.id.list);

        // give the adapter to the ListView
        lv.setAdapter(wa);
    }
}
