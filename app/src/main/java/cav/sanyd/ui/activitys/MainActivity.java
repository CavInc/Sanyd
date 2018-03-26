package cav.sanyd.ui.activitys;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import cav.sanyd.R;
import cav.sanyd.data.models.TargetModel;
import cav.sanyd.ui.adapter.MainTargetAdapter;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout mNavigationDrawer;
    private MainTargetAdapter mAdapter;
    private ListView mListView;

    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        mFab = (FloatingActionButton) findViewById(R.id.main_tr_fab);

        mListView = (ListView) findViewById(R.id.main_lv);

        ArrayList<TargetModel> models = new ArrayList<>();
        models.add(new TargetModel(0,"Text","TecT",new Date(),new Date(),0,0,0,0));

        mAdapter = new MainTargetAdapter(this,R.layout.main_item,models);

        mListView.setAdapter(mAdapter);


        setupDrower();
        setupToolBar();
    }

    private void setupDrower() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setCheckedItem(R.id.drawer_main);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        if (mNavigationDrawer.isDrawerOpen(GravityCompat.START)) {
            mNavigationDrawer.closeDrawer(GravityCompat.START);
        } else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            mNavigationDrawer.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.drawer_today:
                intent = new Intent(this,PlanTodayActivity.class);
                startActivity(intent);
                break;
            case R.id.drawer_tomorrow:
                intent = new Intent(this,PlanTomorrowActivity.class);
                startActivity(intent);
                break;
            case R.id.drawer_statistic:
                intent = new Intent(this,StatisticActivity.class);
                startActivity(intent);
                break;
            case R.id.drawer_about:
                intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                break;
        }
        mNavigationDrawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
