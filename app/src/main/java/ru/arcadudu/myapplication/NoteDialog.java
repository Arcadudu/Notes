package ru.arcadudu.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class NoteDialog extends AppCompatDialogFragment {


    private EditText et_dialog_textTitle, et_dialog_textContent;
    MyDialogListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_layout, null);

        builder.setView(dialogView)
                .setTitle("Новая заметка")
                .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title = et_dialog_textTitle.getText().toString();
                        String content = et_dialog_textContent.getText().toString();
                        listener.applyText(title, content);
                    }
                });

        et_dialog_textTitle = dialogView.findViewById(R.id.et_dialog_title);
        et_dialog_textContent = dialogView.findViewById(R.id.et_dialog_content);
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (MyDialogListener) context;
        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + "must implement MyDialogListener");
        }
    }

    public interface MyDialogListener {
        void applyText(String title, String content);
    }
}
