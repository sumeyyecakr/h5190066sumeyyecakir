package com.h5190066.sumeyye_cakir_final.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MakyajModel {
    @SerializedName("Adi")
    @Expose
    private String adi;
    @SerializedName("Aciklama")
    @Expose
    private String aciklama;
    @SerializedName("KullanimAlani")
    @Expose
    private String kullanimAlani;
    @SerializedName("RenkSecenekleri")
    @Expose
    private String renkSecenekleri;
    @SerializedName("BannerUrl")
    @Expose
    private String bannerUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getKullanimAlani() {
        return kullanimAlani;
    }

    public void setKullanimAlani(String kullanimAlani) {
        this.kullanimAlani = kullanimAlani;
    }

    public String getRenkSecenekleri() {
        return renkSecenekleri;
    }

    public void setRenkSecenekleri(String renkSecenekleri) {
        this.renkSecenekleri = renkSecenekleri;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

}
