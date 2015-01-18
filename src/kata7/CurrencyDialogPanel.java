package kata7;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CurrencyDialogPanel extends JPanel implements CurrencyDialog{

    private String code;
    
    public CurrencyDialogPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
        this.add(createComboBox());
        code = "EUR";
    }

    private JComboBox createComboBox() {
        final JComboBox comboBox = new JComboBox (new String [] {"EUR", "USD", "GBP"});
        comboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if(ie.getStateChange() != ItemEvent.SELECTED) return;
                code = (String) comboBox.getSelectedItem();
            }
        });
        return comboBox;
    }

    @Override
    public Currency getCurrency() {
        return new Currency(code);
    }
}