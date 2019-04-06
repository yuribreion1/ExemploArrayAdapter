package br.com.fiap.exemploarrayadapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PaisAdapter extends BaseAdapter {

    Context context;
    String[] paises;

    public PaisAdapter(Context context, String[] paises) {
        this.context = context;
        this.paises = paises;
    }

    @Override
    // Quantos items serão reinderizados
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int position) {
        return this.paises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.adapter_pais, null);

        TextView txtNomePais = view.findViewById(R.id.txtNomePais);
        txtNomePais.setText(paises[position]);

        return view;
    }
}
