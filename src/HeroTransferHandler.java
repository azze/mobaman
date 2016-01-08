import java.awt.Component;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;

import javax.swing.*;

public class HeroTransferHandler extends TransferHandler {
	@Override
    public boolean canImport(TransferSupport support) {
        return (support.getComponent() instanceof JLabel) && support.isDataFlavorSupported(HeroTransferable.HERO_DATA_FLAVOR);
    }

    @Override
    public boolean importData(TransferSupport support) {
        boolean accept = false;
        if (canImport(support)) {
            try {
                Transferable t = support.getTransferable();
                Object value = t.getTransferData(HeroTransferable.HERO_DATA_FLAVOR);
                if (value instanceof Hero) {
                    Component component = support.getComponent();
                    if (component instanceof JPHLabel) {
                        ((JPHLabel)component).setHero((Hero)value);
                        accept = true;
                    }
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
        return accept;
    }

    @Override
    public int getSourceActions(JComponent c) {
        return DnDConstants.ACTION_COPY_OR_MOVE;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        Transferable t = null;
        if (c instanceof JList) {
            JList list = (JList) c;
            Object value = list.getSelectedValue();
            if (value instanceof Hero) {
                Hero li = (Hero) value;
                t = new HeroTransferable(li);
            }
        }
        return t;
    }

    @Override
    protected void exportDone(JComponent source, Transferable data, int action) {
        System.out.println("ExportDone");
       
    }
}
