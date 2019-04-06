package br.com.fiap.exemploarrayadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spnPais;
    String[] paises = {
        "Argentina",
        "Afeganistão",
        "Argelia",
        "Arzeibaijão",
        "Bolivia",
        "Brasil",
        "Camaroes",
        "Croacia",
        "Dinamarca",
        "Eslovaquia",
        "Finlandia",
        "Zimbabue"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("Trabalhando com layouts");

        spnPais = findViewById(R.id.spnPAis);
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);
        PaisAdapter adapter = new PaisAdapter(this, paises);

        spnPais.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    public void salvar(View view) {
        int posicao = spnPais.getSelectedItemPosition();
        String selecionado = (String) spnPais.getSelectedItem();

        String msg = String.format("(%d) %s", posicao, selecionado);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
