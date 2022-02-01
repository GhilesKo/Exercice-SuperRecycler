package com.example.superrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Adapteur extends RecyclerView.Adapter<Adapteur.ViewHolder> {

    public List<Secret> list;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
       public TextView tvNom;
        public TextView tvDate;
      public TextView tvNombre;

        public ViewHolder(LinearLayout v) {
            super(v);
            // Define click listener for the ViewHolder's View
            tvNom =  v.findViewById(R.id.tvNom);
            tvDate =  v.findViewById(R.id.tvDate);
            tvNombre =  v.findViewById(R.id.tvNombre);

        }

    /*    public TextView getTextView() {
            return textView;
        }*/
    }

    /**
     * Initialize the dataset of the Adapter.
     *

     * by RecyclerView.
     */
    public Adapteur() {
       list = new ArrayList<>();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        LinearLayout view = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.secret_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Secret secretCourrant = list.get(position);
        viewHolder.tvNom.setText(secretCourrant.nom);
        viewHolder.tvDate.setText(secretCourrant.date.toString());
        viewHolder.tvNombre.setText(secretCourrant.NbGrand.toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return list.size();
    }
}