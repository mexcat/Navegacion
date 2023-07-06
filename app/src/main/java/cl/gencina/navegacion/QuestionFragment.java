package cl.gencina.navegacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.gencina.navegacion.databinding.FragmentQuestionBinding;

public class QuestionFragment extends Fragment {
    private String nombreParam;
    private FragmentQuestionBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombreParam = getArguments().getString("nombre");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuestionBinding.inflate(getLayoutInflater(), container, false);
        binding.tvSaludoPersonalizado.setText("Hola, "+ nombreParam);
        binding.btnResponder.setOnClickListener(v -> checkRespuesta());
        return binding.getRoot();
    }

    private void checkRespuesta() {
        if(binding.gbRespuestas.getCheckedRadioButtonId() == binding.rb1.getId()){
            sendResult("Correcto");
        }else if(binding.gbRespuestas.getCheckedRadioButtonId()  == -1){
            Toast.makeText(getContext(), "Seleccione una opción", Toast.LENGTH_LONG).show();
        }else{
            sendResult("Error");
        }
    }
    private void sendResult(String result) {
            Bundle bundle = new Bundle();
            bundle.putString("nombre", nombreParam);
            bundle.putString("resultado", result);
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_questionFragment_to_responseFragment,bundle);
    }
}