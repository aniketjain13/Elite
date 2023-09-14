package com.elite.storage;

import com.elite.beans.Package;
import com.elite.exceptions.PackageAlreadyExist;

// PackageStore interface and its various methods

public interface PackageStore {
    public void addPackage(Package pckage) throws PackageAlreadyExist;
}
