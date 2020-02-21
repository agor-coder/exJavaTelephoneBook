/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.javastart.telephonebook.App;

import pl.javastart.telephonebook.TeleBookController;

/**
 *
 * @author ET4
 */
public class AppTeleBook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TeleBookController controller=new TeleBookController();
        controller.loop();
    }
    
}
