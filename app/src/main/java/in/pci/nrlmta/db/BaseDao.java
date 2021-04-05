package in.pci.nrlmta.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import in.pci.nrlmta.models.BaseDataModel;

@Dao
public interface BaseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(BaseDataModel baseDataModel);

    @Query("SELECT * from basedata")
    List<BaseDataModel> getAll();

    @Query("select distinct state from basedata")
    List<String> getState();

    @Query("select distinct district from basedata where  state=:state")
    List<String> getDistrict(String state);

    @Query("select distinct block from basedata where state=:states and district=:districts")
    List<String> getBlock(String states, String districts);

    //    ----------------Data For Block Dashboard------------------
    //    ---------------------Village Count------------------------
    @Query("SELECT IFNULL(SUM(totalVillage),0) from basedata WHERE state=:state")
    Long getVillageData(String state);

    @Query("SELECT IFNULL(SUM(totalVillage),0) from basedata WHERE state=:state and district=:district")
    Long getVillageData(String state, String district);

    @Query("SELECT IFNULL(SUM(totalVillage),0) from basedata WHERE state=:state and district=:district and block=:block")
    Long getVillageData(String state, String district, String block);

    //    -------------------Total SHG Counts------------------------
    @Query("SELECT IFNULL(SUM(totalShg),0) from basedata WHERE state=:state")
    Long getShgData(String state);

    @Query("SELECT IFNULL(SUM(totalShg),0) from basedata WHERE state=:state and district=:district")
    Long getShgData(String state, String district);

    @Query("SELECT IFNULL(SUM(totalShg),0) from basedata WHERE state=:state and district=:district and block=:block")
    Long getShgData(String state, String district, String block);

    //    -------------------SHG Member Count------------------------
    @Query("SELECT IFNULL(SUM(totalMembers),0) from basedata WHERE state=:state")
    Long getShgMemData(String state);

    @Query("SELECT IFNULL(SUM(totalMembers),0) from basedata WHERE state=:state and district=:district")
    Long getShgMemData(String state, String district);

    @Query("SELECT IFNULL(SUM(totalMembers),0) from basedata WHERE state=:state and district=:district and block=:block")
    Long getShgMemData(String state, String district, String block);

    @Query("delete from basedata")
    void deleteAll();
}
