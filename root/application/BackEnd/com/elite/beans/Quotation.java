package com.elite.beans;

import java.util.Date;

public class Quotation {

    // Quotation data (class members)
    private String quotationId;
    private String pckage;
    private int estimatedAmount;
    private String vendorId;
    private String userId;
    private String planRequestId;
    private String status;
    Date quotationCreationDate;
    
    // class constructors
    public Quotation(String quotationId, String pckage, int estimatedAmount, String vendorId, String userId, String planRequestId, String status, Date quotationCreationDate) {
        this.quotationId = quotationId;
        this.pckage = pckage;
        this.estimatedAmount = estimatedAmount;
        this.vendorId = vendorId;
        this.userId = userId;
        this.planRequestId = planRequestId;
        this.status = status;
        this.quotationCreationDate = quotationCreationDate;
    }
    public Quotation() {
        this.quotationId = "";
        this.pckage = "";
        this.estimatedAmount = 0;
        this.vendorId = "";
        this.userId = "";
        this.planRequestId = "";
        this.status = "";
        this.quotationCreationDate = new Date();
    }
    
    // class getter setters
    public String getQuotationId() {
        return quotationId;
    }
    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public String getPckage() {
        return pckage;
    }
    public void setPckage(String pckage) {
        this.pckage = pckage;
    }

    public int getEstimatedAmount() {
        return estimatedAmount;
    }
    public void setEstimatedAmount(int estimatedAmount) {
        this.estimatedAmount = estimatedAmount;
    }

    public String getVendorId() {
        return vendorId;
    }
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlanRequestId() {
        return planRequestId;
    }
    public void setPlanRequestId(String planRequestId) {
        this.planRequestId = planRequestId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getQuotationCreationDate() {
        return quotationCreationDate;
    }
    public void setQuotationCreationDate(Date quotationCreationDate) {
        this.quotationCreationDate = quotationCreationDate;
    }
    
    // class to string method
    @Override
    public String toString() {
        return "Quotation [quotationId=" + quotationId + ", pckage=" + pckage + ", estimatedAmount=" + estimatedAmount
                + ", vendorId=" + vendorId + ", userId=" + userId + ", planRequestId=" + planRequestId + ", status="
                + status + ", quotationCreationDate=" + quotationCreationDate + "]";
    }
}
