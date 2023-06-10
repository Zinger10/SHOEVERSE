package com.example.shoeverse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.shoeverse.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_first,container,false);
        /*
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
        */

        ImageView nikeImageView = view.findViewById(R.id.nike);
        ImageView pumaImageView = view.findViewById(R.id.puma);
        ImageView adidasImageView = view.findViewById(R.id.adidas);
        nikeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)requireActivity()).showDonutOrder(view);
            }
        });

        pumaImageView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)requireActivity()).showIceCreamOrder(view);
            }
        }));

        adidasImageView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)requireActivity()).showFroyoOrder(view);
            }
        }));
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}