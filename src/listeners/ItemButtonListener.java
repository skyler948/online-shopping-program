package listeners;

import items.Item;
import menubars.ShoppingMenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemButtonListener implements ActionListener {

    private Item item;
    private ShoppingMenuBar bar;

    public ItemButtonListener(Item item, ShoppingMenuBar bar) {
        this.item = item;
        this.bar = bar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item.getImgButton()) {
            System.out.println("This button will open a window with more specific information on this item.");
        }

        if (e.getSource() == item.getAddButton()) {
            item.modifyItemCount((byte) 1);
            bar.updateSubtotalLabel();
        } else if (e.getSource() == item.getSubtractButton()) {
            item.modifyItemCount((byte) -1);
            bar.updateSubtotalLabel();
        }
    }

}
