package com.example.lailson.calculadora;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.*;
import android.view.*;

public class ActMain extends AppCompatActivity implements View.OnClickListener {

    private EditText editValorA;
    private EditText editValorB;
    private Button btnCalcular;
    private ImageView imageView2;
    private Spinner operation_spinner;
    private ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main); //seta o layout

        //O metodo findViewById faz uma referencia aos componentes virtuais colocados na tela.
        //Ele retorna uma view.

        editValorA = (EditText) findViewById(R.id.editValorA);
        editValorB = (EditText) findViewById(R.id.editValorB);

        //A seguir é criado um evento para quando o botao for clicado
        btnCalcular = (Button) findViewById(R.id.btnCalcular); //é preciso registrar o evento para o botao
        btnCalcular.setOnClickListener(this); //this esta passandoa referencia da classe q ta implementando a interface OnListener
        //sobre o LISTENER: é a implementacao do design partrner Observer

        //A seguir é criado um evento para quando a imagem for clicada
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(this);

        //configuracoes para o spinner
        operation_spinner = (Spinner) findViewById(R.id.operation_spinner);
        adapter = ArrayAdapter.createFromResource(this,R.array.operacoes_names,android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        // Apply the adapter to the spinner
        operation_spinner.setAdapter(adapter);

    }

    //O metodo a seguir dispara a acao do botao
    public void onClick(View v){

        String vA = editValorA.getText().toString();
        String vB = editValorB.getText().toString();


        final AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        if (v == imageView2){
            dlg.setMessage("imageView - Calculadora");
            dlg.setNeutralButton("OKA",null); //o null é pra n acionar nada da janela de dialogo.
            dlg.show();
        }

        if (v == btnCalcular){

        //verifica se a caixa esta vazia
        if  (vA.trim().isEmpty() || vB.trim().isEmpty()){
            dlg.setMessage("Há dados em branco!");
            dlg.setNeutralButton("OKA",null); //o null é pra n acionar nada da janela de dialogo.
            dlg.show();
        } else {
            final double valorA = Double.parseDouble(editValorA.getText().toString());
            final double valorB = Double.parseDouble(editValorB.getText().toString());
            String textoSpinner = operation_spinner.getSelectedItem().toString();
            if (textoSpinner.equals("Soma")) {
                System.out.print(textoSpinner);
                double resultadoSoma = valorA + valorB;
                //o this a seguir passa a referencia do Activity que vai ta exibindo a msg.
                dlg.setMessage("Resultado: " + resultadoSoma);
                dlg.setNeutralButton("OKA", null); //o null é pra n acionar nada da janela de dialogo.
                dlg.show();
            } else if (textoSpinner.equals("Subtracao")) {
                double resultadoSubtracao = valorA - valorB;
                //o this a seguir passa a referencia do Activity que vai ta exibindo a msg.

                dlg.setMessage("Resultado: " + resultadoSubtracao);
                dlg.setNeutralButton("OKA", null); //o null é pra n acionar nada da janela de dialogo.
                dlg.show();
            } else if (textoSpinner.equals("Multiplicacao")) {
                double resultadoMultiplicacao = valorA * valorB;
                //o this a seguir passa a referencia do Activity que vai ta exibindo a msg.

                dlg.setMessage("Resultado: " + resultadoMultiplicacao);
                dlg.setNeutralButton("OKA", null); //o null é pra n acionar nada da janela de dialogo.
                dlg.show();
            } else if (textoSpinner.equals("Divisao")) {
                if(valorB==0){
                    dlg.setMessage("MATH ERROR");
                    dlg.setNeutralButton("OKA", null); //o null é pra n acionar nada da janela de dialogo.
                    dlg.show();
                }else {
                    double resultadoDivisao = valorA / valorB;
                    //o this a seguir passa a referencia do Activity que vai ta exibindo a msg.

                    dlg.setMessage("Resultado: " + resultadoDivisao);
                    dlg.setNeutralButton("OKA", null); //o null é pra n acionar nada da janela de dialogo.
                    dlg.show();
                }
            }
        }
        }

//        operation_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
//
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

    }

}
