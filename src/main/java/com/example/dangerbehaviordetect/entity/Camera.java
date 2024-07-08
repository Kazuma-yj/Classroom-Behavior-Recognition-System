package com.example.dangerbehaviordetect.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camera {

    private String addr;
    private String content;
    private int ownerID;
    private int cID;
    private String flush;
    private String axis;
    private String ip;
    private String zone;

}
