package com.example.dabiantest1;

import util.IpSend;
import MySocket.MyServerSocketListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements OnClickListener{
	private Button exit;
	private Button btnHost;
	private Button btnTeacher;
	private ImageButton help;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		setContentView(R.layout.activity_main);
		exit = (Button) findViewById(R.id.exit);
		btnHost = (Button) findViewById(R.id.btnHost);
		btnTeacher = (Button) findViewById(R.id.btnTeacher);
		help = (ImageButton) findViewById(R.id.help);
		help.setOnClickListener(this);
	    exit.setOnClickListener(this);
		btnHost.setOnClickListener(this);
		btnTeacher.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.exit:
			new AlertDialog.Builder(MainActivity.this).setTitle("确定要退出？").setPositiveButton("是", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			}).setNegativeButton("否", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			}).show();
			break;
		case R.id.btnHost:
			IpSend ipSend = new IpSend();
			ipSend.sendIp();
			Log.i("Main", "--------ip发送成功--------");
			NextDemo(getApplicationContext(), BeginDemo.class);
			break;
		case R.id.btnTeacher:
			NextDemo(getApplicationContext(), JudgeDemo.class);
			break;
		case R.id.help:
			NextDemo(getApplicationContext(), help.class);
			break;
		default:
			break;
		}
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if(keyCode == KeyEvent.KEYCODE_BACK)
		{
		new AlertDialog.Builder(MainActivity.this).setTitle("确定要退出？").setPositiveButton("是", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		}).setNegativeButton("否", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
		}
		return super.onKeyDown(keyCode, event);
	}

	private void NextDemo(Context context, Class<?> classname){
		Intent intent = new Intent(context,classname);
		startActivity(intent);
	}
}
