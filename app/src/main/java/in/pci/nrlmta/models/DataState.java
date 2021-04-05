package in.pci.nrlmta.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "statedb")
public class DataState {

    @PrimaryKey
    @NonNull
    int id;
    @SerializedName("data_states/TDate")
    private String dataDate;
    @SerializedName("data_states/Level")
    private String dataLevel;
    @SerializedName("data_states/G1/BLOCK")
    private String dataBlock;
    @SerializedName("data_states/G1/STATE")
    private String dataState;
    @SerializedName("data_states/G1/DISTRICT")
    private String dataDistrict;
    @SerializedName("data_states/G3/Q1")
    private String dataQ1;
    @SerializedName("data_states/G3/Q2")
    private Integer dataQ2;
    @SerializedName("data_states/G3/Q3")
    private Integer dataQ3;
    @SerializedName("data_states/G3/Q4")
    private Integer dataQ4;
    @SerializedName("data_states/G3/Q5")
    private Integer dataQ5;

    @Ignore
    public DataState() {
    }

    public DataState(int id, String dataDate, String dataLevel, String dataBlock, String dataState, String dataDistrict, String dataQ1, Integer dataQ2, Integer dataQ3, Integer dataQ4, Integer dataQ5) {
        this.id = id;
        this.dataDate = dataDate;
        this.dataLevel = dataLevel;
        this.dataBlock = dataBlock;
        this.dataState = dataState;
        this.dataDistrict = dataDistrict;
        this.dataQ1 = dataQ1;
        this.dataQ2 = dataQ2;
        this.dataQ3 = dataQ3;
        this.dataQ4 = dataQ4;
        this.dataQ5 = dataQ5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getDataLevel() {
        return dataLevel;
    }

    public void setDataLevel(String dataLevel) {
        this.dataLevel = dataLevel;
    }

    public String getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(String dataBlock) {
        this.dataBlock = dataBlock;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getDataDistrict() {
        return dataDistrict;
    }

    public void setDataDistrict(String dataDistrict) {
        this.dataDistrict = dataDistrict;
    }

    public String getDataQ1() {
        return dataQ1;
    }

    public void setDataQ1(String dataQ1) {
        this.dataQ1 = dataQ1;
    }

    public Integer getDataQ2() {
        return dataQ2;
    }

    public void setDataQ2(Integer dataQ2) {
        this.dataQ2 = dataQ2;
    }

    public Integer getDataQ3() {
        return dataQ3;
    }

    public void setDataQ3(Integer dataQ3) {
        this.dataQ3 = dataQ3;
    }

    public Integer getDataQ4() {
        return dataQ4;
    }

    public void setDataQ4(Integer dataQ4) {
        this.dataQ4 = dataQ4;
    }

    public Integer getDataQ5() {
        return dataQ5;
    }

    public void setDataQ5(Integer dataQ5) {
        this.dataQ5 = dataQ5;
    }
}
