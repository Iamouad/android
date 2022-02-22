package azouay.mouad.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import azouay.mouad.app.pojos.ListDrivers;

public class DriverAdapter extends RecyclerView.Adapter<DriverAdapter.ViewHolder> {
    private final List<ListDrivers> mDriver;

    public DriverAdapter(List<ListDrivers> drivers){
        mDriver = drivers;
    }
    @NonNull
    @Override
    public DriverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View personView = inflater.inflate(R.layout.item_list, parent, false);

        return new DriverAdapter.ViewHolder(personView);
    }

    @Override
    public void onBindViewHolder(@NonNull DriverAdapter.ViewHolder holder, int position) {
        ListDrivers d = mDriver.get(position);
        holder.name.setText(d.getDriver().getName());
        holder.team.setText(d.getTeam().getName());
        holder.points.setText(d.getPoints());

    }

    @Override
    public int getItemCount() {
        return mDriver.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name, team, points;

        public ViewHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.driver_name);
            team = (TextView) itemView.findViewById(R.id.team);
            points = (TextView) itemView.findViewById(R.id.points);

        }
    }
}
