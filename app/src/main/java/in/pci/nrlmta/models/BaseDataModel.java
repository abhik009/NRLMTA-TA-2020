
package in.pci.nrlmta.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "basedata")
public class BaseDataModel {

    @PrimaryKey()
    @NonNull
    @SerializedName("_id")
    private Integer id;
    @SerializedName("state")
    private String state;
    @SerializedName("district")
    private String district;
    @SerializedName("block")
    private String block;
    @SerializedName("totalVillage")
    private Integer totalVillage;
    @SerializedName("shgCount")
    private Integer totalShg;
    @SerializedName("totalMembers")
    private Integer totalMembers;
    @SerializedName("_version")
    private String version;

    @Ignore
    @SerializedName("_tags")
    private List<Object> tags = null;
    @Ignore
    @SerializedName("_uuid")
    private String uuid;
    @Ignore
    @SerializedName("_notes")
    private List<Object> notes = null;
    @Ignore
    @SerializedName("_edited")
    private Boolean edited;
    @Ignore
    @SerializedName("_status")
    private String status;
    @Ignore
    @SerializedName("_duration")
    private String duration;
    @Ignore
    @SerializedName("_xform_id")
    private Integer xformId;
    @Ignore
    @SerializedName("_attachments")
    private List<Object> attachments = null;
    @Ignore
    @SerializedName("_geolocation")
    private List<Object> geolocation = null;
    @Ignore
    @SerializedName("_media_count")
    private Integer mediaCount;
    @Ignore
    @SerializedName("_total_media")
    private Integer totalMedia;
    @Ignore
    @SerializedName("formhub/uuid")
    private String formhubUuid;
    @Ignore
    @SerializedName("_submitted_by")
    private Object submittedBy;
    @Ignore
    @SerializedName("meta/instanceID")
    private String metaInstanceID;
    @Ignore
    @SerializedName("_submission_time")
    private String submissionTime;
    @Ignore
    @SerializedName("_xform_id_string")
    private String xformIdString;
    @Ignore
    @SerializedName("_bamboo_dataset_id")
    private String bambooDatasetId;
    @Ignore
    @SerializedName("_media_all_received")
    private Boolean mediaAllReceived;

    @Ignore
    public BaseDataModel() {
    }

    public BaseDataModel(@NonNull Integer id, String state, String district, String block, Integer totalVillage, Integer totalShg, Integer totalMembers, String version) {
        this.id = id;
        this.state = state;
        this.district = district;
        this.block = block;
        this.totalVillage = totalVillage;
        this.totalShg = totalShg;
        this.totalMembers = totalMembers;
        this.version = version;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
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

    public Integer getTotalVillage() {
        return totalVillage;
    }

    public void setTotalVillage(Integer totalVillage) {
        this.totalVillage = totalVillage;
    }

    public Integer getTotalShg() {
        return totalShg;
    }

    public void setTotalShg(Integer totalShg) {
        this.totalShg = totalShg;
    }

    public Integer getTotalMembers() {
        return totalMembers;
    }

    public void setTotalMembers(Integer totalMembers) {
        this.totalMembers = totalMembers;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public List<Object> getNotes() {
        return notes;
    }

    public void setNotes(List<Object> notes) {
        this.notes = notes;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getXformId() {
        return xformId;
    }

    public void setXformId(Integer xformId) {
        this.xformId = xformId;
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
}
