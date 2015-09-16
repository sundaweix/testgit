package com.example.button_demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.util.EncodingUtils;

import com.example.utils.Constants;
import com.example.utils.MyLog;

import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private Button button1;
	private Button button2;
	private Button button3;
	private static final String DATA = "865863027734974-460004650242632-e547aec94427d068";
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_activity);
		button1=(Button) findViewById(R.id.button1);
		button2=(Button) findViewById(R.id.button2);
		button3=(Button) findViewById(R.id.button3);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);	
		
		context = this;


	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {		
		case R.id.button1:	
			new Thread(){  
				   @Override  
				   public void run()  
				   {    
					    UpDataManager.getInstance(context).StartpostData(context, DATA);
				  }  
				   
				}.start();	
				
			break;
			
       case R.id.button2:
    	   break;
       case R.id.button3:
      
			break;
		
		}
			
		
	}
	
}
