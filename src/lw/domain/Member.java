/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.domain;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author adm
 */
public class Member{
    private String id;
    private String name;
    private String email;
    private int status;
    private String pwd;
    private java.util.Date birthday;
    private int wCoin;
    private String phone;
    private char gender;
    private int age;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    private boolean epaper;
    private String introduction;
    private String roomId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 45 && name.length()>=2)
        this.name = name;
    }
    //private String[] buyHistory;
    
    public static final DateFormat birthdayFormat = new SimpleDateFormat("yyyy/M/d");
    public int getAge() {
        int rtn = 0;
        Calendar calendar = Calendar.getInstance();
        int thisYear = calendar.get(Calendar.YEAR);
        if (this.getBirthday() != null) {
            calendar.setTime(this.getBirthday());
            int birthYear = calendar.get(Calendar.YEAR);
            rtn = thisYear - birthYear;
            return rtn;
        }else{
            return 0;
        }
    }

    
    private static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    public Member(){
    super();
    }
    
    public Member(String id, String name){
    this.setId(id);
    this.setName(name);
    }
    
    public Member(String id, String name, String pwd, String email) throws LWException{
    this.setId(id);
    this.setName(name);
    this.setEmail(email);
    this.setPwd(pwd);
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws LWException{
        if (email.matches(EMAIL_PATTERN))
        this.email = email;
        else
            //throw new LWException("密碼須大於6位數，英數至少各1位，具大小寫");
            throw new LWException("信箱不符合格式!");
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPwd() {
        
        return pwd;
    }

    public void setPwd(String pwd) throws LWException{
        if(pwd == null){
            this.pwd = null;
        }else if(pwd.length()>=8 && !(pwd.toLowerCase()==pwd) && !(pwd.toUpperCase()==pwd)){
            this.pwd = pwd;
        }
        else
            throw new LWException("密碼須大於6位數，英數至少各1位，具大小寫");
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) throws LWException {
        if(birthday != null){
            birthday=birthday.replace('-', '/');
         try{
        Date d = birthdayFormat.parse(birthday);
        this.birthday=d;
        }catch(ParseException ex){
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, "日期格是不正確", ex);
            throw new LWException ("生日不正確 " + birthday, ex);
            
        }
        }else{
            this.birthday = null;
        }
    }
    
    public void setBirthday(int y, int m, int d ) throws LWException{
        Date date = new GregorianCalendar(y, m-1, d).getTime();
        this.setBirthday(date);
    }
    
    
    public void setBirthday(java.util.Date birthday) throws LWException {
        if (birthday == null) {
            this.birthday = birthday;
            //return;
        } else if (new Date().after(birthday)) {
            this.birthday = birthday;
        } else {
            //System.err.println("出生日期必須小於今天!");
            throw new LWException("出生日期必須小於今天!");
        }
    }
    
    

    public int getwCoin() {
        return wCoin;
    }

    public void setwCoin(int wCoin) {
        this.wCoin = wCoin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isEpaper() {
        return epaper;
    }

    public void setEpaper(boolean epaper) {
        this.epaper = epaper;
    }

//    public int getPicture() {
//        return picture;
//    }
//
//    public void setPicture(int picture) {
//        this.picture = picture;
//    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String intrudoction) {
        this.introduction = intrudoction;
    }

//    public String getBuyHistory() {
//        return buyHistory[0];
//    }
//
//    public void setBuyHistory(String buyHistory) {
//        this.buyHistory[0] = buyHistory;
//    }

//    public void setBirthday(String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public String toString() {
        return "Member{" + "id=" + id + ", name=" + name + ", email=" + email + ", status=" + status + ", pwd=" + pwd + ", birthday=" + birthday + ", wCoin=" + wCoin + ", phone=" + phone + ", gender=" + gender + ", age=" + age + ", epaper=" + epaper + ", introduction=" + introduction + ", roomId=" + roomId + '}';
    }

    

   

    
    
    
    
}
