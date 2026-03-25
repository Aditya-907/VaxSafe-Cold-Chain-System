package com.vaxsafe.model;
import java.time.LocalDate;

// Base abstract class for inventory items
public abstract class InventoryItem {

    protected String batchId;

    protected LocalDate expiryDate;
    // Current lifecycle state
    protected ItemState state;

    public InventoryItem(String batchId, LocalDate expiryDate){
        this.batchId = batchId;
        this.expiryDate = expiryDate;
        this.state = ItemState.IN_STORAGE;
    }

    // Returns Batch identifier
    public String getBatchId(){
        return batchId;
    }

    // Returns expiry date
    public LocalDate getExpiryDate(){
        return expiryDate;
    }

    // expiration check
    public boolean isExpired(){
        return LocalDate.now().isAfter(expiryDate);
    }
    
}
