package com.example.home;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;



public class MainActivity extends Activity implements android.view.View.OnClickListener, android.widget.RadioGroup.OnCheckedChangeListener{
	EditText login;
	EditText email;
	EditText password;
	EditText password1;
	RadioGroup rg;
	CheckBox ch;
	Button send;
	String male = "", female = "";
	boolean checkB = true, logCh = true, rB = true;
	String logS, emailS, passS, rePassS, errorsS ="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		login = (EditText) findViewById(R.id.editText1);
		email = (EditText) findViewById(R.id.editText2);
		password = (EditText) findViewById(R.id.editText3);
		password1 = (EditText)findViewById(R.id.editText4);
		send = (Button) findViewById(R.id.button1);
			send.setOnClickListener(this);
		rg= (RadioGroup) findViewById(R.id.rg);
			rg.setOnCheckedChangeListener(this);
		ch = (CheckBox) findViewById(R.id.checkBox1);
			ch.setOnClickListener(this);
	}
	
	public void onClick(View v) {
		
		
		if(send.isPressed()){
			logS = login.getText().toString();
			emailS = email.getText().toString();
			passS = password.getText().toString();
			rePassS = password1.getText().toString();
			
			for(int i = 0; i < logS.length(); i++){
				if((logS.charAt(i) >= 'A' && logS.charAt(i) <= 'Z') || (logS.charAt(i) >= '0' && logS.charAt(i) <= '9') || (logS.charAt(i) >= 'a' && logS.charAt(i) <= 'z')){
					logCh = false;
				}
			}
			
			if((!logCh) && (!emailS.equals("")) && (passS.equals(rePassS)) && (!checkB) && (!rB)){
				startActivity(new Intent("com.example.home.SECOND"));

				Bundle bundle = new Bundle();
				bundle.putString("login", logS);
				bundle.putString("email", emailS);
				bundle.putString("password", passS);
				bundle.putString("male", male);
				bundle.putString("female", female);
				Intent i = new Intent(this, SecondActivity.class);
				i.putExtras(bundle);
				startActivityForResult(i, 0);
			}
			
			if(logCh){
				wrongFunction("Username must contain a-zA-Z0-9, return previous page and rewrite login field.");
			}
			
			if(emailS.equals("")){
				wrongFunction("Email field is empty, return previous page and rewrite email field.");
			}
			
			if(!passS.equals(rePassS)){
				wrongFunction("Passwords are not same, return previous page and rewrite password fields.");
			}
			if(rB){
				wrongFunction("You didnt select gender, return previous page and select gender button.");
			}
			if(checkB){
				wrongFunction("You didnt choose check box, return previous page and select check box.");
			}
		}
		if(ch.isChecked()){
			checkB = false;
		}
		
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch(checkedId){
		case R.id.radioButton1:
			male = "Male";
			rB = false;
			break;
		case R.id.radioButton2:
			female = "Female";
			rB = false;
			break;

		}
	}
	
	public boolean wrongFunction(String wrongS){
		errorsS = errorsS + "\n\n" + wrongS;
		startActivity(new Intent("com.example.home.WRONG"));
		Bundle b = new Bundle();
		b.putString("wrongS", errorsS);
		
		Intent intent = new Intent(this, WrongActivity.class);
		intent.putExtras(b);
		startActivityForResult(intent, 0);
		return true;
	}

}
