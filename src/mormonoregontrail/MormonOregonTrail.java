/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mormonoregontrail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import mormonoregontrail.model.Game;
import mormonoregontrail.model.Player;
import mormonoregontrail.view.ErrorView;
import mormonoregontrail.view.StartProgramView;

public class MormonOregonTrail {
    
    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        
        // @Team - added try . . . catch - 6/28/2017
        try {
            // open character stream files for end user input and output
            MormonOregonTrail.inFile =
                    new BufferedReader(new InputStreamReader(System.in));
            MormonOregonTrail.outFile = new PrintWriter(System.out, true);

            try {
                // open log file
                String filePath = "mylog.txt";
                MormonOregonTrail.logFile = new PrintWriter(filePath);
            } catch (Exception e) {
                ErrorView.display("MormonOregonTrail",
                                  "Error Opening Log File:" + e.getMessage());
            }
            // create StartProgramViewOrig and display the start program view
            StartProgramView startProgramView = new StartProgramView();
            
            startProgramView.displayStartProgramView();
//            startProgramView.display();

        } catch (Throwable te) {
            ErrorView.display("MormonOregonTrail",
                               "Exception: " + te.toString() +
                               "\nCause: " + te.getCause() +
                               "\nMessage: " + te.getMessage());
            te.printStackTrace();
        } finally {
            try {
                if (MormonOregonTrail.inFile != null)
                    MormonOregonTrail.inFile.close();
                if (MormonOregonTrail.outFile != null)
                    MormonOregonTrail.outFile.close();
                if (MormonOregonTrail.logFile != null)
                    MormonOregonTrail.logFile.close();
            } catch (IOException ex) {
                ErrorView.display("MormonOregonTrail",
                                  "Error closing files");
                return;
            }
        }
        
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        MormonOregonTrail.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        MormonOregonTrail.player = player;
    }
    
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        MormonOregonTrail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        MormonOregonTrail.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        MormonOregonTrail.logFile = logFile;
    }
    
}
