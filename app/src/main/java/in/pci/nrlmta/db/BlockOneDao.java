package in.pci.nrlmta.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import in.pci.nrlmta.models.BlockDataModel;
import in.pci.nrlmta.models.BlockOneModel;

@Dao
public interface BlockOneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(BlockOneModel dataModel);

    @Query("SELECT * from blocktableone")
    List<BlockOneModel> getAll();

    //    -------------------Village Details--------------------
    @Query("SELECT IFNULL(SUM(Village),0) from blockTableOne WHERE Level='SHG' and State=:state")
    Long getVillageData(String state);

    @Query("SELECT IFNULL(SUM(Village),0) from blockTableOne WHERE Level='SHG' and State=:state and District=:district")
    Long getVillageData(String state, String district);

    @Query("SELECT IFNULL(SUM(Village),0) from blockTableOne WHERE Level='SHG' and State=:state and District=:district and Block=:block")
    Long getVillageData(String state, String district, String block);

    //    -------------------SHG Details------------------------
    @Query("SELECT IFNULL(SUM(Shg),0) from blockTableOne WHERE Level='SHG' and State=:state")
    Long getShgData(String state);

    @Query("SELECT IFNULL(SUM(Shg),0) from blockTableOne WHERE Level='SHG' and State=:state and District=:district")
    Long getShgData(String state, String district);

    @Query("SELECT IFNULL(SUM(Shg),0) from blockTableOne WHERE Level='SHG' and State=:state and District=:district and Block=:block")
    Long getShgData(String state, String district, String block);

    @Query("DELETE FROM blockTableOne")
    void deleteAll();
}
