/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail.exceptions;

/**
 *
 * @author Laura
 */
public class ReportControlException extends Exception {

    public ReportControlException() {
    }

    public ReportControlException(String string) {
        super(string);
    }

    public ReportControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ReportControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ReportControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
}
