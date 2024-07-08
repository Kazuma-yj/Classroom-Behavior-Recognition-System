package com.example.dangerbehaviordetect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Zone {
    private int cID;
    private String x1;
    private String y1;
    private String x2;
    private String y2;

    public int getcID() {
        return cID;
    }
}
