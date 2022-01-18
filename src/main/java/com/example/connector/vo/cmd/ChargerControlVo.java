package com.example.connector.vo.cmd;

import java.util.List;
import lombok.Data;

@Data
public class ChargerControlVo {
    private long clientId;

    private String date;

    private List<Integer> times;

    private List<Short> onOffSet;

    private List<Float> priceSet;

    private List<Float> pinSet;

    private List<Float> qinSet;
}
