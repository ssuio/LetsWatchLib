/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.domain;

/**
 *
 * @author Cyruss
 */
public class PlayList {
    private String videoId;
    private String videoTitle;
    private String videoTime;
    private String videoImg;
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    @Override
    public String toString() {
        return "PlayList{" + "videoId=" + videoId + ", videoTitle=" + videoTitle + ", videoTime=" + videoTime + ", videoImg=" + videoImg + '}';
    }
    
}
