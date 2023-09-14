package com.elite.service;

import java.util.Date;
import java.util.List;

import com.elite.beans.Package;
import com.elite.beans.PlanRequest;
import com.elite.beans.Quotation;
import com.elite.beans.Vendor;
import com.elite.exceptions.IncorrectPassword;
import com.elite.exceptions.PackageAlreadyExist;
import com.elite.exceptions.QuotationAlreadyExist;
import com.elite.exceptions.VendorNotFoundException;
import com.elite.storage.PackageStore;
import com.elite.storage.PackageStoreImpl;
import com.elite.storage.PlanRequestStore;
import com.elite.storage.PlanRequestStoreImpl;
import com.elite.storage.QuotationStore;
import com.elite.storage.QuotationStoreImpl;
import com.elite.storage.VendorStore;
import com.elite.storage.VendorStoreImpl;
import com.elite.webpage.vendorpages.VendorHomePage;

// VendorService class and its various methods

public class VendorService {
    
    // method to check the vendor validity
    public VendorHomePage isValidVendor(Vendor vendorSample) throws VendorNotFoundException {
        VendorStore vendorStore = new VendorStoreImpl();
        
        Vendor vendor = vendorStore.getVendor(vendorSample.getVendorId());
        if(vendor.getPassword().equals(vendorSample.getPassword())){
            return new VendorHomePage(vendor);
        }
        else{
            throw new VendorNotFoundException("Incorrect Login Credentials.");
        }
    }

    // method to add package
    public String addPackage(Package pckage){
        PackageStore packageStore = new PackageStoreImpl();

        try {
            packageStore.addPackage(pckage);
            return "Package added Success:400";
        } catch (PackageAlreadyExist e) {
            return e.getMessage();
        }
    }

    // method to view user request list
    public List<PlanRequest> viewUserRequestsList(){

        PlanRequestStore planRequestStore = new PlanRequestStoreImpl();

        return planRequestStore.getAllUserRequests();

    }

    // method to create quotation
    public String createQuotation(Quotation quotation){

        Date currentDate = new Date();
        if(quotation.getQuotationCreationDate().compareTo(currentDate) >= 0){
            return "Quotation creationg date should not be greater than current date.";
        }

        QuotationStore quotationStore = new QuotationStoreImpl();

        try{
            quotationStore.addQuotation(quotation);
            return "Quotation created Success:400";
        }
        catch (QuotationAlreadyExist e){
            return e.getMessage();
        }
    }

    // method to change the vendor password
    public String changePassword(String vendorId, String currentPasssword, String newPassword) throws IncorrectPassword{

        VendorStore vendorStore = new VendorStoreImpl();

        Vendor vendor = vendorStore.getVendor(vendorId);
        if(vendor.getPassword().equals(currentPasssword)){
            vendorStore.changePassword(vendorId, newPassword);
            return "Password Changed Success:400";
        }
        else{
            throw new IncorrectPassword("The entered password doesn't match the current password, please enter the correct password.");
        }
    }
}
