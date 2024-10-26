package volosuyk.lr22;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Switch temperatureSwitch;
    private ImageView temperatureImage;
    private CheckBox milkCheckBox, creamCheckBox, sugarCheckBox, syrupCheckBox;
    private Switch deliverySwitch;
    private Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureSwitch = findViewById(R.id.temperatureSwitch);
        temperatureImage = findViewById(R.id.temperatureImage);
        milkCheckBox = findViewById(R.id.milkCheckBox);
        creamCheckBox = findViewById(R.id.creamCheckBox);
        sugarCheckBox = findViewById(R.id.sugarCheckBox);
        syrupCheckBox = findViewById(R.id.syrupCheckBox);
        deliverySwitch = findViewById(R.id.deliverySwitch);
        orderButton = findViewById(R.id.orderButton);

        temperatureSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    temperatureImage.setImageResource(R.drawable.blue_circle); // Холодный
                } else {
                    temperatureImage.setImageResource(R.drawable.red_circle); // Горячий
                }
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temperature = temperatureSwitch.isChecked() ? "Холодный" : "Горячий";
                StringBuilder ingredients = new StringBuilder("Ингредиенты: ");
                if (milkCheckBox.isChecked()) ingredients.append("Молоко ");
                if (creamCheckBox.isChecked()) ingredients.append("Сливки ");
                if (sugarCheckBox.isChecked()) ingredients.append("Сахар ");
                if (syrupCheckBox.isChecked()) ingredients.append("Сироп ");
                String delivery = deliverySwitch.isChecked() ? "Доставка" : "Самовывоз";

                Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
                intent.putExtra("ORDER_DESCRIPTION", temperature + " кофе, " + ingredients.toString().trim() + ", " + delivery);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Студент: Волосюк", Toast.LENGTH_SHORT).show();
            }
        });
    }
}