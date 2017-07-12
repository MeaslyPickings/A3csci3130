package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/** Represents details page for business
 * @author Hugh
 */
public class DetailViewActivity extends Activity {

    private EditText numberField, nameField, typeField, addressField, provTerField;
    Business receivedBusinessInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        typeField = (EditText) findViewById(R.id.type);
        addressField = (EditText) findViewById(R.id.address);
        provTerField = (EditText) findViewById(R.id.provTer);

        if(receivedBusinessInfo != null){
            nameField.setText(receivedBusinessInfo.name);
            numberField.setText(receivedBusinessInfo.number);
            typeField.setText(receivedBusinessInfo.type);
            addressField.setText(receivedBusinessInfo.address);
            provTerField.setText(receivedBusinessInfo.provTer);
        }
    }

    /** Allows update of business through button click
     *
     * @param v UPDATE button
     */
    public void updateBusiness(View v){
        String bid = receivedBusinessInfo.bid;
        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String type = typeField.getText().toString();
        String address = addressField.getText().toString();
        String provTer = provTerField.getText().toString();
        String businessID = receivedBusinessInfo.bid;
        appState.firebaseReference.child(businessID).setValue(
                new Business(bid, number, name, type, address, provTer));

        finish();
    }

    /**
     * Allows deleting business through button click
     * @param v DELETE button
     */
    public void eraseBusiness(View v)
    {
        String businessID = receivedBusinessInfo.bid;
        appState.firebaseReference.child(businessID).removeValue();

        finish();
    }
}
