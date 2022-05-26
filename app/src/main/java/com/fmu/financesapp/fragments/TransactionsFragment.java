package com.fmu.financesapp.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fmu.financesapp.MainActivity;
import com.fmu.financesapp.R;
import com.fmu.financesapp.adapters.AccountsListAdapter;
import com.fmu.financesapp.adapters.nestedRecyclerView.TransactionParentAdapter;
import com.fmu.financesapp.dao.AccountDao;
import com.fmu.financesapp.model.TransactionParent;

import java.util.ArrayList;


public class TransactionsFragment extends Fragment {

    private final AccountDao accountList = new AccountDao();
    private ArrayList<TransactionParent> transactionParentsList = new ArrayList<>();
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transactions, container, false);
        transactionParentsList.add(new TransactionParent("20 de maio", accountList.all()));
        RecyclerView rvTransactions = view.findViewById(R.id.rvTransactionCard) ;
        TransactionParentAdapter parentAdapter = new TransactionParentAdapter(transactionParentsList);
        rvTransactions.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvTransactions.setAdapter(parentAdapter);
        return view;

    }
}