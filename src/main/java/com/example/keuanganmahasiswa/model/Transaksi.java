package com.example.keuanganmahasiswa.model;

public class Transaksi {
    private int id,userId,nominal;
    private String jenis_transaksi;
    public Transaksi(int id, int userId, int nominal, String jenis_transaksi) {
        this.id = id;
        this.userId = userId;
        this.nominal = nominal;
        this.jenis_transaksi = jenis_transaksi;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getJenisTransaksi() {
        return jenis_transaksi;
    }

    public void setJenisTransaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }
}
