package in.pci.nrlmta.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import in.pci.nrlmta.models.DataState;
import in.pci.nrlmta.models.ModelOne;

@Dao
public interface StateDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(DataState dataState);

    @Query("select * from statedb order by dataState asc")
    List<DataState> getAll();

    @Query("select SUM(dataQ2) as expected,SUM(dataQ3) as participated from statedb where dataLevel= :Level")
    ModelOne getQ2Q3Values(String Level);

    @Query("select SUM(dataQ2) as expected,SUM(dataQ3) as participated from statedb where dataLevel= :Level and dataState = :State")
    ModelOne getQ2Q3Values(String Level, String State);

    @Query("select SUM(dataQ2) as expected,SUM(dataQ3) as participated from statedb where dataLevel= :Level and dataState = :State and dataDistrict=:District")
    ModelOne getQ2Q3Values(String Level, String State, String District);

    @Query("select SUM(dataQ2) as expected,SUM(dataQ3) as participated from statedb where dataLevel= :Level and dataState = :State and dataDistrict=:District and dataBlock=:Block")
    ModelOne getQ2Q3Values(String Level, String State, String District,String Block);

    @Query("select SUM(dataQ4) as expected,SUM(dataQ5) as participated from statedb where dataLevel= :Level")
    ModelOne getQ4Q5Values(String Level);

    @Query("select SUM(dataQ4) as expected,SUM(dataQ5) as participated from statedb where dataLevel= :Level and dataState = :State")
    ModelOne getQ4Q5Values(String Level, String State);

    @Query("select SUM(dataQ4) as expected,SUM(dataQ5) as participated from statedb where dataLevel= :Level and dataState = :State and dataDistrict = :District")
    ModelOne getQ4Q5Values(String Level, String State, String District);

    @Query("select SUM(dataQ4) as expected,SUM(dataQ5) as participated from statedb where dataLevel= :Level and dataState = :State and dataDistrict = :District and dataBlock = :Blocks")
    ModelOne getQ4Q5Values(String Level, String State, String District,String Blocks);

    @Query("DELETE FROM statedb")
    void deleteAll();
}
