package com.rabiulkhan.fourinone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    public EditText phoneText;
    public EditText emailText;
    public EditText urlText;
    public EditText messageText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneText = (EditText) findViewById(R.id.editText_phone);
        emailText = (EditText) findViewById(R.id.editText_Email);
        urlText = (EditText) findViewById(R.id.editText_url);
        messageText = (EditText) findViewById(R.id.editText_message);
    }

    public void sendCall(View v){
        String phoneNumber = phoneText.getText().toString();

        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);

    }
    public void sendSms(View v){
        String message = messageText.getText().toString();
        String phoneNumber = phoneText.getText().toString();

        Uri uri = Uri.parse("smsto:" +phoneNumber);
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO,uri);
        smsIntent.putExtra("sms_body",message);
        startActivity(smsIntent);

    }
    public void sendEmail(View v){
        String mail = emailText.getText().toString();

        Uri uri = Uri.parse("mailto:" +mail);
        Intent mailIntent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(mailIntent);

    }
    public void browerOpen(View v){
        String url = urlText.getText().toString();

        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse("http://"+url));
        startActivity(urlIntent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
