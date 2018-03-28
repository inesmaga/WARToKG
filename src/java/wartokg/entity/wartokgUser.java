/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wartokg.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author inesm
 */
@Entity
public class wartokgUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    protected int edad;
    protected int altura;
    protected String sexo;
    protected double IMC;
    protected String Valorac;
    protected double PesoAc;
    protected double TMBpa;
    protected double PesoId;
    protected double TMBpi;
    protected double KcalMP;
    protected double KcalAd;
    
    protected double FAf;
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getValorac() {
        return Valorac;
    }

    public void setValorac(String Valorac) {
        this.Valorac = Valorac;
    }

    public double getPesoAc() {
        return PesoAc;
    }

    public void setPesoAc(double PesoAc) {
        this.PesoAc = PesoAc;
    }

    public double getPesoId() {
        return PesoId;
    }

    public void setPesoId(double PesoId) {
        this.PesoId = PesoId;
    }

   

 

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getFAf() {
        return FAf;
    }

    public void setFAf(double FAf) {
        this.FAf = FAf;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }

    public double getTMBpa() {
        return TMBpa;
    }

    public void setTMBpa(double TMBpa) {
        this.TMBpa = TMBpa;
    }

    public double getTMBpi() {
        return TMBpi;
    }

    public void setTMBpi(double TMBpi) {
        this.TMBpi = TMBpi;
    }

   

    public double getKcalMP() {
        return KcalMP;
    }

    public void setKcalMP(double KcalMP) {
        this.KcalMP = KcalMP;
    }

    public double getKcalAd() {
        return KcalAd;
    }

    public void setKcalAd(double KcalAd) {
        this.KcalAd = KcalAd;
    }

   

   

    public wartokgUser() {
    }

    public wartokgUser(Long id, int edad, int altura, String sexo, double IMC, String Valorac, double PesoAc, double TMBpa, double PesoId, double TMBpi, double KcalMP, double KcalAd, double FAf) {
        this.id = id;
        this.edad = edad;
        this.altura = altura;
        this.sexo = sexo;
        this.IMC = IMC;
        this.Valorac = Valorac;
        this.PesoAc = PesoAc;
        this.TMBpa = TMBpa;
        this.PesoId = PesoId;
        this.TMBpi = TMBpi;
        this.KcalMP = KcalMP;
        this.KcalAd = KcalAd;
        this.FAf = FAf;
    }

   


   
}
