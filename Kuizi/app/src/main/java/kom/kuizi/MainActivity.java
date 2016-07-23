package kom.kuizi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import Pyetje.Pyetje;

public class MainActivity extends AppCompatActivity{

    private Button mButtonSakte;
    private Button mButtonPasakte;
    private ImageButton mImageButtonNext;
    private ImageButton mImageButtonPrev;
    private TextView mTextViewPyetja;

    private Pyetje[] mGrupiPyetjeve = new Pyetje[]{
            new Pyetje(R.string.pyetja_ngyrat, false),
            new Pyetje(R.string.pyetja_metodatCreate, false),
            new Pyetje(R.string.pyetja_classR, true),
            new Pyetje(R.string.pyetja_strings, true)
    };

    private int mIndeksiAktual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonSakte = (Button) findViewById(R.id.buttonSakte);
        mButtonPasakte = (Button) findViewById(R.id.buttonPasakte);
        mImageButtonNext = (ImageButton) findViewById(R.id.imageButtonVazhdo);
        mImageButtonPrev = (ImageButton) findViewById(R.id.imageButtonPrapa);
        mTextViewPyetja = (TextView)findViewById(R.id.textViewPyetja);

        perditesoPyetjet(); //qeta pe thirri per me ma mbush n'start textviewin se e like blank

        //Krijimi i listenerit per klikimin e butonit sakte
        mButtonSakte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kontrolloPergjigjen(true);
            }
        });

        mButtonPasakte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kontrolloPergjigjen(false);
            }
        });

        mImageButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndeksiAktual = (mIndeksiAktual + 1) % mGrupiPyetjeve.length;
                perditesoPyetjet();
                Toast.makeText(MainActivity.this, "Pyetja para!", Toast.LENGTH_SHORT).show();
            }
        });

        mImageButtonPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndeksiAktual = (mIndeksiAktual - 1) % mGrupiPyetjeve.length;
                if(mIndeksiAktual == -1){
                    mIndeksiAktual = mGrupiPyetjeve.length - 1;
                }
                perditesoPyetjet();
                Toast.makeText(MainActivity.this, "Pyetja prapa!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void perditesoPyetjet(){
        int question = mGrupiPyetjeve[mIndeksiAktual].getTextResourceId();
        mTextViewPyetja.setText(question);
    }

    private void kontrolloPergjigjen(boolean klientiPergjigja){
        boolean pergjigjaSakte = mGrupiPyetjeve[mIndeksiAktual].getPergjigjaSakte();
        int mesazhiResId = 0;
        if(klientiPergjigja == pergjigjaSakte){
            mesazhiResId = R.string.pergjigja_sakte;
        }else {
            mesazhiResId = R.string.pergjigja_pasakte;
        }
        Toast.makeText(this, mesazhiResId, Toast.LENGTH_SHORT).show();
    }
}
