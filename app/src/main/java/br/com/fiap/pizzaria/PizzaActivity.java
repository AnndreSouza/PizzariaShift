package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class PizzaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        final CheckBox borda = (CheckBox) findViewById(R.id.IDcheckBorda);
        RadioGroup rg = (RadioGroup) findViewById(R.id.IDgroupRadio);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.IDradioMussa){
                    borda.setEnabled(false);
                    borda.setChecked(false);
                }else {
                    borda.setEnabled(true);
                }
            }
        });
    }



    public void calcular(View view){
        RadioGroup rg = (RadioGroup) findViewById(R.id.IDgroupRadio);

        int selecionado = rg.getCheckedRadioButtonId();
        RadioButton radio = (RadioButton) findViewById(selecionado);

        /*Outra forma de validar o radio selecionado
        * if(selecionado == R.id.rdb_mussarela)*/
        double valor = 0;
        if (radio.getText().equals("Mussarela")){
            valor = 10;
        }else if (radio.getText().equals("Calabresa")){
            valor = 15;
        }else if (radio.getText().equals("Portuguesa")){
            valor = 20;
        }

        CheckBox borda = (CheckBox) findViewById(R.id.IDcheckBorda);
        if (borda.isChecked()){
            valor = valor +5;
        }

        //Recuperar a forma de pagamento selecionada
        Spinner formaPagamento = (Spinner) findViewById(R.id.IDspinner);
        String pagamento = (String) formaPagamento.getSelectedItem();

        Toast.makeText(this, radio.getText() + " " + valor + "\n" + pagamento, Toast.LENGTH_SHORT).show();

        //ir para a tela de checkout
        Intent intent = new Intent(this, CheckoutActivity.class);
        //enviar informacoes para outra tela
        intent.putExtra("pizza", radio.getText());
        intent.putExtra("valor", valor);
        intent.putExtra("borda", borda.isChecked());
        intent.putExtra("pagamento", pagamento);
        startActivity(intent);

    }
}
