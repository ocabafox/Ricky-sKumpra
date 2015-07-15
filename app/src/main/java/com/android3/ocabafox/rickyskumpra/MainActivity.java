package com.android3.ocabafox.rickyskumpra;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.android3.ocabafox.rickyskumpra.KumpraInput.KumpraPresenter;
import com.android3.ocabafox.rickyskumpra.KumpraInput.KumpraView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements KumpraView {

    @Bind(R.id.AddItem) EditText Addproduct;
    @Bind(R.id.fab) FloatingActionButton fab;

    KumpraPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new KumpraPresenter(this, getApplicationContext());

        setupToolbar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void setupToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.fab)
    public void submit(){
        String input = Addproduct.getText().toString();
        presenter.addItem(input);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void AddListActivity() {
        Toast.makeText(this, "Success!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void InputError() {
        Toast.makeText(this, "Login Invalid: Input Product", Toast.LENGTH_SHORT).show();
    }
}
