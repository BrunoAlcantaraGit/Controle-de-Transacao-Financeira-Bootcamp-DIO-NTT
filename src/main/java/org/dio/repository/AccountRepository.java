package org.dio.repository;

import org.dio.exception.AccountNotFoundException;
import org.dio.model.AccountWallet;

import java.util.List;

import static org.dio.repository.CommonsRepository.chekFundsForTransation;

public class AccountRepository {

    private List<AccountWallet> account;

    public AccountWallet create(final List<String> pix, final long initialFunds) {
        var newAccount = new AccountWallet(initialFunds, pix);

        return newAccount;

    }

    public void deposit(final String pix, final long fundsAmount) {
        var target = findByPix(pix);
        target.addMoney(fundsAmount, "depósito");
    }


    public long withdraw(final String pix, final long amonut) {
        var soucer = findByPix(pix);
        chekFundsForTransation(soucer, amonut);
        soucer.reduceMoney(amonut);
        return amonut;
    }

    public void tranferMoney(final String soucerPix, final String targetPix, final long amount){
        var soucer= findByPix(soucerPix);
        chekFundsForTransation(soucer,amount);
        var target = findByPix(soucerPix);
        var message = "pix enviadro de "+ soucerPix + "para" + targetPix + "'";
        target.addMoney(soucer.reduceMoney(amount),soucer.getService(), message);
    }

    public AccountWallet findByPix(final String pix) {
        return account.stream()
                .filter(a -> a.getPix().contains(pix))
                .findFirst().orElseThrow(() -> new AccountNotFoundException("A conta com a chave pix" + pix + "não foi encontrada"));
    }


}
