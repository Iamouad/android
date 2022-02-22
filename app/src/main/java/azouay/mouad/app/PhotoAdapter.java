package azouay.mouad.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import azouay.mouad.app.pojos.Photo;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private final List<Photo> mPhotos;

    public PhotoAdapter(List<Photo> photos){
        mPhotos = photos;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View personView = inflater.inflate(R.layout.item_list, parent, false);

        return new ViewHolder(personView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Photo p = mPhotos.get(position);
        ImageView imageView = holder.photoImg;
        holder.desc.setText(p.getTitle());
        Picasso.get().load(p.getThumbnailUrl()).into(imageView);

    }

    @Override
    public int getItemCount() {
        return mPhotos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView photoImg, arrow;
        public TextView desc;

        public ViewHolder(View itemView){
            super(itemView);
           /* photoImg = (ImageView) itemView.findViewById(R.id.photo_id);
            arrow = (ImageView) itemView.findViewById(R.id.arrow);
            desc = (TextView) itemView.findViewById(R.id.nom);*/

        }
    }
}
