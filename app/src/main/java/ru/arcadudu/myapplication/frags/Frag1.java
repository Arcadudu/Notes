package ru.arcadudu.myapplication.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ru.arcadudu.myapplication.NoteDialog;
import ru.arcadudu.myapplication.R;
import ru.arcadudu.myapplication.notes.Note;
import ru.arcadudu.myapplication.notes.NoteAdapter;

public class Frag1 extends Fragment implements NoteDialog.MyDialogListener {

    private RecyclerView recycler;
    private NoteAdapter adapter;
    private List<Note> list = new ArrayList<>();

    TextView tvEmptyNotes;
    FloatingActionButton fabAdd;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag1_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        tvEmptyNotes = view.findViewById(R.id.tv_empty_notes);
        fabAdd = view.findViewById(R.id.fabAdd);


//        list.add(new Note("Title1", getResources().getString(R.string.lorem_ipsum_short)));
//        list.add(new Note("Title2", getResources().getString(R.string.lorem_ipsum_short)));
//        list.add(new Note("Title3", getResources().getString(R.string.lorem_ipsum_short)));
//        list.add(new Note("Title4", getResources().getString(R.string.lorem_ipsum_short)));

        setEmptyString(list);
        adapter = new NoteAdapter(list, getContext());
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void setEmptyString(List<Note> list) {
        if (list.isEmpty()) {
            tvEmptyNotes.setVisibility(View.VISIBLE);
        } else {
            tvEmptyNotes.setVisibility(View.GONE);
        }
    }

    public void openDialog() {
        NoteDialog dialog = new NoteDialog();
        dialog.show(getActivity().getSupportFragmentManager(), "NoteDialog");
    }

    @Override
    public void applyText(String title, String content) {
        list.add(new Note(title, content));
        adapter.notifyDataSetChanged();
    }
}
