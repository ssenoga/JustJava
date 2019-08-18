package andriod.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    // a method to be called when the order button is clicked
    public void onOrderClick(View view){
        displayPrice(price *2);

    }


    // display the given quantity on the screen
    private void display(int num){
        TextView quantityTextView = findViewById(R.id.qty_text_view);
        quantityTextView.setText("" + num);
    }
    // display the price
    private void displayPrice(int price){
        TextView priceTextView = findViewById(R.id.price_txt_view);
        String p = "Total: "+NumberFormat.getCurrencyInstance(Locale.US).format(price)+"\nThank you!";
        priceTextView.setText(p);
    }
    // increment on clicking the increment button
    public void increment(View view){

        price = price +1;
        display(price);
    }
    public void decrement(View view){
        price = price -1;
        if(price < 0){
            price = 0;
            display(price);
        }else {
            display(price);
        }

    }


}
