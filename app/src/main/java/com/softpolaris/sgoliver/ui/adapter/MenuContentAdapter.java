package com.softpolaris.sgoliver.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.softpolaris.sgoliver.R;
import com.softpolaris.sgoliver.models.MenuItem;
import com.softpolaris.sgoliver.utilities.FontHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class MenuContentAdapter extends RecyclerView.Adapter<MenuContentAdapter.MenuViewHolder> {
    private Context context;
    private List<MenuItem> menuItems;
    private GeneralAdapterView<MenuItem> adapterView;

    public MenuContentAdapter(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    @Override
    public MenuContentAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_general, viewGroup, false);
        MenuViewHolder viewHolder = new MenuViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MenuContentAdapter.MenuViewHolder holder, final int position) {
        holder.imgIcon.setImageResource(menuItems.get(position).getImgIcon());
        holder.txtName.setText(menuItems.get(position).getTxtName());
        holder.imgArrow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_arrow));
    }

    @Override
    public int getItemCount() {
        return menuItems != null ? menuItems.size() : 0;
    }

    public void setAdapterView(GeneralAdapterView<MenuItem> adapterView) {
        this.adapterView = adapterView;
    }

    private MenuItem getItem(int position) {
        return menuItems.get(position);
    }

    class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imgIcon)
        ImageView imgIcon;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.imgArrow)
        ImageView imgArrow;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
            new FontHelper(context).applyFont(itemView.findViewById(R.id.globalConstraint));
        }

        @Override
        public void onClick(View v) {
            if (adapterView != null) {
                adapterView.onItemSelected(getItem(getAdapterPosition()));
            }
        }
    }
}
