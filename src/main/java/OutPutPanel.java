import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class OutPutPanel extends JPanel implements CalculationReceiver {

    JLabel calculationOutput = new JLabel("0",SwingConstants.RIGHT);
    Color darkestGray = new Color(0x373536);


        OutPutPanel(){
            calculationOutput.setFont(new Font("Helvetica",Font.PLAIN,45));
            calculationOutput.setVerticalAlignment(SwingConstants.TOP);
            calculationOutput.setVerticalTextPosition(SwingConstants.TOP);
            calculationOutput.setForeground(Color.WHITE);
            //calculationOutput.setBackground(Color.DARK_GRAY);
            setBackground(darkestGray);
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            add(calculationOutput,BorderLayout.CENTER);

    }


    @Override
    public void update(double displayDouble,Boolean isDouble) {
            if(isDouble) {
                calculationOutput.setText(String.valueOf(displayDouble));
            }else calculationOutput.setText(String.valueOf((int)displayDouble));
    }
}
