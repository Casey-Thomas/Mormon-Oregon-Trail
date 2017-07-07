/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.exceptions;

/**
 *
 * @author Team
 */
public class UtilitiesControlException extends Exception{

    public UtilitiesControlException() {
    }

    public UtilitiesControlException(String string) {
        super(string);
    }

    public UtilitiesControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public UtilitiesControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public UtilitiesControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
