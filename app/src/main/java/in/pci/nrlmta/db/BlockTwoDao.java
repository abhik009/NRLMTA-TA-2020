package in.pci.nrlmta.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import in.pci.nrlmta.models.BlockTwoModel;
import in.pci.nrlmta.models.ListItem;
import in.pci.nrlmta.models.ModelOne;

@Dao
public interface BlockTwoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(BlockTwoModel dataBlock);

    @Query("SELECT * from BlockTableTwo ORDER BY dataState,dataDistrict,dataBlock ASC")
    List<BlockTwoModel> getAllData();

    @Query("SELECT dataState as state, COUNT(*) as count from BlockTableTwo GROUP BY dataState ORDER BY dataState ASC")
    LiveData<List<ListItem>> getStateCount();

    //    -------------------SHG Member Details------------------------
    @Query("SELECT IFNULL(SUM(dataQ1F),0) from BlockTableTwo WHERE dataQ1D ='SHG' and dataState=:state")
    Long getShgMemData(String state);

    @Query("SELECT IFNULL(SUM(dataQ1F),0) from BlockTableTwo WHERE dataQ1D ='SHG' and dataState=:state and dataDistrict=:district")
    Long getShgMemData(String state, String district);

    @Query("SELECT IFNULL(SUM(dataQ1F),0) from BlockTableTwo WHERE dataQ1D ='SHG' and dataState=:state and dataDistrict=:district and dataBlock=:block")
    Long getShgMemData(String state, String district, String block);

    //    -------------------NON-SHG Details------------------------
    @Query("SELECT IFNULL(SUM(dataQ1F),0) from BlockTableTwo WHERE dataQ1D ='NON-SHG' and dataState=:state and dataQ1D='NON-SHG'")
    Long getNonShgData(String state);

    @Query("SELECT IFNULL(SUM(dataQ1F),0) from BlockTableTwo WHERE dataQ1D ='NON-SHG' and dataState=:state and dataDistrict=:district and dataQ1D='NON-SHG'")
    Long getNonShgData(String state, String district);

    @Query("SELECT IFNULL(SUM(dataQ1F),0) from BlockTableTwo WHERE dataQ1D ='NON-SHG' and dataState=:state and dataDistrict=:district and dataBlock=:block and dataQ1D='NON-SHG'")
    Long getNonShgData(String state, String district, String block);

    //    -------------------CRP Details------------------------
    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='CRP' and dataState=:state")
    ModelOne getCrpData(String state);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='CRP' and dataState=:state and dataDistrict=:district")
    ModelOne getCrpData(String state, String district);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='CRP' and dataState=:state and dataDistrict=:district and dataBlock=:block")
    ModelOne getCrpData(String state, String district, String block);

    //    -------------------CC Details------------------------
    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='COMMUNITY CADRE / CBO STAFF' and dataState=:state")
    ModelOne getCCData(String state);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='COMMUNITY CADRE / CBO STAFF' and dataState=:state and dataDistrict=:district")
    ModelOne getCCData(String state, String district);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='COMMUNITY CADRE / CBO STAFF' and dataState=:state and dataDistrict=:district and dataBlock=:block")
    ModelOne getCCData(String state, String district, String block);

    //    -------------------Gram Sahayak Details------------------------
    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='GRAM ROJGAR SAHAYAK' and dataState=:state")
    ModelOne getGRSData(String state);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='GRAM ROJGAR SAHAYAK' and dataState=:state and dataDistrict=:district")
    ModelOne getGRSData(String state, String district);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='GRAM ROJGAR SAHAYAK' and dataState=:state and dataDistrict=:district and dataBlock=:block")
    ModelOne getGRSData(String state, String district, String block);

    //    -------------------Other Details------------------------
    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='OTHERS' and dataState=:state")
    ModelOne getOthersData(String state);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='OTHERS' and dataState=:state and dataDistrict=:district")
    ModelOne getOthersData(String state, String district);

    @Query("SELECT IFNULL(SUM(dataQ1C),0) as expected, IFNULL(SUM(dataQ1F),0) as participated from BlockTableTwo WHERE dataLevel='CADRE' and dataQ1A='OTHERS' and dataState=:state and dataDistrict=:district and dataBlock=:block")
    ModelOne getOthersData(String state, String district, String block);

    @Query("DELETE FROM BlockTableTwo")
    void deleteAll();

}