package com.example.storytale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContent;

    Adapter(Context context, String[] titles, String[] contents) {
       this.inflater = LayoutInflater.from(context);
       this.sTitles = titles;
       this.sContent = contents;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = inflater.inflate(R.layout.custom_view, viewGroup, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int i) {
        String title = sTitles[i];
        String content = sContent[i];
        holder.storyTitle.setText(title);
        holder.storyContent.setText(content);
    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView storyTitle, storyContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //implements onclick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), Details.class);
                    //send story title and contents through recycler view to detail activity
                    i.putExtra("titleOfStory", sTitles[getAdapterPosition()]);
                    i.putExtra("contentOfStory", sContent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });

            storyTitle = itemView.findViewById(R.id.storyTitle);
            storyContent = itemView.findViewById(R.id.storyContent);
        }
    }
}
