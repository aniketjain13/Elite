package com.elite.storage;

import java.util.List;

import com.elite.beans.Vendor;
import com.elite.exceptions.VendorAlreadyExist;

// VendorStore interface and its various methods

public interface VendorStore {
    public void addVendor(Vendor vendor) throws VendorAlreadyExist;
    public List<Vendor> getAllVendor();
    public Vendor getVendor(String vendorId);
    public void changePassword(String vendorId, String newPassword);
}
