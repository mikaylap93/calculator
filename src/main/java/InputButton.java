import javax.swing.*;
import java.awt.*;

public class InputButton extends JButton {

    Color darkestGray = new Color(0x373536);

    InputButton(String name, Color backGroundColor, Boolean isBordered) {

        setText(name);
        setFont(new Font("Helvetica", Font.PLAIN, 20));
        setOpaque(true);
        setBackground(backGroundColor);
        setForeground(Color.WHITE);

        if (isBordered) {
            setBorder(BorderFactory.createLineBorder(darkestGray));
        } else setBorder(BorderFactory.createEmptyBorder());

    }
}

