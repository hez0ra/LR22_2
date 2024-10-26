package volosuyk.lr22;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderSummaryActivity extends AppCompatActivity {

    private TextView orderSummaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        orderSummaryText = findViewById(R.id.orderSummaryText);

        String orderDescription = getIntent().getStringExtra("ORDER_DESCRIPTION");
        orderSummaryText.setText(orderDescription);
    }
}