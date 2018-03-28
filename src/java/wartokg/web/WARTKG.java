/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wartokg.web;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.validation.constraints.NotNull;
import wartokg.ejb.WarToKgBean;

/**
 *
 * @author inesm
 */
@Named(value = "WARTKG")
@SessionScoped
public class WARTKG implements Serializable {

    @EJB
    private WarToKgBean warToKgBean;
    @NotNull
    protected int Edad;
    @NotNull
    protected int Altu;
    protected int Edud;
    protected Double Imc;
    protected String Valorac;
    @NotNull
    protected String Sexo;
    @NotNull
    protected Double PesoAc;
    @NotNull
    protected Double Af;
    protected Double PesoId;
    protected Double TMBpa;
    protected Double TMBpi;
    protected Double KcalMP;
    protected Double KcalAd;
    private int number1;
    private String Altura;
    private static final Logger logger = Logger.getLogger("wartokg.ejb.WarToKgBean");

    public WARTKG() {

        TMBpa = 0.00;
        TMBpi = 0.00;
        KcalMP = 0.00;
        KcalAd = 0.00;

        Valorac = "";

    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getEdud() {
        return Edud;
    }

    public void setEdud(int Edud) {
        this.Edud = Edud;
    }

    public String getAltura() {
        return Altura;
    }

    public void setAltura(String altura) {
        this.Altura = altura;
    }

    public int getAltu() {
        return Integer.parseInt(Altura);
    }

    public void setAltu(int Altu) {
        this.Altu = Integer.parseInt(Altura);
    }

    public Double getPesoAc() {
        return PesoAc;
    }

    public void setPesoAc(Double PesoAc) {
        this.PesoAc = PesoAc;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public Double getAf() {
        return Af;
    }

    public void setAf(Double Af) {
        this.Af = Af;
    }

    public Double getTMBpa() {
        return TMBpa;
    }

    public void setTMBpa(Double TMBpa) {
        this.TMBpa = TMBpa;
    }

    public Double getTMBpi() {
        return TMBpi;
    }

    public void setTMBpi(Double TMBpi) {
        this.TMBpi = TMBpi;
    }

    public Double getKcalMP() {
        return KcalMP;
    }

    public void setKcalMP(Double KcalMP) {
        this.KcalMP = KcalMP;
    }

    public Double getKcalAd() {
        return KcalAd;
    }

    public void setKcalAd(Double KcalAd) {
        this.KcalAd = KcalAd;
    }

    public Double getImc() {
        return Imc;
    }

    public void setImc(Double Imc) {
        this.Imc = Imc;
    }

    public String getValorac() {
        return Valorac;
    }

    public void setValorac(String Valorac) {
        this.Valorac = Valorac;
    }

    public Double getPesoId() {
        return PesoId;
    }

    public void setPesoId(Double PesoId) {
        this.PesoId = PesoId;
    }

    public String processYourWar() {
        ImcClient iclient = new ImcClient();
        String ic = iclient.getImc(PesoAc, Altura);
        Imc = Double.valueOf(ic);
        logger.log(Level.INFO, "Imc {0}", Imc);
        ValoracClient vclient = new ValoracClient();
        Valorac = vclient.getText(Imc);
        logger.log(Level.INFO, "Valorac actual {0}", Valorac);
       
        if (Edad >= 20 & Edad <= 29) {
            Edud = 20;
        } else {
            if (Edad >= 30 & Edad <= 39) {
                Edud = 30;
            } else {
                if (Edad >= 40 & Edad <= 49) {
                    Edud = 40;
                } else {
                    if (Edad >= 50 & Edad <= 59) {
                        Edud = 50;
                    } else {
                        if (Edad >= 60 & Edad <= 69) {
                            Edud = 60;
                        }
                    }
                }
            }
        }
         PesoIdealClient pclient = new PesoIdealClient();
        String c = pclient.findXPeso(Altura, Sexo, Edud);
        PesoId = Double.valueOf(c);
        logger.log(Level.INFO, "tu peso ideal {0}", PesoId);
        this.setTMBpa(WarToKgBean.getTMBpa(PesoAc, Altura, Edad, Sexo));
        logger.log(Level.INFO, "TMB peso actual {0}", TMBpa);
        this.setTMBpi(WarToKgBean.getTMBpi(PesoId, Altura, Edad, Sexo));
        logger.log(Level.INFO, "TMB peso ideal {0}", TMBpi);
        this.setKcalMP(WarToKgBean.getKcalMP(TMBpa, Af));
        logger.log(Level.INFO, "Kcal/dia peso actual {0}", KcalMP);
        this.setKcalAd(WarToKgBean.getKcalAd(KcalMP));
        logger.log(Level.INFO, "Kcal/dia para Adelgazar {0}", KcalAd);
        return "/response.xhtml";
    }

}
