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

public class updatetab_Fragment extends androidx.fragment.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceSate)
    {
        View view = inflater.inflate(R.layout.updatetab_fragment,container,false);

        EditText txtUpdateSemesterNumber = view.findViewById(R.id.txtUpdateSemesterNumber);
        EditText txtUpdateFutureTasks = view.findViewById(R.id.txtUpdateFutureTasks);
        EditText txtUpdateEntryDescription = view.findViewById(R.id.txtUpdateEntryDescription);
        EditText txtUpdateDiaryTitle = view.findViewById(R.id.txtUpdateDiaryTitle);

        Button btnUpdate = view.findViewById(R.id.btnUpdate);

        TextView txtUpdateDiaryID = view.findViewById(R.id.txtUpdateDiaryID);
        TextView lblUpdateEntryDate = view.findViewById(R.id.lblUpdateEntryDate);

        btnUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String strUpdateDiaryFutureTask = txtUpdateFutureTasks.getText().toString();
                String strUpdateDiaryID = txtUpdateDiaryID.getText().toString();
                String strUpdateDiaryEntryDescription = txtUpdateEntryDescription.getText().toString();
                String strUpdateDiaryEntryTitle = txtUpdateDiaryTitle.getText().toString();

                int intUpdateDiarySemesterNumber = Integer.parseInt(txtUpdateSemesterNumber.getText().toString());

                CollegeDiaryTable CollegeDT = new CollegeDiaryTable(getContext());
                CollegeDT.openDB();
                CollegeDT.updateRecord(strUpdateDiaryID, strUpdateDiaryEntryTitle, intUpdateDiarySemesterNumber, strUpdateDiaryEntryDescription, strUpdateDiaryFutureTask);
                CollegeDT.closeDB();

                txtUpdateDiaryID.setText("");
                lblUpdateEntryDate.setText("");
                txtUpdateSemesterNumber.setText("");
                txtUpdateEntryDescription.setText("");
                txtUpdateDiaryTitle.setText("");
                txtUpdateFutureTasks.setText("");

                Toast.makeText(getContext(), "The diary entry has been successfully updated.", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}


