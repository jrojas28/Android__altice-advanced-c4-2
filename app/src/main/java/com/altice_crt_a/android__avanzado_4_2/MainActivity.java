package com.altice_crt_a.android__avanzado_4_2;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.altice_crt_a.android__avanzado_4_2.classes.DaoSession;
import com.altice_crt_a.android__avanzado_4_2.classes.Note;
import com.altice_crt_a.android__avanzado_4_2.classes.NoteAdapter;
import com.altice_crt_a.android__avanzado_4_2.classes.NoteDao;

public class MainActivity extends AppCompatActivity {
    private NoteAdapter noteAdapter;
    private RecyclerView noteHolder;
    private Button noteCreateButton;
    private EditText noteContentText;

    private DaoSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteAdapter = new NoteAdapter();

        noteHolder = findViewById(R.id.note_holder);
        noteHolder.setLayoutManager(new GridLayoutManager(this, 1));
        noteHolder.setAdapter(noteAdapter);
        noteCreateButton = findViewById(R.id.new_note_button);
        noteContentText = findViewById(R.id.new_note_content);

        session = ((CustomApplication) getApplication()).getDaoSession();
        NoteDao noteDao = session.getNoteDao();
        noteAdapter.updateData(noteDao.loadAll());

        noteCreateButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {
                String text = noteContentText.getText().toString();
                if(text.length() > 0) {
                    Note note = new Note(null, text);
                    NoteDao noteDao = session.getNoteDao();
                    noteDao.insert(note);
                    noteContentText.setText("");
                    noteAdapter.updateData(noteDao.loadAll());
                }
            }
        });

    }
}
