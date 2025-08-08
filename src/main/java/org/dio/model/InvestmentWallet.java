package org.dio.model;

import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

@ToString
@Getter
public class InvestmentWallet extends Wallet{

private final Investment investment;
private final AccountWallet account;


    protected InvestmentWallet(BanckService service, Investment investment, AccountWallet account, final long amount) {
        super(BanckService.INVESTIMENT);
        this.investment = investment;
        this.account = account;
        addMoney(account.reduceMoney(amount), getService(),"Investimento");
    }

    public void updateAmount(final Long percent){
        var amout = getFunds() * percent / 100;
        var history = new MoneyAudit(UUID.randomUUID(),getService(),"Rendimentos", OffsetDateTime.now());
        var money= Stream.generate(()-> new Money(history)).limit(amout).toList();
        this.money.addAll(money);
    }
}
