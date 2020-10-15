package ru.arcadudu.myapplication.frags;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ru.arcadudu.myapplication.MyInterface;
import ru.arcadudu.myapplication.R;
import ru.arcadudu.myapplication.notes.Note;
import ru.arcadudu.myapplication.notes.NoteAdapter;

public class Frag11 extends Fragment {

    private RecyclerView recycler;
    private NoteAdapter adapter;
    private List<Note> list = new ArrayList<>();
    MyInterface myInterface;


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
        tvEmptyNotes = view.findViewById(R.id.tv_empty_notes);
        recycler = view.findViewById(R.id.recycler);
        adapter = new NoteAdapter(list, getContext());
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);
        checkIfNoNotes(list);

        // add new note button
        fabAdd = view.findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public void checkIfNoNotes(List<Note> list) {
        if (list.size() == 0) {
            tvEmptyNotes.setVisibility(View.VISIBLE);
        } else {
            tvEmptyNotes.setVisibility(View.GONE);
        }
    }

    public void showDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.dialog_layout, null);
        final EditText etTitle = dialogLayout.findViewById(R.id.et_dialog_title);
        final EditText etContent = dialogLayout.findViewById(R.id.et_dialog_content);
        builder.setTitle("Новая заметка")
                .setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title = etTitle.getText().toString();
                        String content = etContent.getText().toString();
                        if (!title.isEmpty()) {
                            Note note = new Note(title, content);
                            list.add(note);
                        } else {
                            Toast.makeText(getContext(), "Название не может быть пустым!", Toast.LENGTH_SHORT).show();
                            showDialog();
                        }
                        adapter.notifyDataSetChanged();
                        checkIfNoNotes(list);
                    }
                }).setView(dialogLayout).show();


    }

    public void registerCallback(MyInterface myinterface){
        this.myInterface = myinterface;
    }
}
