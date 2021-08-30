package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView petNameText = (TextView) view.findViewById(R.id.name);
        TextView petSummaryText = (TextView) view.findViewById(R.id.summary);

        int nameColoum = cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_NAME);
        int breedColoum = cursor.getColumnIndex(PetContract.PetEntry.COLUMN_PET_BREED);

        String petname = cursor.getString(nameColoum);
        String petBreed = cursor.getString(breedColoum);

        petNameText.setText(petname);
        petSummaryText.setText(petBreed);
    }
}
