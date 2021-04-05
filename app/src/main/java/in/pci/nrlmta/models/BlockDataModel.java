
package in.pci.nrlmta.models;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BlockDataModel {
    @SerializedName("TV")
    private String tV;
    @SerializedName("TSH")
    private String tSH;
    @SerializedName("_id")
    private Integer id;
    @SerializedName("G1/B1")
    private String g1B1;
    @SerializedName("G1/D1")
    private String g1D1;
    @SerializedName("G1/LT")
    private String g1LT;
    @SerializedName("G1/S1")
    private String g1S1;
    @SerializedName("G2/V1")
    private Integer g2V1;
    @SerializedName("_tags")
    private List<Object> tags = null;
    @SerializedName("_uuid")
    private String uuid;
    @SerializedName("today")
    private String today;
    @SerializedName("value")
    private String value;
    @SerializedName("G2/SH1")
    private Integer g2SH1;
    @SerializedName("_notes")
    private List<Object> notes = null;
    @SerializedName("EndTime")
    private String endTime;
    @SerializedName("_edited")
    private Boolean edited;
    @SerializedName("_status")
    private String status;
    @SerializedName("_version")
    private String version;
    @SerializedName("Gdate/TED")
    private String gdateTED;
    @SerializedName("Gdate/TSD")
    private String gdateTSD;
    @SerializedName("StartTime")
    private String startTime;
    @SerializedName("_duration")
    private Double duration;
    @SerializedName("_xform_id")
    private Integer xformId;
    @SerializedName("data_block")
    private List<BlockTwoModel> dataBlock = null;
    @SerializedName("_attachments")
    private List<Object> attachments = null;
    @SerializedName("_geolocation")
    private List<Object> geolocation = null;
    @SerializedName("_media_count")
    private Integer mediaCount;
    @SerializedName("_total_media")
    private Integer totalMedia;
    @SerializedName("formhub/uuid")
    private String formhubUuid;
    @SerializedName("_submitted_by")
    private Object submittedBy;
    @SerializedName("meta/instanceID")
    private String metaInstanceID;
    @SerializedName("_submission_time")
    private String submissionTime;
    @SerializedName("_xform_id_string")
    private String xformIdString;
    @SerializedName("_bamboo_dataset_id")
    private String bambooDatasetId;
    @SerializedName("_media_all_received")
    private Boolean mediaAllReceived;
    @SerializedName("TD")
    private String tD;
    @SerializedName("_last_edited")
    private String lastEdited;
    @SerializedName("meta/deprecatedID")
    private String metaDeprecatedID;

    public BlockDataModel() {
    }

    public String gettV() {
        return tV;
    }

    public void settV(String tV) {
        this.tV = tV;
    }

    public String gettSH() {
        return tSH;
    }

    public void settSH(String tSH) {
        this.tSH = tSH;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getG1B1() {
        return g1B1;
    }

    public void setG1B1(String g1B1) {
        this.g1B1 = g1B1;
    }

    public String getG1D1() {
        return g1D1;
    }

    public void setG1D1(String g1D1) {
        this.g1D1 = g1D1;
    }

    public String getG1LT() {
        return g1LT;
    }

    public void setG1LT(String g1LT) {
        this.g1LT = g1LT;
    }

    public String getG1S1() {
        return g1S1;
    }

    public void setG1S1(String g1S1) {
        this.g1S1 = g1S1;
    }

    public Integer getG2V1() {
        return g2V1;
    }

    public void setG2V1(Integer g2V1) {
        this.g2V1 = g2V1;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getG2SH1() {
        return g2SH1;
    }

    public void setG2SH1(Integer g2SH1) {
        this.g2SH1 = g2SH1;
    }

    public List<Object> getNotes() {
        return notes;
    }

    public void setNotes(List<Object> notes) {
        this.notes = notes;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getEdited() {
        return edited;
    }

    public void setEdited(Boolean edited) {
        this.edited = edited;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGdateTED() {
        return gdateTED;
    }

    public void setGdateTED(String gdateTED) {
        this.gdateTED = gdateTED;
    }

    public String getGdateTSD() {
        return gdateTSD;
    }

    public void setGdateTSD(String gdateTSD) {
        this.gdateTSD = gdateTSD;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getXformId() {
        return xformId;
    }

    public void setXformId(Integer xformId) {
        this.xformId = xformId;
    }

    public List<BlockTwoModel> getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(List<BlockTwoModel> dataBlock) {
        this.dataBlock = dataBlock;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public List<Object> getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(List<Object> geolocation) {
        this.geolocation = geolocation;
    }

    public Integer getMediaCount() {
        return mediaCount;
    }

    public void setMediaCount(Integer mediaCount) {
        this.mediaCount = mediaCount;
    }

    public Integer getTotalMedia() {
        return totalMedia;
    }

    public void setTotalMedia(Integer totalMedia) {
        this.totalMedia = totalMedia;
    }

    public String getFormhubUuid() {
        return formhubUuid;
    }

    public void setFormhubUuid(String formhubUuid) {
        this.formhubUuid = formhubUuid;
    }

    public Object getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Object submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getMetaInstanceID() {
        return metaInstanceID;
    }

    public void setMetaInstanceID(String metaInstanceID) {
        this.metaInstanceID = metaInstanceID;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }

    public String getXformIdString() {
        return xformIdString;
    }

    public void setXformIdString(String xformIdString) {
        this.xformIdString = xformIdString;
    }

    public String getBambooDatasetId() {
        return bambooDatasetId;
    }

    public void setBambooDatasetId(String bambooDatasetId) {
        this.bambooDatasetId = bambooDatasetId;
    }

    public Boolean getMediaAllReceived() {
        return mediaAllReceived;
    }

    public void setMediaAllReceived(Boolean mediaAllReceived) {
        this.mediaAllReceived = mediaAllReceived;
    }

    public String gettD() {
        return tD;
    }

    public void settD(String tD) {
        this.tD = tD;
    }

    public String getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(String lastEdited) {
        this.lastEdited = lastEdited;
    }

    public String getMetaDeprecatedID() {
        return metaDeprecatedID;
    }

    public void setMetaDeprecatedID(String metaDeprecatedID) {
        this.metaDeprecatedID = metaDeprecatedID;
    }
}
