package com.sfiso.collegeediary;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class readtab_Fragment extends androidx.fragment.app.Fragment{
    Cursor cursor;
    int intListViewItemPosition;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceSate)
    {
        View view = inflater.inflate(R.layout.readtab_fragment,container,false);

        CollegeDiaryTable CollegeDT = new CollegeDiaryTable(getContext());

        ListView lstReadView = view.findViewById(R.id.lstReadView);
        CollegeDT.openDB();
        cursor = CollegeDT.getAllRecords();
        CustomAdapter customAdapter = new CustomAdapter();
        lstReadView.setAdapter(customAdapter);
        CollegeDT.closeDB();

        lstReadView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                intListViewItemPosition=i;
                return false;
            }
        });
        registerForContextMenu(lstReadView);
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("options");
        menu.add("Update");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case 0:
                cursor.moveToPosition(intListViewItemPosition);
                String strReadDiaryID = cursor.getString(0);
                String strReadDiaryEntryTitle = cursor.getString(1);
                String strReadDiarySemesterNumber = cursor.getString(2);
                String strReadDiaryEntryDescription = cursor.getString(3);
                String strReadDiaryFutureTask = cursor.getString(4);
                String strReadDiaryEntryDate = cursor.getString(5);

                 TextView txtReadUpdateDiaryTitle = getActivity().findViewById(R.id.txtUpdateDiaryTitle);
                TextView lblReadUpdateEntryDate = getActivity().findViewById(R.id.lblUpdateEntryDate);
                 TextView txtReadUpdateEntryDescription = getActivity().findViewById(R.id.txtUpdateEntryDescription);
                TextView txtReadUpdateDiaryID = getActivity().findViewById(R.id.txtUpdateDiaryID);
                TextView txtReadUpdateSemesterNumber = getActivity().findViewById(R.id.txtUpdateSemesterNumber);
                 TextView txtReadUpdateFutureTasks = getActivity().findViewById(R.id.txtUpdateFutureTasks);
                lblReadUpdateEntryDate.setText(strReadDiaryEntryDate);
                txtReadUpdateDiaryID.setText(strReadDiaryID);
                txtReadUpdateDiaryTitle.setText(strReadDiaryEntryTitle);
                txtReadUpdateEntryDescription.setText(strReadDiaryEntryDescription);
                txtReadUpdateFutureTasks.setText(strReadDiaryFutureTask);
                txtReadUpdateSemesterNumber.setText(strReadDiarySemesterNumber);

                Toast.makeText(getContext(), "Please select the update Tab, to complete the editing of the item", Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(getContext(), "Invalid selection.", Toast.LENGTH_SHORT).show();
        }
        updateListView();
        return true;
    }

    public void updateListView()
    {
        CollegeDiaryTable CollegeDT = new CollegeDiaryTable(getContext());
        CollegeDT.openDB();
        cursor = CollegeDT.getAllRecords();
        CustomAdapter customAdapter = new CustomAdapter();
        ListView lstReadView = getActivity().findViewById(R.id.lstReadView);
        lstReadView.setAdapter(customAdapter);
        CollegeDT.closeDB();
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount()
        {
            return cursor.getCount();
        }

        @Override
        public Object getItem(int i)
        {
            return null;
        }

        @Override
        public long getItemId(int i)
        {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup)
        {
            view = getLayoutInflater().inflate(R.layout.custom_layout, null);

            cursor.moveToPosition(i);

            TextView txtReadEntryDate = view.findViewById(R.id.lblEntryDate);
            TextView txtReadSemesterNumber = view.findViewById(R.id.txtSemesterNumber);
            TextView txtReadDiaryID = view.findViewById(R.id.txtDiaryID);
            TextView txtReadDescription = view.findViewById(R.id.txtDescription);
            TextView txtReadDiaryTitle = view.findViewById(R.id.txtDiaryTitle);

            txtReadDiaryID.setText(cursor.getString(0));
            txtReadDiaryTitle.setText(cursor.getString(1));
            txtReadSemesterNumber.setText(cursor.getString(2));
            txtReadDescription.setText(cursor.getString(3));
            txtReadEntryDate.setText(cursor.getString(5));

            return view;
        }
    }
}
