package com.ninda.praktikummodul3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdatafak = {"Prodi Teknik Informatika", "Prodi Sistem Informasi", "Prodi Teknik Sipil", "Prodi Desain Komunikasi Visual", "Prodi Manajemen Informatika"};
    EditText lv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac = findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak));
    }

    public void pilihprodi(View v) {
        lv = findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Prodi Fakultas Ilmu Komputer");
        builder.setItems(stringdatafak, (dialog, item) -> {
            lv.setText(stringdatafak[item]);
            dialog.dismiss();
        }).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Posisi lagi start nih", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Posisi lagi pause nih", Toast.LENGTH_LONG).show();
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Posisi lagi resume nih", Toast.LENGTH_LONG).show();
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(android.R.color.background_light));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Posisi udah hancur nih", Toast.LENGTH_SHORT).show();    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
