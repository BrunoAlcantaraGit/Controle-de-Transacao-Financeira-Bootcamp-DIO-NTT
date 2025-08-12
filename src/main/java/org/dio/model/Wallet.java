package org.dio.model;

import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@ToString
public abstract class Wallet {
    @Getter
private final BanckService service;

    protected final List<Money> money;

    protected Wallet(BanckService service) {
        this.service = service;
        this.money = new ArrayList<>();
    }

    protected  List<Money>genereteMany(final long amount, final String description){
    var history = new MoneyAudit(UUID.randomUUID(),service, description, OffsetDateTime.now());
    return Stream.generate(()->new Money(history)).limit(amount).toList();

    }

    public long getFunds(){
        return money.size();
    }

    public void addMoney(final List<Money> money, final BanckService service, final String description){
        var history = new MoneyAudit(UUID.randomUUID(), service,description,OffsetDateTime.now());
        money.forEach(m->m.addHistory(history));
        this.money.addAll(money);
    }

    public List<Money> reduceMoney(final long amount){
        List<Money>toRemove = new ArrayList<>();
        for (int i = 0; i < amount; i++){
        toRemove.add(this.money.remove(0));
        }

        return toRemove;
    }


    public List<MoneyAudit> getFinanceTransation(){
        return money.stream().flatMap(m-> m.getHistory().stream()).toList();
    }
}
