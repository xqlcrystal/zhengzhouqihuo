package com.crystal.domain;

import java.sql.Date;

public class FutureDataTradeamt {
    private int rankingvol;
    private int rankingamount;
    private String memberno;
    private String membername;
    private double vol;
    private double amount;
    private Date curdate;

    public int getRankingvol() {
        return rankingvol;
    }

    public void setRankingvol(int rankingvol) {
        this.rankingvol = rankingvol;
    }

    public int getRankingamount() {
        return rankingamount;
    }

    public void setRankingamount(int rankingamount) {
        this.rankingamount = rankingamount;
    }

    public String getMemberno() {
        return memberno;
    }

    public void setMemberno(String memberno) {
        this.memberno = memberno;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCurdate() {
        return curdate;
    }

    public void setCurdate(Date curdate) {
        this.curdate = curdate;
    }

    @Override
    public String toString() {
        return "FutureDataTradeamt{" +
                "rankingvol=" + rankingvol +
                ", rankingamount=" + rankingamount +
                ", memberno='" + memberno + '\'' +
                ", membername='" + membername + '\'' +
                ", vol=" + vol +
                ", amount=" + amount +
                ", curdate=" + curdate +
                '}';
    }
}
