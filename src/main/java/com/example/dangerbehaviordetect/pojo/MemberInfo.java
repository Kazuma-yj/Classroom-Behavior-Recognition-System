package com.example.dangerbehaviordetect.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo {

    private int uID;
    private String mail;
    private String uName;
    private boolean isOwner;

}
