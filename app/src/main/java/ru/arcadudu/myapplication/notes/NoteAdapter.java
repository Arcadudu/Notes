package ru.arcadudu.myapplication.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.arcadudu.myapplication.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyNoteViewHolder> {

    private List<Note> noteList = new ArrayList<>();
    private Context context;

    public NoteAdapter(List<Note> noteList, Context context) {
        this.noteList = noteList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyNoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_frag1_item, parent, false);
        return new MyNoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyNoteViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.tvNoteTitle.setText(note.getTitle());
        holder.tvNoteText.setText(note.getText());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class MyNoteViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNoteTitle, tvNoteText;

        public MyNoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNoteTitle = itemView.findViewById(R.id.tv_frag1_title);
            tvNoteText = itemView.findViewById(R.id.tv_frag1_text);
        }
    }
}
