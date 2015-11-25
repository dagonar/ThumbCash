package com.thumbcash.helpers;

import java.util.Date;

/**
 *
 * @author Dagonar
 */
public class Card {
    
    private String card_num;
    private String cvc;
    private String type = null;
    private Date expire;
    
    public Card(String card_num, String cvc, Date expire) {
        this.card_num = card_num;
        this.cvc = cvc;
        this.expire = expire;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
    
}
