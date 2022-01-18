package com.example.connector.service.cmd;

import com.example.connector.bo.charger.ChargerDeviceInfoBo;
import com.example.connector.bo.charger.ChargerRunElectricityDataBo;
import com.example.connector.bo.charger.ChargerRunEnergyDataBo;
import com.example.connector.bo.charger.ChargerRunOtherDataBo;
import com.example.connector.bo.charger.ChargerRunPowerDataBo;
import com.example.connector.bo.charger.ChargerRunStateDataBo;
import com.example.connector.bo.chiller.ChillerDeviceInfoBo;
import com.example.connector.bo.chiller.ChillerRunDataBo;
import com.example.connector.bo.chiller.ChillerRunPowerDataBo;
import com.example.connector.bo.chiller.ChillerRunStateDataBo;
import com.example.connector.bo.gw.GwDeviceInfoBo;
import com.example.connector.bo.kg.KgDeviceInfoBo;
import com.example.connector.bo.kg.KgRunElectricityDataBo;
import com.example.connector.bo.kg.KgRunOtherDataBo;
import com.example.connector.bo.kg.KgRunPowerDataBo;
import com.example.connector.bo.kg.KgRunStateDataBo;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
class ChargerInfoUpdateClientRequest {
    @SerializedName("zd_fcode")
    private Short zdFcode;

    @SerializedName("cd_fcode")
    private Short cdFcode;

    @SerializedName("cd_pid")
    private String cdPid;

    @SerializedName("out_cnt")
    private Short outCnt;

    @SerializedName("phase_cnt")
    private Short phaseCnt;

    @SerializedName("in_ue")
    private Float inUe;

    @SerializedName("in_ie")
    private Float inIe;

    @SerializedName("in_power")
    private Float inPower;

    @SerializedName("out_ue")
    private Float outUe;

    @SerializedName("out_ie")
    private Float outIe;

    @SerializedName("out_power")
    private Float outPower;

    @SerializedName("data_point")
    private Integer dataPoint;

    public ChargerDeviceInfoBo getBo(long id) {
        return new ChargerDeviceInfoBo(
                id, zdFcode, cdFcode, cdPid, outCnt, phaseCnt, inUe, inIe, inPower, outUe, outIe,
                outPower, dataPoint);
    }
}

@Data
class KgInfoUpdateClientRequest {
    @SerializedName("zd_fcode")
    private Short zdFcode;

    @SerializedName("kg_type")
    private String kgType;

    @SerializedName("phase_cnt")
    private Short phaseCnt;

    @SerializedName("ue")
    private Float ue;

    @SerializedName("umax")
    private Float umax;

    @SerializedName("ie")
    private Float ie;

    @SerializedName("imax")
    private Float imax;

    @SerializedName("data_point")
    private Integer dataPoint;

    public KgDeviceInfoBo getBo(long id) {
        return new KgDeviceInfoBo(id, zdFcode, kgType, phaseCnt, ue, umax, ie, imax, dataPoint);
    }
}

@Data
class ChillerInfoUpdateClientRequest {
    @SerializedName("kt_fcode")
    private Short ktFcode;

    @SerializedName("kt_pid")
    private String ktPid;

    @SerializedName("cap_cool")
    private Float capCool;

    @SerializedName("cap_heat")
    private Float capHeat;

    @SerializedName("i_start")
    private Float iStart;

    @SerializedName("i_max")
    private Float iMax;

    @SerializedName("i_min")
    private Float iMin;

    @SerializedName("i_break")
    private Float iBreak;

    @SerializedName("u_in")
    private Float uIn;

    @SerializedName("phase_cnt")
    private Short phaseCnt;

    @SerializedName("data_point")
    private Integer dataPoint;

    public ChillerDeviceInfoBo getBo(long id) {
        return new ChillerDeviceInfoBo(
                id, ktFcode, ktPid, capCool, capHeat, iStart, iMax, iMin, iBreak, uIn, phaseCnt,
                dataPoint);
    }
}

@Data
class GwInfoUpdateClientRequest {
    @SerializedName("gw_fcode")
    private Short gwFcode;

    @SerializedName("gen_cnt")
    private Integer genCnt;

    @SerializedName("gen_kw")
    private Float genKw;

    @SerializedName("load_cnt")
    private Integer loadCnt;

    @SerializedName("load_kw")
    private Float loadKw;

