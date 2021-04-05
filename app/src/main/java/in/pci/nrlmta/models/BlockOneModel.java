package in.pci.nrlmta.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "BlockTableOne")

public class BlockOneModel{

    @PrimaryKey
    @NonNull
    private Integer id;
    private String today;
    private String state;
    private String district;
    private String block;
    private String level;
    private Integer village;
    private Integer shg;
    private Integer version;
    private String submissionTime;
    @Ignore
    public BlockOneModel() { }

    public BlockOneModel(@NonNull Integer id, String today, String state, String district, String block, String level, Integer village, Integer shg, Integer version, String submissionTime) {
        this.id = id;
        this.today = today;
        this.state = state;
        this.district = district;
        this.block = block;
        this.level = level;
        this.village = village;
        this.shg = shg;
        this.version = version;
        this.submissionTime = submissionTime;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getVillage() {
        return village;
    }

    public void setVillage(Integer village) {
        this.village = village;
    }

    public Integer getShg() {
        return shg;
    }

    public void setShg(Integer shg) {
        this.shg = shg;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }
}
