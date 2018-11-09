package Controllers;

import Utils.Constants;
import Utils.IO;
import Views.Main_Frame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class MainController {

    Main_Frame frame = null;

    public static void main(String args[]) {
        MainController mainController = new MainController();
    }

    public MainController() {
        initView();
    }

    private void initView() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            frame = new Main_Frame();

            UpdateStatusText("");

            frame.setVisible(true);
        });

        // Register callbacks
        Main_Frame.onMatchScreenClicked.addListener((x) -> OnMatchWindow());
        Main_Frame.onApplyClicked.addListener((dimension) -> OnApplyCustomResolution(dimension));
    }

    private void OnApplyCustomResolution(Dimension dimensionSettings) {
        int width = dimensionSettings.width;
        int height = dimensionSettings.height;

        if (width < 100 || height < 100) {
            UpdateStatusText("ERROR: Incorrect usage of text fields!");
            return;
        }

        UpdateResolutionInFile(dimensionSettings.width, dimensionSettings.height);
    }

    private void OnMatchWindow() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();

        int width = (int) Math.round(screenDimension.getWidth());
        int height = (int) Math.round(screenDimension.getHeight());

        UpdateResolutionInFile(width, height);
    }

    private void UpdateStatusText(String text) {
        if (frame != null) {
            frame.SetStatusText(text);
        }
    }

    private void UpdateResolutionInFile(int width, int height) {
        UpdateStatusText("Updated resolution to " + width + " x " + height + "!");
        String resolutionString = String.format("%s = %s %s", Constants.C_RESOLUTION_PREFIX, width, height);
        IO.ReplaceLine(Constants.C_RESOLUTION_PREFIX, resolutionString);
    }
}
