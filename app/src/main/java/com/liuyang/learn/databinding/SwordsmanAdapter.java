package com.liuyang.learn.databinding;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.liuyang.learn.R;
import java.util.List;

public class SwordsmanAdapter extends RecyclerView.Adapter<SwordsmanAdapter.SwordsmanViewHolder> {

  private List<Swordsman> mList;

  public SwordsmanAdapter(List<Swordsman> l) {
    mList = l;
  }

  @NonNull
  @Override
  public SwordsmanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ItemSwordsmanBinding binding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.getContext()), R.layout.item_swordsman, parent, false);
    return new SwordsmanViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull SwordsmanViewHolder holder, int position) {
    Swordsman swordsman = mList.get(position);
    holder.getBinding().setSwordsman(swordsman);
  }

  @Override
  public int getItemCount() {
    return mList.size();
  }

  public static class SwordsmanViewHolder extends RecyclerView.ViewHolder {

    ItemSwordsmanBinding binding;

    public SwordsmanViewHolder(ViewDataBinding binding) {
      super(binding.getRoot());
      this.binding = (ItemSwordsmanBinding) binding;
    }

    public ItemSwordsmanBinding getBinding() {
      return binding;
    }
  }
}
