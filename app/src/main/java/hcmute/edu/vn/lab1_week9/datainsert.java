package hcmute.edu.vn.lab1_week9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class datainsert extends AppCompatActivity {

    EditText txtname, txtage, txtphone, txtheight;
    Button btnsave;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datainsert);
        txtname = findViewById(R.id.txtname);
        txtage = findViewById(R.id.txtage);
        txtphone = findViewById(R.id.txtphone);
        txtheight = findViewById(R.id.txtheight);
        btnsave = findViewById(R.id.btnsave);
        member = new Member();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age = Integer.parseInt(txtage.getText().toString().trim());
                Float hit = Float.parseFloat(txtheight.getText().toString().trim());
                Long phn = Long.parseLong(txtphone.getText().toString().trim());
                member.setName(txtname.getText().toString().trim());
                member.setAge(age);
                member.setHt(hit);
                member.setPh(phn);
                reff.push().setValue(member);
                Toast.makeText(datainsert.this, "data inserted successfully", Toast.LENGTH_SHORT).show();


            }
        });
    }
}