package com.example.dangerbehaviordetect.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Playback {

    private int pID;
    private int fps;
    private int cID;
    private String videoUrl;
    private String xlsUrl;
    private LocalDateTime endTime;
    private LocalDateTime startTime;

}
