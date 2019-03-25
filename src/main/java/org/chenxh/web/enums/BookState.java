package org.chenxh.web.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum BookState {
    Serial(1,"连载"),
    Finish(2,"完结");

    @EnumValue
    private final int state;
    private final String desc;
    private BookState(int state,String desc) {
        this.state = state;
        this.desc = desc;
    }

    public int getState() {
        return state;
    }

    public String getDesc() {
        return desc;
    }

    public static BookState valueOfDesc(String desc){
        if(BookState.Serial.getDesc().equals(desc)){
            return BookState.Serial;
        }else if(BookState.Finish.getDesc().equals(desc)){
            return BookState.Finish;
        }
        return null;
    }
}
