package com.elite.storage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elite.beans.Quotation;
import com.elite.exceptions.QuotationAlreadyExist;

// QuotationStore Implementation class to define and initialize its various methods

public class QuotationStoreImpl implements QuotationStore{

    Connection con; //JDBC Connection object to connect with the MySQL data

    public QuotationStoreImpl(){
        con = JDBCConfiguration.createConnection();
    }

    @Override
    public void addQuotation(Quotation quotation) throws QuotationAlreadyExist {
        String insertQuotation = "INSERT INTO quotationdata VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, insertQuotation);
        try{
            stmt.setString(1, quotation.getQuotationId());
            stmt.setString(2, quotation.getPckage());
            stmt.setInt(3, quotation.getEstimatedAmount());
            stmt.setString(4, quotation.getVendorId());
            stmt.setString(5, quotation.getUserId());
            stmt.setString(6, quotation.getPlanRequestId());
            stmt.setString(7, quotation.getStatus());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new QuotationAlreadyExist("This quotation id already exist, please change the credentials.");
        }
    }

    @Override
    public List<Quotation> getAll(String userId) {
        List<Quotation> quotationList = new ArrayList<Quotation>();
        String getAllQuotation = "SELECT * FROM QUOTATIONDATA WHERE userId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, getAllQuotation);
        try{
            stmt.setString(1, userId);
            ResultSet rs = stmt.executeQuery(getAllQuotation);
            while(rs.next()){
                String quotationId = rs.getString(1);
                String pckage = rs.getString(2);
                int estimatedAmount = rs.getInt(3);
                String vendorId = rs.getString(4);
                String planRequestId = rs.getString(6);
                String status = rs.getString(7);
                Date quotationCreationDate = rs.getDate(8);
                quotationList.add(new Quotation(quotationId, pckage, estimatedAmount, vendorId, userId, planRequestId, status, quotationCreationDate));
                
            }
            return quotationList;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void changeQuotationStatus(String quotationId, String newStatus) {
        String updateQuotationStatus = "UPDATE QUOTATIONDATA SET status=? WHERE quotationId=?";
        PreparedStatement stmt = JDBCConfiguration.createPreparedStatement(con, updateQuotationStatus);
        try{
            stmt.setString(1, newStatus);
            stmt.setString(2, quotationId);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
