package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/** Allows user to create a business in the database
 * @author Hugh
 */
public class CreateBusinessActivity extends Activity {

    private Button submitButton;
    private EditText numberField, nameField, typeField, addressField, provTerField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        typeField = (EditText) findViewById(R.id.type);
        addressField = (EditText) findViewById(R.id.address);
        provTerField = (EditText) findViewById(R.id.provTer);
    }

    /** Allows user to create business through button click
     *
     * @param v represents CREATE button
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String businessID = appState.firebaseReference.push().getKey();
        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String type = typeField.getText().toString();
        String address = addressField.getText().toString();
        String provTer = provTerField.getText().toString();
        Business business = new Business(businessID, number, name, type, address, provTer);

        appState.firebaseReference.child(businessID).setValue(business);

        finish();

    }
}
