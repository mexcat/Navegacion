package cl.gencina.navegacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import cl.gencina.navegacion.databinding.FragmentResponseBinding;

public class ResponseFragment extends Fragment {

    private static final String ARG_PARAM1 = "nombre";
    private static final String ARG_PARAM2 = "resultado";

    private String nombreParam;
    private String resultParam;
    private FragmentResponseBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombreParam = getArguments().getString(ARG_PARAM1);
            resultParam = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String text = "";
        binding = FragmentResponseBinding.inflate(getLayoutInflater(), container, false);
        if(Objects.equals(resultParam, "Correcto")){
            binding.tvRespuesta.setText(nombreParam +", eres todo un/una maestro/a pokemón!!!");
        }else{
            binding.tvRespuesta.setText(nombreParam +", está equivocado/a. ");
        }
        binding.btnReiniciar.setOnClickListener(v -> volverAlInicio());
        return binding.getRoot();
    }

    private void volverAlInicio() {
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_responseFragment_to_startFragment);
    }
}