    @SerializedName("storage_cnt")
    private Integer storageCnt;

    @SerializedName("storage_kw")
    private Float storageKw;

    @SerializedName("charger_cnt")
    private Integer chargerCnt;

    @SerializedName("charger_kw")
    private Float chargerKw;

    @SerializedName("data_point")
    private Integer dataPoint;

    public GwDeviceInfoBo getBo(long id) {
        return new GwDeviceInfoBo(
                id,
                gwFcode,
                genCnt,
                genKw,
                loadCnt,
                loadKw,
                storageCnt,
                storageKw,
                chargerCnt,
                chargerKw,
                dataPoint);
    }
}

@Data
class KgRunDataUploadClientRequest {
    @SerializedName("p_rt")
    private Float pRt;

    @SerializedName("q_rt")
    private Float qRt;

    @SerializedName("fre_rt")
    private Float freRt;

    @SerializedName("factor")
    private Float factor;

    @SerializedName("ua")
    private Integer ua;

    @SerializedName("ub")
    private Integer ub;

    @SerializedName("uc")
    private Integer uc;

    @SerializedName("uo")
    private Integer uo;

    @SerializedName("ia")
    private Integer ia;

    @SerializedName("ib")
    private Integer ib;

    @SerializedName("ic")
    private Integer ic;

    @SerializedName("io")
    private Integer io;

    @SerializedName("uab")
    private Integer uab;

    @SerializedName("ubc")
    private Integer ubc;

    @SerializedName("uca")
    private Integer uca;

    @SerializedName("ua_thd")
    private Float uaThd;

    @SerializedName("ub_thd")
    private Float ubThd;

    @SerializedName("uc_thd")
    private Float ucThd;

    @SerializedName("ia_thd")
    private Float iaThd;

    @SerializedName("ib_thd")
    private Float ibThd;

    @SerializedName("ic_thd")
    private Float icThd;

    @SerializedName("pwatt")
    private Float pwatt;

    @SerializedName("qwatt")
    private Float qwatt;

    @SerializedName("kg_state")
    private Short kgState;

    @SerializedName("kg_msg")
    private String kgMsg;

    @SerializedName("zd_state")
    private Short zdState;

    @SerializedName("zd_msg")
    private String zdMsg;

    public KgRunElectricityDataBo getElectricityBo(long id, long time) {
        return new KgRunElectricityDataBo(id, time, pwatt, qwatt);
    }

    public KgRunOtherDataBo getOtherBo(long id, long time) {
        return new KgRunOtherDataBo(
                id, time, freRt, factor, ua, ub, uc, uo, ia, ib, ic, io, uab, ubc, uca, uaThd,
                ubThd, ucThd, iaThd, ibThd, icThd);
    }

    public KgRunPowerDataBo getPowerBo(long id, long time) {
        return new KgRunPowerDataBo(id, time, pRt, qRt);
    }

    public KgRunStateDataBo getStateBo(long id, long time) {
        return new KgRunStateDataBo(id, time, kgState, kgMsg, zdState, zdMsg);
    }
}

@Data
class ChargerRunDataUploadClientRequest {
    @SerializedName("pin_rt")
    private Float pinRt;

    @SerializedName("qin_rt")
    private Float qinRt;

    @SerializedName("factor")
    private Float factor;

    @SerializedName("ua")
    private Float ua;

    @SerializedName("ub")
    private Float ub;

    @SerializedName("uc")
    private Float uc;

    @SerializedName("uo")
    private Float uo;

    @SerializedName("ia")
    private Float ia;

    @SerializedName("ib")
    private Float ib;

    @SerializedName("ic")
    private Float ic;

    @SerializedName("io")
    private Float io;

    @SerializedName("uab")
    private Float uab;

    @SerializedName("ubc")
    private Float ubc;

    @SerializedName("uca")
    private Float uca;

    @SerializedName("ua_thd")
    private Float uaThd;

    @SerializedName("ub_thd")
    private Float ubThd;

    @SerializedName("uc_thd")
    private Float ucThd;

    @SerializedName("ia_thd")
    private Float iaThd;

    @SerializedName("ib_thd")
    private Float ibThd;

    @SerializedName("ic_thd")
    private Float icThd;

    @SerializedName("pwatt_in")
    private Float pwattIn;

    @SerializedName("qwatt_in")
    private Float qwattIn;

    @SerializedName("cd_state")
    private Short cdState;

