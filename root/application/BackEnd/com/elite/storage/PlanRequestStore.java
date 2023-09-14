package com.elite.storage;

import java.util.List;

import com.elite.beans.PlanRequest;
import com.elite.exceptions.PlanAlreadyRequested;

// PlanRequestStore interface and its various methods

public interface PlanRequestStore {
    public List<PlanRequest> getAllUserRequests();
    public void addPlanRequest(PlanRequest planRequest) throws PlanAlreadyRequested;
}
