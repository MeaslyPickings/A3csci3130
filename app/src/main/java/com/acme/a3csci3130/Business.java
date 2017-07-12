package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

/** Represents a business
 * @author Hugh
 */
public class Business implements Serializable {

    public String bid;
    public String number;
    public String name;
    public String type;
    public String address;
    public String provTer;

    public Business() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    /**
     * @param bid unique id for database
     * @param number business phone number
     * @param name business name
     * @param type business type
     * @param address business address
     * @param provTer business location (province/territory)
     */
    public Business(String bid, String number, String name, String type, String address, String provTer){
        this.bid = bid;
        this.number = number;
        this.name = name;
        this.type = type;
        this.address = address;
        this.provTer = provTer;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("bid", bid);
        result.put("number", number);
        result.put("name", name);
        result.put("type", type);
        result.put("address", address);
        result.put("provTer", provTer);

        return result;
    }
}
