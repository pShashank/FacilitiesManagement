package com.pshashank.facilitiesmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pshashank.facilitiesmanagement.Controllers.UserDatabaseController;
import com.pshashank.facilitiesmanagement.POJO.User;
import com.pshashank.facilitiesmanagement.R;

public class UpdateProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        UserDatabaseController obj = new UserDatabaseController(UpdateProfileActivity.this);

        EditText firstname = findViewById(R.id.firstname);
        EditText lastname = findViewById(R.id.lastname);
        EditText utaid = findViewById(R.id.utaid);
        EditText phone = findViewById(R.id.phone);
        EditText email = findViewById(R.id.email);
        EditText address = findViewById(R.id.address);
        EditText city = findViewById(R.id.city);
        EditText state = findViewById(R.id.state);
        EditText zip = findViewById(R.id.zip);
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        Button update = findViewById(R.id.update);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setFName(firstname.getText().toString());
                user.setLName(lastname.getText().toString());
                user.setUTAID(utaid.getText().toString());
                user.setPhone(phone.getText().toString());
                user.setEmail(email.getText().toString());
                user.setAddress(address.getText().toString());
                user.setCity(city.getText().toString());
                user.setState(state.getText().toString());
                user.setZip(zip.getText().toString());

                SharedPreferences pref = getApplicationContext().getSharedPreferences("UserDetails", MODE_PRIVATE);
                String type = pref.getString("Type", null);
                boolean res = obj.updateUser(password.getText().toString(),user);
                if (res){
                    Intent in = LoginActivity.redirect(UpdateProfileActivity.this, type);
                    startActivity(in);
                }

            }
        });
    }
}
