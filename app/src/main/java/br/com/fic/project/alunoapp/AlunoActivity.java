package br.com.fic.project.alunoapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AlunoActivity extends AppCompatActivity {
    private EditText alunoEdit;
    private ListView lsAlunos;
    private List<String> listAlunos;
    private ArrayAdapter<String> itemsAdapter;
    private String aluno;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        alunoEdit = (EditText) findViewById(R.id.alunoAdd);
        lsAlunos = (ListView) findViewById(R.id.lsAlunos);
        listAlunos = new ArrayList<String>();
        aluno = alunoEdit.getText().toString();
        listAlunos.add(aluno);

        itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listAlunos);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                lsAlunos.setAdapter(itemsAdapter);
                Snackbar.make(view, "Aluno " +aluno+ " Adicionado!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                alunoEdit.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_aluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
