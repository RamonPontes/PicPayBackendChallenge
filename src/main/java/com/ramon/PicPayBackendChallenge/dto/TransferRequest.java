package com.ramon.PicPayBackendChallenge.dto;

import java.math.BigDecimal;

public class TransferRequest {
    private BigDecimal value;
    private int payer; // send
    private int payee; // receive

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getPayer() {
        return payer;
    }

    public void setPayer(int payer) {
        this.payer = payer;
    }

    public int getPayee() {
        return payee;
    }

    public void setPayee(int payee) {
        this.payee = payee;
    }

    public boolean hasFieldZero() {
        return getValue() == null || getPayee() <= 0 || getPayer() <= 0;
    }
}
