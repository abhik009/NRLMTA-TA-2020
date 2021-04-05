package in.pci.nrlmta.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "BlockTableTwo")
public class BlockTwoModel {

    @PrimaryKey
    @NonNull
    int id;
    @SerializedName("data_block/START_DATE")
    private String dataStartDate;
    @SerializedName("data_block/END_DATE")
    private String dataEndDate;
    @SerializedName("data_block/LEVEL")
    private String dataLevel;
    @SerializedName("data_block/STATE")
    private String dataState;
    @SerializedName("data_block/DISTRICT")
    private String dataDistrict;
    @SerializedName("data_block/BLOCK")
    private String dataBlock;
    @SerializedName("data_block/TVILLAGE")
    private Integer dataTotalVillage;
    @SerializedName("data_block/VILLAGE")
    private Integer dataVillage;
    @SerializedName("data_block/TSHG")
    private Integer dataTotalShg;
    @SerializedName("data_block/SHG")
    private Integer dataShg;
    @SerializedName("data_block/G4/Q1A")
    private String dataQ1A;
    @SerializedName("data_block/G4/Q1B")
    private String dataQ1B;
    @SerializedName("data_block/G4/Q1C")
    private Integer dataQ1C;
    @SerializedName("data_block/G4/Q1D")
    private String dataQ1D;
    @SerializedName("data_block/G4/Q1E")
    private Integer dataQ1E;
    @SerializedName("data_block/G4/Q1F")
    private Integer dataQ1F;
    @Ignore
    @SerializedName("data_block/G4/calVal1")
    private Integer dataBlockG4CalVal1;
    @Ignore
    public BlockTwoModel() {
    }

    public BlockTwoModel(int id, String dataStartDate, String dataEndDate, String dataLevel, String dataState, String dataDistrict, String dataBlock, Integer dataTotalVillage, Integer dataVillage, Integer dataTotalShg, Integer dataShg, String dataQ1A, String dataQ1B, Integer dataQ1C, String dataQ1D, Integer dataQ1E, Integer dataQ1F) {
        this.id = id;
        this.dataStartDate = dataStartDate;
        this.dataEndDate = dataEndDate;
        this.dataLevel = dataLevel;
        this.dataState = dataState;
        this.dataDistrict = dataDistrict;
        this.dataBlock = dataBlock;
        this.dataTotalVillage = dataTotalVillage;
        this.dataVillage = dataVillage;
        this.dataTotalShg = dataTotalShg;
        this.dataShg = dataShg;
        this.dataQ1A = dataQ1A;
        this.dataQ1B = dataQ1B;
        this.dataQ1C = dataQ1C;
        this.dataQ1D = dataQ1D;
        this.dataQ1E = dataQ1E;
        this.dataQ1F = dataQ1F;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataStartDate() {
        return dataStartDate;
    }

    public void setDataStartDate(String dataStartDate) {
        this.dataStartDate = dataStartDate;
    }

    public String getDataEndDate() {
        return dataEndDate;
    }

    public void setDataEndDate(String dataEndDate) {
        this.dataEndDate = dataEndDate;
    }

    public String getDataLevel() {
        return dataLevel;
    }

    public void setDataLevel(String dataLevel) {
        this.dataLevel = dataLevel;
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

    public String getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(String dataBlock) {
        this.dataBlock = dataBlock;
    }

    public Integer getDataTotalVillage() {
        return dataTotalVillage;
    }

    public void setDataTotalVillage(Integer dataTotalVillage) {
        this.dataTotalVillage = dataTotalVillage;
    }

    public Integer getDataVillage() {
        return dataVillage;
    }

    public void setDataVillage(Integer dataVillage) {
        this.dataVillage = dataVillage;
    }

    public Integer getDataTotalShg() {
        return dataTotalShg;
    }

    public void setDataTotalShg(Integer dataTotalShg) {
        this.dataTotalShg = dataTotalShg;
    }

    public Integer getDataShg() {
        return dataShg;
    }

    public void setDataShg(Integer dataShg) {
        this.dataShg = dataShg;
    }

    public String getDataQ1A() {
        return dataQ1A;
    }

    public void setDataQ1A(String dataQ1A) {
        this.dataQ1A = dataQ1A;
    }

    public String getDataQ1B() {
        return dataQ1B;
    }

    public void setDataQ1B(String dataQ1B) {
        this.dataQ1B = dataQ1B;
    }

    public Integer getDataQ1C() {
        return dataQ1C;
    }

    public void setDataQ1C(Integer dataQ1C) {
        this.dataQ1C = dataQ1C;
    }

    public String getDataQ1D() {
        return dataQ1D;
    }

    public void setDataQ1D(String dataQ1D) {
        this.dataQ1D = dataQ1D;
    }

    public Integer getDataQ1E() {
        return dataQ1E;
    }

    public void setDataQ1E(Integer dataQ1E) {
        this.dataQ1E = dataQ1E;
    }

    public Integer getDataQ1F() {
        return dataQ1F;
    }

    public void setDataQ1F(Integer dataQ1F) {
        this.dataQ1F = dataQ1F;
    }

    public Integer getDataBlockG4CalVal1() {
        return dataBlockG4CalVal1;
    }

    public void setDataBlockG4CalVal1(Integer dataBlockG4CalVal1) {
        this.dataBlockG4CalVal1 = dataBlockG4CalVal1;
    }
}
