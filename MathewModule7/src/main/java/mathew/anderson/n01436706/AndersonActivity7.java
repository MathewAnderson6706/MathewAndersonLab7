//Mathew Anderson, n01436706
// I think im done
package mathew.anderson.n01436706;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AndersonActivity7 extends AppCompatActivity implements NavigationBarView
.OnItemSelectedListener{

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView
                = findViewById(R.id.mathewBottomNavigationView);

        bottomNavigationView
                .setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.matHome);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.matReal_settings) {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    PersonFragment personFragment = new PersonFragment();
    HomeFragment homeFragment = new HomeFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    MathewFragment mathewFragment = new MathewFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.matHome) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mathewFlFragment, homeFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.matPerson) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mathewFlFragment, personFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.matSettings) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mathewFlFragment, settingsFragment)
                    .commit();
            return true;
        }
        else if (itemId == R.id.matMathew) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mathewFlFragment, mathewFragment)
                    .commit();
            return true;
        }

        return false;
    }
}