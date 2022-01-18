package com.example.connector.service.cmd;

import com.example.connector.vo.cmd.ChargerControlVo;
import com.example.connector.vo.cmd.ChillerControlVo;
import com.example.connector.vo.cmd.DeviceRunDataPullVo;
import com.example.connector.vo.cmd.KgControlVo;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Data;

@Data
class DeviceInfoPullServerRequest {}

@Data
class DeviceRunDataPullServerRequest {
    @SerializedName("time")
    Long time;

    public DeviceRunDataPullServerRequest(DeviceRunDataPullVo vo) {
        this.time = vo.getTime();
    }
}

@Data
class KgControlServerRequest {
    @SerializedName("date")
    private String date;

    @SerializedName("times")
    private List<Integer> times;

    @SerializedName("on_off_set")
    private List<Short> onOffSet;

    @SerializedName("p_set")
    private List<Float> pSet;

    @SerializedName("q_set")
    private List<Float> qSet;

    public KgControlServerRequest(KgControlVo vo) {
        this.date = vo.getDate();
        this.times = vo.getTimes();
        this.onOffSet = vo.getOnOffSet();
        this.pSet = vo.getPSet();
        this.qSet = vo.getQSet();
    }
}

@Data
class ChargerControlServerRequest {
    @SerializedName("Date")
    private String date;

    @SerializedName("Times")
    private List<Integer> times;

    @SerializedName("On_off_set")
    private List<Short> onOffSet;

    @SerializedName("Price_set")
    private List<Float> priceSet;

    @SerializedName("Pin_set")
    private List<Float> pinSet;

    @SerializedName("Qin_set")
    private List<Float> qinSet;

    public ChargerControlServerRequest(ChargerControlVo vo) {
        this.date = vo.getDate();
        this.times = vo.getTimes();
        this.onOffSet = vo.getOnOffSet();
        this.priceSet = vo.getPriceSet();
        this.pinSet = vo.getPinSet();
        this.qinSet = vo.getQinSet();
    }
}

@Data
class ChillerControlServerRequest {
    @SerializedName("date")
    private String date;

    @SerializedName("times")
    private List<Integer> times;

    @SerializedName("on_off_set")
    private List<Short> onOffSet;

    @SerializedName("tem_set")
    private List<Float> temSet;

    @SerializedName("p_limit_set")
    private List<Float> pLimitSet;

    public ChillerControlServerRequest(ChillerControlVo vo) {
        this.date = vo.getDate();
        this.times = vo.getTimes();
        this.onOffSet = vo.getOnOffSet();
        this.temSet = vo.getTemSet();
        this.pLimitSet = vo.getPLimitSet();
    }
}
