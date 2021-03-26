package ca.yorku.eecs.mack.mainlistviewscroll;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ScrollSetup extends Activity {
    final static String[] SCROLL_METHOD = { "Button Scroll", "Direct Scroll With Physics", "Direct Scroll Without Physics" };
    Spinner spinScrollMethod;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        spinScrollMethod = (Spinner) findViewById(R.id.scrollMethodSpinner);
        ArrayAdapter<CharSequence> adapter1 = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle, SCROLL_METHOD);
        spinScrollMethod.setAdapter(adapter1);
        spinScrollMethod.setSelection(1);
    }

    // called when the "OK" button is tapped
    public void clickOK(View view)
    {
        // get user's choices...
        String userScrollMethod = SCROLL_METHOD[spinScrollMethod.getSelectedItemPosition()];

        // bundle up parameters to pass on to activity
        Bundle b = new Bundle();
        b.putString("userScrollMethod", userScrollMethod);

        // start experiment activity
        Intent i = new Intent(getApplicationContext(), MainListViewActivity.class);
        i.putExtras(b);
        startActivity(i);
    }
}
