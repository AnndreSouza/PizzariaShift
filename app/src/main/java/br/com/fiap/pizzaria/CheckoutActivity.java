package br.com.fiap.pizzaria;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //recuperar a informação enviada pela outra activity(PizzaActivity)
        String pizza = getIntent().getExtras().getString("pizza");
        boolean borda = getIntent().getExtras().getBoolean("borda");
        String pagamento = getIntent().getExtras().getString("pagamento");
        double valor = getIntent().getExtras().getDouble("valor");

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(pizza + " " + valor + " " + "\nBorda: " + borda + "\n" + pagamento);
    }


    public void finalizar(View view){
        //dial
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel://11976530000"));
        startActivity(intent);
    }
}
