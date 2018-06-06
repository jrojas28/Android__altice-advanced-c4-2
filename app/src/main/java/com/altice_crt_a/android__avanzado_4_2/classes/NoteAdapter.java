package com.altice_crt_a.android__avanzado_4_2.classes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.altice_crt_a.android__avanzado_4_2.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaime on 6/2/2018.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{
    private ArrayList<Note> notes;

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.content.setText(notes.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void updateData(List<Note> notes) {
        this.notes = new ArrayList<>(notes);
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public TextView content;
        public NoteViewHolder(View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.note_content);
        }
    }
}
