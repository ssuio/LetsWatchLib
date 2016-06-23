/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.model;

import java.sql.SQLException;
import java.util.Calendar;
import lw.domain.LWException;

/**
 *
 * @author adm
 */
public class IdGenerateService {
    
    public String generateDate(){
        Calendar cal = Calendar.getInstance();
        String year = (cal.get(Calendar.YEAR) + "").replaceAll("20", "");
        String month = (((cal.get(Calendar.MONTH)+1)+"").length())==2?(cal.get(Calendar.MONTH)+1)+"":"0"+(cal.get(Calendar.MONTH)+1)+"";
        return year + month;
    }
    
    public String generateMemberId() throws LWException, SQLException{
         IdGenerateDAO dao = new IdGenerateDAO();
         Calendar cal = Calendar.getInstance();
         String date = generateDate();
         int preId = dao.getMemberId() + 1;
         int idLength = (preId + date).length();
         String member = "M" + date;

         for(int i=0; i<8-idLength; i++){
            member += "0";
         }
         dao.updateMemberId(preId);
         return member + preId ;
    }
    
    
    public String generateVisitorId() throws LWException, SQLException{
        IdGenerateDAO dao = new IdGenerateDAO();
        String date = generateDate();
        int preId = dao.getVisitorId() + 1;
        int idLength = (preId + date).length();
        String visitor = "V" + date;
        
        for(int i=0; i<8-idLength; i++){
            visitor += "0";
        }
        
        dao.updateVisitorId(preId);
        return visitor + preId;
    }
    
    public String generateManagerId() throws LWException, SQLException{
        IdGenerateDAO dao = new IdGenerateDAO();
         String date = generateDate();
        int preId = dao.getManagerId() + 1;
        int idLength = (preId + date).length();
        String visitor = "G" + date;
        
        for(int i=0; i<8-idLength; i++){
            visitor += "0";
        }
        
        dao.updateManagerId(preId);
        return visitor + preId;
    }
    
    
    public String generateRoomId() throws LWException, SQLException{
        IdGenerateDAO dao = new IdGenerateDAO();
         String date = generateDate();
        int preId = dao.getRoomId() + 1;
        int idLength = (preId + date).length();
        String room = "R" + date;
        
        for(int i=0; i<8-idLength; i++){
            room += "0";
        }
        
        dao.updateRoomId(preId);
        return room + preId;
    }
    
    
    
    
}



