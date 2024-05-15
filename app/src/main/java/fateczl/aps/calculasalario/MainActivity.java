package fateczl.aps.calculasalario;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fateczl.aps.calculasalario.model.Professor;
import fateczl.aps.calculasalario.model.ProfessorHorista;
import fateczl.aps.calculasalario.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbTitular;
    private RadioButton rbHorista;

    private EditText etHorasTrabaladas;
    private EditText etValorHora;
    private EditText etAnosDeInstituicao;
    private EditText etSalario;

    private TextView tvSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbTitular = findViewById(R.id.rbProfessorTitular);
        rbTitular.setChecked(true);
        rbHorista = findViewById(R.id.rbProfessorHorista);

        etHorasTrabaladas = findViewById(R.id.etHorasTrabalhadas);
        etValorHora = findViewById(R.id.etValorHora);
        etAnosDeInstituicao = findViewById(R.id.etAnosDeInstituicao);
        etSalario = findViewById(R.id.etSalarioAtual);

        tvSalario = findViewById(R.id.tvSalario);

        Button btnCalcularsalario = findViewById(R.id.btnCalcularSalario);
        btnCalcularsalario.setOnClickListener(op -> calcularSalario());
    }

    private void calcularSalario() {

        if(rbTitular.isChecked()){
            ProfessorTitular professorTitular = new ProfessorTitular();
            professorTitular.setAnosInstituicao(Integer.parseInt(etAnosDeInstituicao.getText().toString()));
            professorTitular.setSalario(Double.parseDouble(etSalario.getText().toString()));
            Double salarioLiquido = professorTitular.calcSalario();

            String res = getString(R.string.tvSalario) + salarioLiquido.toString();
            tvSalario.setText(res);
        }

        if (rbHorista.isChecked()){
            ProfessorHorista professorHorista = new ProfessorHorista();
            professorHorista.setHorasAula(Integer.parseInt(etHorasTrabaladas.getText().toString()));
            professorHorista.setValorHoraAula(Double.parseDouble(etValorHora.getText().toString()));
            Double salarioLiquido = professorHorista.calcSalario();

            String res = getString(R.string.tvSalario) + salarioLiquido.toString();
            tvSalario.setText(res);

        }

        etHorasTrabaladas.setText("");
        etValorHora.setText("");
        etAnosDeInstituicao.setText("");

    }
}