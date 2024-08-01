package org.example;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
public class Crypto {
    String symbol,price;
    int index;

}
