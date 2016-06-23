/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.domain;

import java.util.List;

/**
 *
 * @author adm
 */
public class Room {
    private String roomId;
    private String ownerId;
    private String roomName;
    private int wCoin;
    private List<String> playList;
    private List<String> roomMemberId;
    private List<String> roomMemerName;
    private String roomPwd;
    private String chatRoomId;
    private List<String> historyList;
    private int playMode;
//    private String keySearch;
//    private List<String> searchList;
    private String videoPlayNow;
    private String videoWhereNow;
    private int roomType;
    private String action;
    private String area;
    private String currentTime;
    private String videoId;

    public int getRoomType() {
        return roomType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public Room(){
        super();
    }
    
    public Room(String RoomId, String ownerId){
        super();
        this.setRoomId(RoomId); 
        this.setOwnerId(ownerId);
        
    }
    
    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String RoomId) {
        this.roomId = RoomId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getwCoin() {
        return wCoin;
    }

    public void setwCoin(int wCoin) {
        this.wCoin = wCoin;
    }

    public List<String> getPlayList() {
        return playList;
    }

    public void setPlayList(List<String> playList) {
        this.playList = playList;
    }

    public List<String> getRoomMemberId() {
        return roomMemberId;
    }

    public void setRoomMemberId(List<String> roomMemberId) {
        this.roomMemberId = roomMemberId;
    }

    public List<String> getRoomMemerName() {
        return roomMemerName;
    }

    public void setRoomMemerName(List<String> roomMemerName) {
        this.roomMemerName = roomMemerName;
    }

    public String getRoomPwd() {
        return roomPwd;
    }

    public void setRoomPwd(String roomPwd) {
        this.roomPwd = roomPwd;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public List<String> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<String> historyList) {
        this.historyList = historyList;
    }

    public int getPlayMode() {
        return playMode;
    }

    public void setPlayMode(int playMode) {
        this.playMode = playMode;
    }

//    public String getKeySearch() {
//        return keySearch;
//    }
//
//    public void setKeySearch(String keySearch) {
//        this.keySearch = keySearch;
//    }
//
//    public List<String> getSearchList() {
//        return searchList;
//    }
//
//    public void setSearchList(List<String> searchList) {
//        this.searchList = searchList;
//    }

    public String getVideoPlayNow() {
        return videoPlayNow;
    }

    public void setVideoPlayNow(String videoPlayNow) {
        this.videoPlayNow = videoPlayNow;
    }

    public String getVideoWhereNow() {
        return videoWhereNow;
    }

    public void setVideoWhereNow(String videoWhereNow) {
        this.videoWhereNow = videoWhereNow;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", ownerId=" + ownerId + ", roomName=" + roomName + ", wCoin=" + wCoin + ", playList=" + playList + ", roomMemberId=" + roomMemberId + ", roomMemerName=" + roomMemerName + ", roomPwd=" + roomPwd + ", chatRoomId=" + chatRoomId + ", historyList=" + historyList + ", playMode=" + playMode + ", videoPlayNow=" + videoPlayNow + ", videoWhereNow=" + videoWhereNow + ", roomType=" + roomType + ", action=" + action + ", area=" + area + ", currentTime=" + currentTime + ", videoId=" + videoId + '}';
    }

    
    
}
