package com.example.peber_dwimahdini;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_Panjang;
    public static String EXTRA_Lebar;
    EditText editTextPanjang, editTextLebar;
    Button buttonHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPanjang = findViewById(R.id.Panjang);
        editTextLebar = findViewById(R.id.Lebar);
        buttonHitung = findViewById(R.id.button);

        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungDanTampilkan();
            }
        });
    }

    private void hitungDanTampilkan() {
        try {
            double panjang = Double.parseDouble(editTextPanjang.getText().toString());
            double lebar = Double.parseDouble(editTextLebar.getText().toString());


            double luas = panjang * lebar;
            double keliling = 2 * (panjang + lebar);

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("Panjang", panjang);
            intent.putExtra("Lebar", lebar);
            intent.putExtra("LUAS", luas);
            intent.putExtra("KELILING", keliling);
            startActivity(intent);
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Masukkan angka yang valid", Toast.LENGTH_SHORT).show();
        }
    }
}