package com.elite.storage;

import java.util.List;

import com.elite.beans.Quotation;
import com.elite.exceptions.QuotationAlreadyExist;

// QuotationStore interface and its various methods

public interface QuotationStore {
    public void addQuotation(Quotation quotation) throws QuotationAlreadyExist;
    public List<Quotation> getAll(String userId);
    public void changeQuotationStatus(String quotationId, String newStatus);
}
