package com.example.home;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity implements OnClickListener{
	TextView user, email, pass, gender;
	String userS, emailS, passS, genS1, genS2;
	String genderS = "";
	Button back;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		back = (Button) findViewById(R.id.button1);
			back.setOnClickListener(this);
		user = (TextView)findViewById(R.id.textView1);
		email = (TextView)findViewById(R.id.textView2);
		pass = (TextView)findViewById(R.id.textView3);
		gender = (TextView)findViewById(R.id.textView4);
		
		userS = getIntent().getExtras().getString("login");
		emailS = getIntent().getExtras().getString("email");
		passS = getIntent().getExtras().getString("password");
		
		genS1 = getIntent().getExtras().getString("male");
		genS2= getIntent().getExtras().getString("female");
		
		if(genS1.equals("Male")){
			genderS = "Male";
		}
		if(genS2.equals("Female")){
			genderS = "Female";
		}
		user.setText(userS);
		email.setText(emailS);
		pass.setText(passS);
		gender.setText(genderS);
	}
	@Override
	public void onClick(View v) {
		if(back.isPressed()){
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
	}
	
	

}
