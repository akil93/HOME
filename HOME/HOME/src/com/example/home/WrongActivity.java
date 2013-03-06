package com.example.home;



import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class WrongActivity extends Activity implements OnClickListener{
	TextView wrongText;
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wrong);
		b = (Button) findViewById(R.id.button1);
			b.setOnClickListener(this);
		wrongText = (TextView) findViewById(R.id.wrongId);
	
		String wrongValue = getIntent().getExtras().getString("wrongS");
		wrongText.setText(wrongValue);
	}
	@Override
	public void onClick(View v) {
		if(b.isPressed()){
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			
		}
	}
	
}
