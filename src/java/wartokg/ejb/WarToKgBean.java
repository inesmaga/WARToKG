/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wartokg.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author inesm
 */
@Stateless
@LocalBean
public class WarToKgBean {



//Calculando Tasa de Metabolismo Basal con Peso Actual
 public static double getTMBpa(Double Pesoa, String Altura, Integer Ed, String Sex){
     Double TMBpa=0.00;
 int Altu= Integer.valueOf(Altura);
if(Sex.equals("M")){
TMBpa = Math.rint((66+(13.7*Pesoa))+((5*Altu)-(6.8*Ed)));
}else{
if(Sex.equals("F")){
    TMBpa=  Math.rint((655 +(9.6 * Pesoa))+ ((1.8 * Altu)- (4.7 * Ed)));
}
}
logger.log(Level.INFO, "TMB con Peso Actual is:{0}", TMBpa);
 return TMBpa;
 }
 //Calculando Tasa de Metabolismo Basal con Peso Ideal
 public static double getTMBpi(Double Pesoid, String Altura, Integer Ed, String Sex){
     Double TMBpi=0.00;
 int Altu= Integer.valueOf(Altura);
if(Sex.equals("M")){
TMBpi =Math.rint((66+(13.7*Pesoid))+((5*Altu)-(6.8*Ed)));
}else{
if(Sex.equals("F")){
    TMBpi=  Math.rint((655 +(9.6 * Pesoid))+ ((1.8 * Altu)- (4.7 * Ed)));
}
}
 return TMBpi;
 }
 //Calculando Kcal/dia para mantener peso Actual
 public static double getKcalMP(Double TMBpa,Double Fact){
  Double KcalMP=0.00;
 if (TMBpa!=0 & Fact!=0){
 KcalMP=  Math.rint(TMBpa*Fact);
 }
 return KcalMP;
  }
 
 //Calculando Kcal/dia para bajar del  peso Actual
 public static double getKcalAd(Double Kcal){
  Double KcalAd=0.00;
 if (Kcal!=0){
 KcalAd= Math.rint(Kcal*0.8);
 }
 return KcalAd;
  }
 

  private static final Logger logger = 
          Logger.getLogger("wartokg.ejb.WarToKgBean");   
}
