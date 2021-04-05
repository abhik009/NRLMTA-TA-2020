package in.pci.nrlmta.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import in.pci.nrlmta.models.BaseDataModel;
import in.pci.nrlmta.models.BlockOneModel;
import in.pci.nrlmta.models.BlockTwoModel;
import in.pci.nrlmta.models.DataState;

@Database(entities = {BaseDataModel.class, DataState.class, BlockOneModel.class, BlockTwoModel.class}, version = 1, exportSchema = false)
public abstract class AppsDatabase extends RoomDatabase {

    public abstract BaseDao mBaseDao();
    public abstract StateDao mStateDao();
    public abstract BlockOneDao mBlockOneDao();
    public abstract BlockTwoDao mBlockTwoDao();
    private static AppsDatabase INSTANCE;

    public static AppsDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppsDatabase.class, "NRLMTA")
                            .fallbackToDestructiveMigration()
                            .setJournalMode(JournalMode.TRUNCATE)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
