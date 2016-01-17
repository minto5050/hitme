package in.co.geekninja.hitme;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameFragment fragment=GameFragment.newInstance(5);
        getSupportFragmentManager().beginTransaction().replace(R.id.place_holder,fragment).commit();
    }
}
