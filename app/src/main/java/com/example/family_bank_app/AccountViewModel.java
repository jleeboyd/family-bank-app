package com.example.family_bank_app;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class AccountViewModel extends ViewModel {
    public LiveData<List<AccountEntity>> loadAllByIds(Context context) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        return db.accountDao().getAllAccounts();
    }

    public void createAccount(Context context, final AccountEntity newAccount) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.accountDao().insertAccount(newAccount);
        });
    }

    public void deleteUser(Context context, AccountEntity account) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            //TODO Create a deleteAccount method for AccountDAO.
            //db.deleteAccount(accountID)
        });
    }
}