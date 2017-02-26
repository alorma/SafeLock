package com.alorma.safelock;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  public static final int REQUEST_CODE_CONTACTS = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    findViewById(R.id.selectContact).setOnClickListener(v -> {
      openContactSelector();
    });
  }

  private void openContactSelector() {
    Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
    startActivityForResult(intent, REQUEST_CODE_CONTACTS);
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // TODO Auto-generated method stub
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == REQUEST_CODE_CONTACTS) {
      if (resultCode == RESULT_OK) {
        Uri contactData = data.getData();
        Toast.makeText(this, "" + contactData, Toast.LENGTH_SHORT).show();
      }
    }
  }
}
