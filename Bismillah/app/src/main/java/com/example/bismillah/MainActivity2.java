package com.example.bismillah;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends Activity {

	EditText edTextPhnOrCrdNmbr, addPhoneNmbr, addCardNmbr, addCustomerName, barOrQrCode;
	Button clearBtn, findBtn, addToMembershipBtn;
	LinearLayout emptyResult, membershipForm;
	ImageView scanner;
	TextView Date, membershipResult;

	@SuppressLint("MissingInflatedId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		edTextPhnOrCrdNmbr = findViewById(R.id.edTextPhnOrCrdNmbr);
		addPhoneNmbr = findViewById(R.id.addPhoneNmbr);
		addCardNmbr = findViewById(R.id.addCardNmbr);
		addCustomerName = findViewById(R.id.addCustomerName);
		barOrQrCode = findViewById(R.id.barOrQrCode);
		clearBtn = findViewById(R.id.clearBtn);
		findBtn = findViewById(R.id.findBtn);
		addToMembershipBtn = findViewById(R.id.addToMembershipBtn);
		membershipResult = findViewById(R.id.membershipResult);
		membershipForm = findViewById(R.id.membershipForm);
		scanner = findViewById(R.id.scanner);

		int test = 10;

		try {

			clearBtn.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) {

					//Toast.makeText(TouchpointmockupsActivity.this, "test", Toast.LENGTH_SHORT).show();

					membershipResult.setVisibility(View.GONE);
					addToMembershipBtn.setVisibility(View.GONE);
					membershipForm.setVisibility(View.GONE);
					edTextPhnOrCrdNmbr.getText().clear();

					//barOrQrCode.equals(barOrQrCode);

					Toast.makeText(MainActivity2.this, "Input Cleared. Enter a phone or card number.", Toast.LENGTH_LONG).show();

				}
			});

			try {

				findBtn.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {

						String sedTextPhnOrCrdNmbr = edTextPhnOrCrdNmbr.getText().toString().trim();

						int iedTextPhnOrCrdNmbr = Integer.parseInt(sedTextPhnOrCrdNmbr);

						if (sedTextPhnOrCrdNmbr.isEmpty()) {

							edTextPhnOrCrdNmbr.setError("enter phone or card number!");

						}

						else {

							if (iedTextPhnOrCrdNmbr == test) {

								membershipResult.setVisibility(View.VISIBLE);
								membershipResult.setText("Add Name,Phn,card etc");
								addToMembershipBtn.setVisibility(View.GONE);
								membershipForm.setVisibility(View.GONE);
								Toast.makeText(MainActivity2.this, "Finding Information...", Toast.LENGTH_SHORT).show();

							} else {

								membershipResult.setVisibility(View.VISIBLE);
								membershipResult.setText("Could not find information!");

								addToMembershipBtn.setVisibility(View.VISIBLE);

								Toast.makeText(MainActivity2.this, "Add to membership", Toast.LENGTH_SHORT).show();

							}

						}

						//Toast.makeText(TouchpointmockupsActivity.this, "test", Toast.LENGTH_SHORT).show();

					}
				});

				addToMembershipBtn.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {

						membershipForm.setVisibility(View.VISIBLE);

					}

				});

			} catch (Exception e) {

			}

		} catch (Exception e) {

			Toast.makeText(MainActivity2.this, "Invalid input. Please enter a phone number or card number",
					Toast.LENGTH_SHORT).show();

		}

	}
}