import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class InputPanel extends JPanel implements CalculationBroadcaster{
    Color darkOrange = new Color(0xF59A13);
    Color mediumGray = new Color(0x666464);
    Color darkGray = new Color(0xFF494848, true);
    Color darkestGray = new Color(0x373536);

    double previousDouble = 0.0;
    double currentDouble = 0.0;
    Boolean isDouble = false;
    Function function = Function.ADD;
    Boolean isFunctionPrevious = false;

    ArrayList<CalculationReceiver> calculationReceivers = new ArrayList<>();

    InputPanel(){

        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        setBorder(new EmptyBorder(-2, -1, -2, -1));

        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;

        JButton button1 = setUpButton("1",mediumGray,false);
        button1.addActionListener(e -> {
        crunch(1.0);
        isFunctionPrevious = false;
        });

        JButton button2 = setUpButton("2",mediumGray,true);
        button2.addActionListener(e -> {
            crunch(2.0);
            isFunctionPrevious = false;
        });

        JButton button3 = setUpButton("3",mediumGray,false);
        button3.addActionListener(e ->  {
            crunch(3.0);
            isFunctionPrevious = false;
        });

        JButton button4 = setUpButton("4",mediumGray,true);
        button4.addActionListener(e ->  {
            crunch(4.0);
            isFunctionPrevious = false;
        });

        JButton button5 = setUpButton("5",mediumGray,false);
        button5.addActionListener(e ->  {
            crunch(5.0);
            isFunctionPrevious = false;
        });

        JButton button6 = setUpButton("6",mediumGray,true);
        button6.addActionListener(e ->  {
            crunch(6.0);
            isFunctionPrevious = false;
        });

        JButton button7 = setUpButton("7",mediumGray,false);
        button7.addActionListener(e ->  {
            crunch(7.0);
            isFunctionPrevious = false;
        });

        JButton button8 = setUpButton("8",mediumGray,true);
        button8.addActionListener(e ->  {
            crunch(8.0);
            isFunctionPrevious = false;
        });

        JButton button9 = setUpButton("9",mediumGray,false);
        button9.addActionListener(e ->  {
            crunch(9.0);
            isFunctionPrevious = false;
        });

        JButton button0 = setUpButton("0",mediumGray,true);
        button0.addActionListener(e -> {
            crunch(0.0);
            isFunctionPrevious = false;
        });

        JButton buttonPercent = setUpButton("%",darkGray,true);
        buttonPercent.addActionListener(e -> {
            currentDouble = currentDouble/100;
            isDouble = true;
            calculationBroadcast(currentDouble, true);
        });

        JButton buttonAC = setUpButton("AC",darkGray,true);
        buttonAC.addActionListener(
                e -> {
                    currentDouble = 0;
                    isDouble = false;
                    calculationBroadcast(currentDouble, false);
                });

        JButton buttonPlusMinusSign = setUpButton("+/-",darkGray,false);
        buttonPlusMinusSign.addActionListener(e -> {
            if(currentDouble >0 ){
                currentDouble = currentDouble*-1;
            }else currentDouble = Math.abs(currentDouble);
            calculationBroadcast(currentDouble,isDouble);
        });
        JButton buttonDecimal = setUpButton(".",mediumGray,true);
        buttonDecimal.addActionListener(e -> {
            isDouble = true;
            calculationBroadcast(currentDouble,true);
        });

        //TODO, when function is pressed, tell numbers to stop adding to end of previousDouble
        JButton buttonPlus = setUpButton("+",darkOrange,true);
        buttonPlus.addActionListener(e -> {
            currentDouble = previousDouble+currentDouble;
            previousDouble = 0;
            calculationBroadcast(currentDouble,isDouble);
            function = Function.ADD;
            isFunctionPrevious = true;

        });

        JButton buttonMinus = setUpButton("-",darkOrange,false);
        buttonMinus.addActionListener(e -> {
            function = Function.MINUS;
            isFunctionPrevious = true;
        });

        JButton buttonMultiply = setUpButton("x",darkOrange,true);
        buttonMultiply.addActionListener(e -> {
            function = Function.MULTIPLY;
            isFunctionPrevious = true;
        });

        JButton buttonDivide = setUpButton("/",darkOrange,false);
        buttonDivide.addActionListener(e -> {
            function = Function.DIVIDE;
            isFunctionPrevious = true;
        });

        JButton buttonEquals = setUpButton("=",darkOrange,false);
        buttonEquals.addActionListener(e -> {
            double numb = 0.0;
            switch (function){
                case ADD -> numb = previousDouble+currentDouble;
                case MINUS -> numb = previousDouble-currentDouble;
                case MULTIPLY -> numb = previousDouble*currentDouble;
                case DIVIDE -> numb = previousDouble/currentDouble;
            }
            calculationBroadcast(numb,isDouble);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;

        add(buttonAC,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;

        add(buttonPlusMinusSign,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;

        add(buttonPercent,gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;

        add(buttonDivide,gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(button7,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        add(button8,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;

        add(button9,gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;

        add(buttonMultiply,gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(button4,gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;

        add(button5,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;

        add(button6,gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;

        add(buttonMinus,gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;

        add(button1,gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;

        add(button2,gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;

        add(button3,gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;

        add(buttonPlus,gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        add(button0,gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(buttonDecimal,gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        add(buttonEquals,gbc);

    }

    private void crunch(double num){
        if(!isDouble && !isFunctionPrevious){
            previousDouble = currentDouble;
            currentDouble = num;
            String toDisplay = (int)previousDouble+""+(int)currentDouble;
            currentDouble = Double.parseDouble(toDisplay);
            calculationBroadcast(currentDouble,isDouble);

        }else if(isDouble && !isFunctionPrevious){
            previousDouble = currentDouble;
            currentDouble = num;
            String toDisplay = previousDouble+""+currentDouble;
            currentDouble = Double.parseDouble(toDisplay);
            calculationBroadcast(currentDouble,isDouble);
        } else if(isDouble){
            previousDouble = currentDouble;
            currentDouble = num;
            calculationBroadcast(num,isDouble);
        } else{
            previousDouble = currentDouble;
            currentDouble = num;
            calculationBroadcast((int)num,isDouble);
        }
    }
    private JButton setUpButton(String name,Color backColor, Boolean isBordered){
        JButton jButton = new JButton(name);
        jButton.setFont(new Font("Helvetica",Font.PLAIN,20));
        jButton.setOpaque(true);
        jButton.setBackground(backColor);
        jButton.setForeground(Color.WHITE);

        if(isBordered) {
            jButton.setBorder(BorderFactory.createLineBorder(darkestGray));
        }else jButton.setBorder(BorderFactory.createEmptyBorder());

        return jButton;
    }

    @Override
    public void addCalculationReceiver(CalculationReceiver calculationReceiver) {
            calculationReceivers.add(calculationReceiver);
    }

    @Override
    public void removeCalculationReceiver(CalculationReceiver calculationReceiver) {
            calculationReceivers.remove(calculationReceiver);
    }

    @Override
    public void calculationBroadcast(double displayNumber,Boolean isDouble) {
        for(CalculationReceiver calculationReceiver: calculationReceivers){
            calculationReceiver.update(displayNumber,isDouble);
        }
    }
}
