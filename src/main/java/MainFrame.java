import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    MainFrame(){
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        InputPanel inputPanel = new InputPanel();
        OutPutPanel outPutPanel = new OutPutPanel();
        inputPanel.addCalculationReceiver(outPutPanel);

        Dimension calcSize = new Dimension(width*2/11,height*2/5);
        setPreferredSize(calcSize);
        setLocationRelativeTo(null);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.fill = GridBagConstraints.VERTICAL;

        setLayout(gridBagLayout);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(outPutPanel,gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.ipady = 140;
        add(inputPanel,gbc);

        setResizable(false);
        pack();

        //setUndecorated(true);
        //setOpacity(0.99f);
        setVisible(true);

    }
}
