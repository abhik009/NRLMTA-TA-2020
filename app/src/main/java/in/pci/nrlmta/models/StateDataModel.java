package in.pci.nrlmta.models;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class StateDataModel {
    @SerializedName("LT")
    private String lT;
    @SerializedName("_id")
    private Integer id;
    @SerializedName("date")
    private String date;
    @SerializedName("_tags")
    private List<Object> tags = null;
    @SerializedName("_uuid")
    private String uuid;
    @SerializedName("today")
    private String today;
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
    @SerializedName("StartTime")
    private String startTime;
    @SerializedName("_duration")
    private Double duration;
    @SerializedName("_xform_id")
    private Integer xformId;
    @SerializedName("data_states")
    private List<DataState> dataStates = null;
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
    @SerializedName("meta/deprecatedID")
    private String metaDeprecatedID;

    public StateDataModel() {
    }

    public String getLT() {
        return lT;
    }

    public void setLT(String lT) {
        this.lT = lT;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public List<DataState> getDataStates() {
        return dataStates;
    }

    public void setDataStates(List<DataState> dataStates) {
        this.dataStates = dataStates;
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

    public String getMetaDeprecatedID() {
        return metaDeprecatedID;
    }

    public void setMetaDeprecatedID(String metaDeprecatedID) {
        this.metaDeprecatedID = metaDeprecatedID;
    }
}
