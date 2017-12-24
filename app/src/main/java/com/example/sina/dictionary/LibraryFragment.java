package com.example.sina.dictionary;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sina.dictionary.Database.DatabaseHelper;

public class LibraryFragment extends Fragment {
    Context context;
    EditText editTextSearch;
    EditText editTextEnglish;
    EditText editTextPersian;
    EditText editTextFrench;
    EditText editTextTurkish;
    Button buttonSearch;
    Button buttonDone;
    Button buttonEdit;
    Button buttonDelete;

    public String eng;
    public String per;
    public String fre;
    public String tur;

    public LibraryFragment() {

    }


    public void setContext(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.library_fragment, container, false);

        final DatabaseHelper databaseHelper = new DatabaseHelper(context);
        editTextSearch = (EditText) view.findViewById(R.id.editTextSearch);
        editTextEnglish = (EditText) view.findViewById(R.id.editTextEnglish);
        editTextPersian = (EditText) view.findViewById(R.id.editTextPersian);
        editTextFrench = (EditText) view.findViewById(R.id.editTextFrench);
        editTextTurkish = (EditText) view.findViewById(R.id.editTextTurkish);
        buttonSearch = (Button) view.findViewById(R.id.buttonSearch);
        buttonDone = (Button) view.findViewById(R.id.buttonDone);
        buttonDelete = (Button) view.findViewById(R.id.buttonDelete);
        buttonEdit = (Button) view.findViewById(R.id.buttonEdit);


        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addData(editTextEnglish.getText().toString(), editTextPersian.getText().toString(), editTextFrench.getText().toString(), editTextTurkish.getText().toString());

            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Cursor cursor = databaseHelper.translate(editTextSearch.getText().toString());
                    cursor.moveToFirst();
                    String eng = cursor.getString(1);
                    String per = cursor.getString(2);
                    String fre = cursor.getString(3);
                    String tur = cursor.getString(4);

                    editTextEnglish.setText(eng);
                    editTextPersian.setText(per);
                    editTextFrench.setText(fre);
                    editTextTurkish.setText(tur);
                } catch (Exception e) {
                    Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
                }
                eng = editTextEnglish.getText().toString();
                per = editTextPersian.getText().toString();
                fre = editTextFrench.getText().toString();
                tur = editTextTurkish.getText().toString();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = databaseHelper.deleteWord(editTextSearch.getText().toString());

            }
        });

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                databaseHelper.updateWord(editTextEnglish.getText().toString(), eng);
                databaseHelper.updateWord(editTextPersian.getText().toString(), per);
                databaseHelper.updateWord(editTextFrench.getText().toString(), fre);
                databaseHelper.updateWord(editTextTurkish.getText().toString(), tur);


            }
        });


        return view;

    }

}
