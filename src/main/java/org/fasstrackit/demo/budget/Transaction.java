package org.fasstrackit.demo.budget;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Type;

@RequiredArgsConstructor
@Getter
@Builder
public class Transaction {
    public final long id;
    public final String product;
    public final Type SELL;
    public final Type BUY;

    public final Double minAmount;
    public final Double maxAmount;

}
