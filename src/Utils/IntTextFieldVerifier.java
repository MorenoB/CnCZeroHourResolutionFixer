package Utils;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class IntTextFieldVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        JTextField textField = (JTextField) input;

        if (StringExtensions.isInteger(textField.getText())) {
            return true;
        } else {
            textField.setText("0");
            return false;
        }
    }

}
