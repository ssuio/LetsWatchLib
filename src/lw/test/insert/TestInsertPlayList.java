/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lw.test.insert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lw.domain.LWException;
import lw.domain.PlayList;
import lw.model.PlayListDAO;

/**
 *
 * @author Cyruss
 */
public class TestInsertPlayList {
    public static void main(String[] args) {
        String time = "11";
        try {
            PlayListDAO dao = new PlayListDAO();
            List<PlayList> list = new ArrayList<>();
            PlayList p = new PlayList();
            p.setVideoId("videoId");
            p.setVideoTitle("videoTitle");
            p.setVideoTime("videoTime");
            p.setVideoImg("videoImg");
            PlayList p2 = new PlayList();
            p2.setVideoId("videoId2");
            p2.setVideoTitle("videoTitle2");
            p2.setVideoTime("videoTime2");
            p2.setVideoImg("videoImg2");
            PlayList p3 = new PlayList();
            p3.setVideoId("videoId3");
            p3.setVideoTitle("videoTitle3");
            p3.setVideoTime("videoTime3");
            p3.setVideoImg("videoImg3");
            
            list.add(p);
            list.add(p2);
            list.add(p3);
            
            dao.insert(list, "r16060035",time);
            
        } catch (LWException ex) {
            Logger.getLogger(TestInsertPlayList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
