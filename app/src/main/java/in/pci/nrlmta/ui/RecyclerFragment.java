package in.pci.nrlmta.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.pci.nrlmta.R;
import in.pci.nrlmta.models.ListItem;
import in.pci.nrlmta.models.RecyclerViewModel;

public class RecyclerFragment extends Fragment implements RecyclerAdapter.OnItemClickListener {

    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerViewModel recyclerViewModel;

    public RecyclerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
//        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        adapter = new RecyclerAdapter(view.getContext(), this);
        recyclerViewModel = ViewModelProviders.of(getActivity()).get(RecyclerViewModel.class);
        recyclerViewModel.getAllItems().observe(getActivity(), listItems -> adapter.setData(listItems));
        recyclerView = view.findViewById(R.id.recyclerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onItemClicked(ListItem dataItem) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ListItem", dataItem);
        Navigation.findNavController(getView()).navigate(R.id.action_nav_recycler_to_dashboard, bundle);
    }
}
