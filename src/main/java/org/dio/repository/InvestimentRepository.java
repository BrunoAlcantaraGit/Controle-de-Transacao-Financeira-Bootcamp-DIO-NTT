package org.dio.repository;

import lombok.ToString;
import org.dio.exception.InvestmentNotFoundException;
import org.dio.exception.WalletNotFoundExeption;
import org.dio.model.Investment;
import org.dio.model.InvestmentWallet;

import java.util.ArrayList;
import java.util.List;

@ToString
public class InvestimentRepository {

    private final List<Investment> investments = new ArrayList<>();
    private final List<InvestmentWallet> wallets = new ArrayList<>();

    public void updateAmount(final long percet){
        wallets.forEach(w->w.updateAmount(percet));
    }


    public Investment findbyID(final long id) {
        return investments.stream()
                .filter(i -> i.id() == id)
                .findFirst()
                .orElseThrow(
                        () -> new InvestmentNotFoundException("nenhum investimento id:" + id + "Não encontrado")
                );
    }

    public InvestmentWallet findWalletByAccountPix(final String pix) {
        return wallets.stream()
                .filter(w -> w.getAccount().getPix().contains(pix))
                .findFirst()
                .orElseThrow(() -> new WalletNotFoundExeption(" A carteira não foi encontrada"));
    }


}
