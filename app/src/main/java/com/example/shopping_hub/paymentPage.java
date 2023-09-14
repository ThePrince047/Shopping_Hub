package com.example.shopping_hub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class paymentPage extends AppCompatActivity {
    FloatingActionButton fab;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    TextView checkbal;
    CardView managepayment,addpayment,deletepayment;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        Window window=this.getWindow();
        window.setStatusBarColor(getResources().getColor(R.color.blue));
        username=getIntent().getStringExtra("username");
        fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextAppearance(this, R.style.topfont);


        checkbal=findViewById(R.id.checkbalance);
        managepayment=findViewById(R.id.managepayment);
        addpayment=findViewById(R.id.addpayment);
        deletepayment=findViewById(R.id.deletepayment);

        checkbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paymentPage.this, "Current Balance :- 25000", Toast.LENGTH_SHORT).show();
            }
        });

        managepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paymentPage.this, "Can't Process This Time", Toast.LENGTH_SHORT).show();
            }
        });
        addpayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paymentPage.this, "Try Later", Toast.LENGTH_SHORT).show();
            }
        });
        deletepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(paymentPage.this, "This is Default Method", Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.payment_btm);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemid = item.getItemId();
                if (itemid == R.id.home_btm) {
                    Intent i=new Intent(getApplicationContext(), MainActivity.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                if (itemid == R.id.user_btm) {
                    Intent i=new Intent(getApplicationContext(), userPage.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                if (itemid == R.id.payment_btm) {
                    Toast.makeText(getApplicationContext(),"This Page is Running",Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (itemid == R.id.setting_btn) {
                    Intent i=new Intent(getApplicationContext(), settingPage.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    overridePendingTransition(0,0);
                    return true;
                }
                return false;
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(), cartPage.class);
                i.putExtra("username",username);
                startActivity(i);
                overridePendingTransition(0,0);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.not){
            Toast.makeText(getApplicationContext(),"No Notifications",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.updates){
            Toast.makeText(getApplicationContext(),"App is Up-To-Date",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.credit){
            Toast.makeText(getApplicationContext(),"@Created By Prince Solanki",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.support){
            Toast.makeText(getApplicationContext(),"No Comments",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        Intent i=new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("username",username);
        startActivity(i);
        overridePendingTransition(0,0);
    }
}