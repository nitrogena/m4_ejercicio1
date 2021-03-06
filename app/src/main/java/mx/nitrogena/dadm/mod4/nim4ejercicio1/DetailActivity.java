package mx.nitrogena.dadm.mod4.nim4ejercicio1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import mx.nitrogena.dadm.mod4.nim4ejercicio1.fragments.ListFragment;
import mx.nitrogena.dadm.mod4.nim4ejercicio1.fragments.ProfileFragment;
import mx.nitrogena.dadm.mod4.nim4ejercicio1.model.ItemModel;

/**
 * Created by USUARIO on 18/06/2016.
 */
public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private String strUsuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //comunicacion entre actividades
        //String strUsuario = getIntent().getExtras().getString("cveUsuario");
        strUsuario = getIntent().getExtras().getString("cveUsuario");
        String strBienvenida = String.format(getString(R.string.bienvenida), strUsuario);

        TextView tvMensajeB = (TextView) findViewById(R.id.adetail_tv_bienvenida);
        tvMensajeB.setText(strBienvenida);
        findViewById(R.id.adetail_bt_verPerfil).setOnClickListener(this);
        findViewById(R.id.adetail_bt_verLista).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.adetail_bt_verPerfil:
                mostrarPerfil();
                break;
            case R.id.adetail_bt_verLista:
                mostrarLista();
                break;
        }
    }

    //usando fragments
    private void mostrarPerfil() {
        //Toast.makeText(getApplicationContext(),getApplicationContext().getResources().getString(R.string.amain_pb_usuarioNoEncontrado),Toast.LENGTH_SHORT).show();
        //ProfileFragment prFr = ProfileFragment.instanciar("Estás en la sección de perfil");
        ProfileFragment prFr = ProfileFragment.instanciar(strUsuario);
        getFragmentManager().beginTransaction().replace(R.id.adetail_frL_fragmentHolder, prFr).commit();
    }

    private void mostrarLista() {
        //Toast.makeText(getApplicationContext(),getApplicationContext().getResources().getString(R.string.amain_pb_usuarioEncontrado),Toast.LENGTH_SHORT).show();
        //ProfileFragment prFr = ProfileFragment.instanciar("lista");
        getFragmentManager().beginTransaction().replace(R.id.adetail_frL_fragmentHolder, new ListFragment()).commit();
    }


    public void onItemSelected(ItemModel itemModel) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
        ProfileFragment prFrDet = ProfileFragment.instanciar(itemModel.item);
        getFragmentManager().beginTransaction().replace(R.id.adetail_frL_fragmentHolder, prFrDet).commit();


        //Toast.makeText(getApplicationContext(),"Ver datos",Toast.LENGTH_SHORT).show();

    }




}