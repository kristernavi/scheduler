/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bisu.report;

import java.util.List;

/**
 *
 * @author ivankrister
 */
public class RoomUtilizationReport {
    private int room_number;
    private List <RoomUtlizationData> roomData;

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public List<RoomUtlizationData> getRoomData() {
        return roomData;
    }

    public void setRoomData(List<RoomUtlizationData> roomData) {
        this.roomData = roomData;
    }
    
    
    
}
