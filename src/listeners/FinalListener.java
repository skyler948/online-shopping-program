package listeners;

import frames.CheckoutFrame;
import frames.ShoppingFrame;
import frames.SuccessFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalListener implements ActionListener {
    private SuccessFrame successFrame;

    public FinalListener(SuccessFrame successFrame) {
        this.successFrame = successFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == successFrame.getShopButton()) {
            successFrame.dispose();
            new ShoppingFrame();
        } else if (e.getSource() == successFrame.getQuitButton()) {
            System.exit(4);
        }

    }
}
