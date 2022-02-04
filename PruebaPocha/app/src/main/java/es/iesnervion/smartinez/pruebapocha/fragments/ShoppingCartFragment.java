package es.iesnervion.smartinez.pruebapocha.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.List;

import es.iesnervion.smartinez.pruebapocha.R;
import es.iesnervion.smartinez.pruebapocha.adapters.ShoppingCarAdapter;
import es.iesnervion.smartinez.pruebapocha.dataaccess.entities.bo.ProductBO;
import es.iesnervion.smartinez.pruebapocha.dataaccess.viewmodels.ShoppingCartViewModel;
import es.iesnervion.smartinez.pruebapocha.databinding.FragmentShoppingCartBinding;

public class ShoppingCartFragment extends Fragment {

    private FragmentShoppingCartBinding binding;
    private ShoppingCartViewModel shoppingCartViewModel;

    public ShoppingCartFragment() {
        // Required empty public constructor
    }

    public static ShoppingCartFragment newInstance() {
        ShoppingCartFragment fragment = new ShoppingCartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            shoppingCartViewModel = new  ViewModelProvider(this).get(ShoppingCartViewModel.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentShoppingCartBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    //    shoppingCartViewModel.getProductList().observe(getViewLifecycleOwner(),this::onProductLoaded);
    }

    private void onProductLoaded(List<ProductBO> productList) {
   //     binding.shoppingCarRecyclerviewProductList.setAdapter();
    }
}