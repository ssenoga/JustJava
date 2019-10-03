package andriod.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    int price = 0;
    private String userName;
    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user_name);

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

        // find the check box and check if its checked or not
        CheckBox checkBox = (CheckBox) findViewById(R.id.check);

        boolean is_checked = checkBox.isChecked();
        Log.v("MainActivity","has checked the variable " + is_checked);


        userName = user.getText().toString();
        TextView priceTextView = findViewById(R.id.price_txt_view);
        String p = "Total: "+NumberFormat.getCurrencyInstance(Locale.US).format(price);
        p += "\n Thank you "+ userName;
//        priceTextView.setText(p);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffe order for "+userName);
        intent.putExtra(Intent.EXTRA_TEXT,p);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

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
