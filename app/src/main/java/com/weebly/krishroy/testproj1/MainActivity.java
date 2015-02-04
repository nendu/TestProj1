package com.weebly.krishroy.testproj1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {


        private Button mAddButton;
        private TextView mResultTextView;
        private SeekBar mSeekBar1;
        private SeekBar mSeekBar2;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            mAddButton = (Button)rootView.findViewById(R.id.button);
            mResultTextView = (TextView)rootView.findViewById(R.id.textView);
            mSeekBar1 = (SeekBar)rootView.findViewById(R.id.seekBar1);
            mSeekBar2 = (SeekBar)rootView.findViewById(R.id.seekBar2);

            mAddButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    mResultTextView.setText(String.valueOf(mSeekBar1.getProgress() + mSeekBar2.getProgress()));


                }
            });


            return rootView;
        }
    }
}
