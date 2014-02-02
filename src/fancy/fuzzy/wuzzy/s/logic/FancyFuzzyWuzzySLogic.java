/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fancy.fuzzy.wuzzy.s.logic;



/**
 *
 * @author Javier Segovia @jota_Segovia
 */
public class FancyFuzzyWuzzySLogic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //SubstanceLookAndFeel.setSkin();
        DATA.Conectar.db(); 
        new Configuracion().setVisible(true);
    }
}
