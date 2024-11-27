package com.vivid.dilseconnect.Activites;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vivid.dilseconnect.Fragmets.For_you;
import com.vivid.dilseconnect.R;

public class imageadapter extends RecyclerView.Adapter<imageadapter.ViewHolder> {

    Context context;
    int[] images;
    String[] names;
    static For_you.OnImageClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView rawView;
        TextView nameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rawView = itemView.findViewById(R.id.image_view_id);
            nameTextView = itemView.findViewById(R.id.name_first_image_for_you);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION && listener != null) {
                listener.onImageClick(position); // Call the listener
            }
        }
    }

    public imageadapter(Context context, int[] images, String[] names, For_you.OnImageClickListener listener) { // Update constructor
        this.context = context;this.images = images;
        this.names = names;
        this.listener = listener;
    }

    // ... (onCreateViewHolder method remains the same)

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.horizantal_images, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull imageadapter.ViewHolder holder, int position) {
        holder.rawView.setImageResource(images[position]);

        // Set the name from the array
        if (position < names.length) {
            holder.nameTextView.setText(names[position]);
        }
    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
