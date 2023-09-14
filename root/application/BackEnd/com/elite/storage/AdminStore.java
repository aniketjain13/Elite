package com.elite.storage;

import java.util.List;

import com.elite.beans.Admin;

// AdminStore interface and its various methods

public interface AdminStore {
    public List<Admin> getAdminList();
    public Admin getAdmin(String userName);
}
