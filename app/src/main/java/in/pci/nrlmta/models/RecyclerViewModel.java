package in.pci.nrlmta.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

import in.pci.nrlmta.db.AppsDatabase;
import in.pci.nrlmta.db.BlockTwoDao;

public class RecyclerViewModel extends AndroidViewModel {
    //    private ExecutorService executorService;
    private BlockTwoDao blockTwoDao;

    public RecyclerViewModel(@NonNull Application application) {
        super(application);
        blockTwoDao = AppsDatabase.getInstance(application).mBlockTwoDao();
//        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<ListItem>> getAllItems() {
        return blockTwoDao.getStateCount();
    }
}
