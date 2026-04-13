package listeners;

import items.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemButtonListener implements ActionListener {

    private Item item;

    public ItemButtonListener(Item item) {
        this.item = item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item.getImgButton()) {
            System.out.println("This button will open a window with more specific information on this item.");
        }

        if (e.getSource() == item.getAddButton()) {
            item.modifyItemCount((byte) 1);
        } else if (e.getSource() == item.getSubtractButton()) {
            item.modifyItemCount((byte) -1);
        }
    }

}
