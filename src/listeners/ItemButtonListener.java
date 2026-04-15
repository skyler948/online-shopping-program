package listeners;

import frames.InfoFrame;
import frames.ShoppingFrame;
import items.Item;
import menubars.ShoppingMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemButtonListener implements ActionListener {

    private Item item;
    private ShoppingFrame shoppingFrame;
    private InfoFrame infoFrame;

    public ItemButtonListener(Item item, ShoppingFrame shoppingFrame) {
        this.item = item;
        this.shoppingFrame = shoppingFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item.getImgButton()) {
            if (infoFrame == null) {
                infoFrame = new InfoFrame(item, shoppingFrame);
            } else if (!infoFrame.isVisible()) {
                infoFrame = new InfoFrame(item, shoppingFrame);
            }
        }

        if (e.getSource() == item.getAddButton()) {
            item.modifyItemCount((byte) 1);
            shoppingFrame.getBar().updateSubtotalLabel();
        } else if (e.getSource() == item.getSubtractButton()) {
            item.modifyItemCount((byte) -1);
            shoppingFrame.getBar().updateSubtotalLabel();
        }
    }

}