    @SerializedName("cd_msg")
    private String cdMsg;

    @SerializedName("zd_state")
    private Short zdState;

    @SerializedName("zd_msg")
    private String zdMsg;

    @SerializedName("cd_flag_1")
    private Short cdFlag1;

    @SerializedName("cd_flag_2")
    private Short cdFlag2;

    @SerializedName("cd_flag_3")
    private Short cdFlag3;

    @SerializedName("cd_flag_4")
    private Short cdFlag4;

    public ChargerRunEnergyDataBo getEnergyBo(long id, long time) {
        return new ChargerRunEnergyDataBo(id, time, pwattIn, qwattIn);
    }

    public ChargerRunOtherDataBo getOtherBo(long id, long time) {
        return new ChargerRunOtherDataBo(
                id, time, factor, ua, ub, uc, uo, ia, ib, ic, io, uab, ubc, uca, uaThd, ubThd,
                ucThd, iaThd, ibThd, icThd);
    }

    public ChargerRunPowerDataBo getPowerBo(long id, long time) {
        return new ChargerRunPowerDataBo(id, time, pinRt, qinRt);
    }

    public ChargerRunStateDataBo getStateBo(long id, long time) {
        return new ChargerRunStateDataBo(
                id, time, cdState, cdMsg, zdState, zdMsg, cdFlag1, cdFlag2, cdFlag3, cdFlag4);
    }
}

@Data
class ChillerRunDataUploadClientRequest {
    @SerializedName("p_rt")
    private Float pRt;

    @SerializedName("q_rt")
    private Float qRt;

    @SerializedName("pwatt")
    private Float pwatt;

    @SerializedName("qwatt")
    private Float qwatt;

    @SerializedName("ch_in_t")
    private Float chInT;

    @SerializedName("ch_out_t")
    private Float chOutT;

    @SerializedName("co_in_t")
    private Float coInT;

    @SerializedName("co_out_t")
    private Float coOutT;

    @SerializedName("eva_t")
    private Float evaT;

    @SerializedName("con_t")
    private Float conT;

    @SerializedName("eva_p")
    private Float evaP;

    @SerializedName("con_p")
    private Float conP;

    @SerializedName("kt_state")
    private Short ktState;

    @SerializedName("kt_msg")
    private String ktMsg;

    @SerializedName("zd_state")
    private Short zdState;

    @SerializedName("zd_msg")
    private String zdMsg;

    @SerializedName("local_state")
    private Short localState;

    @SerializedName("ref_status")
    private Short refStatus;

    @SerializedName("eva_state")
    private Short evaState;

    @SerializedName("con_state")
    private Short conState;

    @SerializedName("com_starts_cnt")
    private Integer comStartsCnt;

    @SerializedName("run_time")
    private Long runTime;

    public ChillerRunDataBo getOtherBo(long id, long time) {
        return new ChillerRunDataBo(
                id, time, pwatt, qwatt, chInT, chOutT, coInT, coOutT, evaT, conT, evaP, conP);
    }

    public ChillerRunPowerDataBo getPowerBo(long id, long time) {
        return new ChillerRunPowerDataBo(id, time, pRt, qRt);
    }

    public ChillerRunStateDataBo getStateBo(long id, long time) {
        return new ChillerRunStateDataBo(
                id,
                time,
                ktState,
                ktMsg,
                zdState,
                zdMsg,
                localState,
                refStatus,
                evaState,
                conState,
                comStartsCnt,
                runTime);
    }
}

@Data
class ChargerTransactionInfoClientRequest {
    @SerializedName("Start_time")
    private Long startTime;

    @SerializedName("PWatt_1")
    private Float pwatt1;

    @SerializedName("PWatt_2")
    private Float pwatt2;

    @SerializedName("PWatt_3")
    private Float pwatt3;

    @SerializedName("PWatt_4")
    private Float pwatt4;

    @SerializedName("Income_1")
    private Float income1;

    @SerializedName("Income_2")
    private Float income2;

    @SerializedName("Income_3")
    private Float income3;

    @SerializedName("Income_4")
    private Float income4;

    public ChargerRunElectricityDataBo getElectricityBo(long id, long time) {
        return new ChargerRunElectricityDataBo(
                id, time, startTime, pwatt1, pwatt2, pwatt3, pwatt4, income1, income2, income3,
                income4);
    }
}
