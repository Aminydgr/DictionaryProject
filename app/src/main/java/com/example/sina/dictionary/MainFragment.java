package com.example.sina.dictionary;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.sina.dictionary.Database.DatabaseHelper;

public class MainFragment extends Fragment {

    Context context;
    DatabaseHelper databaseHelper;
    EditText editTextWord;
    TextView textViewAnswer;
    Button buttonTranslate;
    Button buttonLibrary;
    RadioGroup radioGroup;
    RadioButton radioButtonEnglish;
    RadioButton radioButtonPersian;
    RadioButton radioButtonFrecnh;
    RadioButton radioButtonTurkish;


    public MainFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        editTextWord = (EditText) view.findViewById(R.id.editTextWord);
        buttonTranslate = (Button) view.findViewById(R.id.buttonTranslate);
        textViewAnswer = (TextView) view.findViewById(R.id.textViewAnswer);
        final Intent intent = new Intent(getActivity(), LibraryActivity.class);
        view.findViewById(R.id.buttonLibrary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        buttonTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = databaseHelper.translate(editTextWord.getText().toString());
                cursor.moveToFirst();
                String eng = cursor.getString(1);
                String per = cursor.getString(2);
                String fre = cursor.getString(3);
                String tur = cursor.getString(4);

                textViewAnswer.setText(eng);
                textViewAnswer.setText(per);
                textViewAnswer.setText(fre);
                textViewAnswer.setText(tur);
            }
        });

        return view;
    }
}
