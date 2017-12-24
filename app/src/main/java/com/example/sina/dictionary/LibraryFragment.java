package com.example.sina.dictionary;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sina.dictionary.Database.DatabaseHelper;

public class LibraryFragment extends Fragment {
    Context context ;
    EditText editTextSearch;
    EditText editTextEnglish;
    EditText editTextPersian;
    EditText editTextFrench;
    EditText editTextTurkish;
    Button buttonSearch;
    Button buttonDone;
    Button buttonDelete;

    public LibraryFragment() {

    }


    public  void setContext(Context context){
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.library_fragment, container, false);

        final DatabaseHelper databaseHelper = new DatabaseHelper(context);
        editTextSearch = (EditText)view.findViewById(R.id.editTextSearch);
        editTextEnglish = (EditText)view.findViewById(R.id.editTextEnglish);
        editTextPersian = (EditText)view.findViewById(R.id.editTextPersian);
        editTextFrench = (EditText)view.findViewById(R.id.editTextFrench);
        editTextTurkish = (EditText)view.findViewById(R.id.editTextTurkish);
        buttonSearch = (Button) view.findViewById(R.id.buttonSearch);
        buttonDone = (Button) view.findViewById(R.id.buttonDone);
        buttonDelete = (Button) view.findViewById(R.id.buttonDelete);


        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addData(editTextEnglish.getText().toString(), editTextPersian.getText().toString(), editTextFrench.getText().toString(), editTextTurkish.getText().toString());

            }
        });

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Cursor cursor = databaseHelper.translate(editTextSearch.getText().toString());
//                String eng = cursor.getString(Integer.parseInt(cursor.getColumnName(1)));
//                String per = cursor.getString(Integer.parseInt(cursor.getColumnName(2)));
//                String fre = cursor.getString(Integer.parseInt(cursor.getColumnName(3)));
//                String tur = cursor.getString(Integer.parseInt(cursor.getColumnName(4)));

                String eng = cursor.getString(Integer.parseInt(cursor.getColumnName(1)));
                String per = cursor.getString(Integer.parseInt(cursor.getColumnName(2)));
                String fre = cursor.getString(Integer.parseInt(cursor.getColumnName(3)));
                String tur = cursor.getString(Integer.parseInt(cursor.getColumnName(4)));

                editTextEnglish.setText(eng);
                editTextEnglish.setText(per);
                editTextEnglish.setText(fre);
                editTextEnglish.setText(tur);
            }
        });









        return view;

    }

}
