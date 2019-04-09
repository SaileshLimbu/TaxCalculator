package np.com.softwarica.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCalculate;
    private EditText etSalary;
    private TextView tvResult;
    private TaxOperator taxOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSalary = findViewById(R.id.etSalary);
        tvResult = findViewById(R.id.tvResult);
        btnCalculate = findViewById(R.id.btnCalculate);
        taxOperator = new TaxOperator();

        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(TextUtils.isEmpty(etSalary.getText().toString())){
            etSalary.setError("Please enter salary.");
            etSalary.requestFocus();
            return;
        }

        float salary = Float.parseFloat(etSalary.getText().toString());

        taxOperator.setSalary(salary);
        tvResult.setText(Float.toString(taxOperator.calculateTax()));
    }
}