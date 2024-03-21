package modul2;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.universitaskuningan.modul2.R;

public class MainActivity extends AppCompatActivity {
    int gajiStatus, gajiGolongan;
    RadioGroup golongan;
    CheckBox status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hitung(View v){
        EditText nama = findViewById(R.id.nama);
        TextView outputNama = findViewById(R.id.outputNama);
        TextView outputStatus = findViewById(R.id.outputStatus);
        TextView outputGolongan = findViewById(R.id.outputGolongan);

        String name = nama.getText().toString();
        outputNama.setText("Total Gaji Anda: " + name);

        status = findViewById(R.id.menikah);
        if (status.isChecked()) {
            gajiStatus = 500000;
            outputStatus.setText("Status: Menikah");
        } else {
            gajiStatus = 0;
            outputStatus.setText("Status: Belum Menikah");
        }

        golongan = findViewById(R.id.rgGolongan);
        int gol = golongan.getCheckedRadioButtonId();
        if (gol == R.id.rbGolongan1) {
            gajiGolongan = 1000000;
            outputGolongan.setText("Golongan: 1");
        } else if (gol == R.id.rbGolongan2) {
            gajiGolongan = 2000000;
            outputGolongan.setText("Golongan: 2");
        }

        int totalGaji = gajiStatus + gajiGolongan;

        TextView total = findViewById(R.id.outputGaji);
        total.setText(String.valueOf(totalGaji));
    }

}
