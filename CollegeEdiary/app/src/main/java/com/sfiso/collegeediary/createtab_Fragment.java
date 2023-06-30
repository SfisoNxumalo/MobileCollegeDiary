package com.sfiso.collegeediary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class createtab_Fragment extends androidx.fragment.app.Fragment{

    private static final String strTag = "createtab_Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceSate)
    {

        View view = inflater.inflate(R.layout.createtab_fragment,container,false);

        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String EntryDate = sdf.format(date);

        Button btnCreate = view.findViewById(R.id.btnCreate);

         TextView txtCreateDiaryTitle = view.findViewById(R.id.txtDiaryTitle);

         EditText txtCreateSemesterNumber = view.findViewById(R.id.txtSemesterNumber);
         EditText txtCreateEntryDescription = view.findViewById(R.id.txtEntryDescription);
         EditText txtCreateFutureTasks = view.findViewById(R.id.txtFutureTasks);

         TextView lblCreateEntryDate = view.findViewById(R.id.lblEntryDate);

        lblCreateEntryDate.setText(EntryDate);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String strDiaryEntryTitle = txtCreateDiaryTitle.getText().toString();
                int intDiarySemesterNumber = Integer.parseInt(txtCreateSemesterNumber.getText().toString());
                String strDiaryEntryDescription = txtCreateEntryDescription.getText().toString();
                String strDiaryFutureTask = txtCreateFutureTasks.getText().toString();
                String strDiaryEntryDate = lblCreateEntryDate.getText().toString();

                CollegeDiaryTable CollegeDT = new CollegeDiaryTable(getContext());
                CollegeDT.openDB();
                CollegeDT.insertRecord(strDiaryEntryTitle, intDiarySemesterNumber, strDiaryEntryDescription, strDiaryFutureTask, strDiaryEntryDate);
                CollegeDT.closeDB();

                Toast.makeText(getContext(), "New Diary Entry has been successfully saved.", Toast.LENGTH_SHORT).show();
                txtCreateDiaryTitle.setText("");
                lblCreateEntryDate.setText("");
                txtCreateEntryDescription.setText("");
                txtCreateSemesterNumber.setText("");
                txtCreateFutureTasks.setText("");


            }
        });

        return view;
    }
}
