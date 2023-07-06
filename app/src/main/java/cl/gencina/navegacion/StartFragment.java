package cl.gencina.navegacion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.gencina.navegacion.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {

    private FragmentStartBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStartBinding.inflate(getLayoutInflater(), container, false);
        binding.btnComenzar.setOnClickListener(v -> sendName());
        return binding.getRoot();
    }

    private void sendName() {
        String nombre = binding.etvNombre.getText().toString();
        if(!nombre.isEmpty()){
            Bundle bundle = new Bundle();
            bundle.putString("nombre", nombre);
            Navigation.findNavController(binding.getRoot()).navigate(R.id.action_startFragment_to_questionFragment,bundle);
        }else{
            Toast.makeText(getContext(),"Ingrese un nombre para continuar", Toast.LENGTH_LONG).show();
        }
    }
}