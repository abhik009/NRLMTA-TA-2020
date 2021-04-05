package in.pci.nrlmta.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import in.pci.nrlmta.R;
import in.pci.nrlmta.models.ListItem;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<ListItem> mDataList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public RecyclerAdapter(Context context, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(List<ListItem> listItems) {
        this.mDataList = listItems;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mName, mStatus;
        private OnItemClickListener onItemClickListener;
        private ListItem dataItem;

        private ViewHolder(View view, OnItemClickListener onRowClick) {
            super(view);
            this.onItemClickListener = onRowClick;
            view.setOnClickListener(this);
            mName = view.findViewById(R.id.recycler_item_name);
            mStatus = view.findViewById(R.id.recycler_item_status);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClicked(dataItem);
            Snackbar.make(v, mName.getText().toString(), Snackbar.LENGTH_LONG).show();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mDataList != null) {
            holder.dataItem = mDataList.get(position);
            holder.mName.setText(mDataList.get(position).getState().toString().replace("_", " "));
            holder.mStatus.setText(String.valueOf(mDataList.get(position).getCount()));
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public interface OnItemClickListener {
        void onItemClicked(ListItem dataItem);
    }
}
