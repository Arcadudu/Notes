package ru.arcadudu.myapplication.frags;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.arcadudu.myapplication.R;

public class Frag2 extends Fragment {

    private String title, content;
    private TextView tvCardNoteTitle, tvCardNoteContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag2_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCardNoteTitle = view.findViewById(R.id.tv_frag2_title);
        tvCardNoteContent = view.findViewById(R.id.tv_frag2_content);
        setCardContent(title, content);
    }

    public void setCardContent(String title, String content){
        this.title = title;
        this.content = content;
        tvCardNoteTitle.setText(title);
        tvCardNoteContent.setText(content);
    }
}
