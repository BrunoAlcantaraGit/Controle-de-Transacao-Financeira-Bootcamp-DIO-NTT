package org.dio.repository;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.dio.exception.NotFoundEnoughException;
import org.dio.model.AccountWallet;
import org.dio.model.BanckService;

import org.dio.model.Money;
import org.dio.model.MoneyAudit;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonsRepository {

    public static void chekFundsForTransation(final AccountWallet soucer, final long amount){
        if(soucer.getFunds()<amount){
            throw new NotFoundEnoughException("Sua conta não tem dinheiro suficiente para realizar eesa transação ");
        }
    }
public static List<Money> generateMoney(final UUID transactionId, final long funds, final String description){
 var history = new MoneyAudit(transactionId, BanckService.ACCOUNT,description, OffsetDateTime.now());
 return Stream.generate(()-> new Money(history)).limit(funds).toList();

}
}
