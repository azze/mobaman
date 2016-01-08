import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class HeroTransferable implements Transferable{
	 public static final DataFlavor HERO_DATA_FLAVOR = new DataFlavor(Hero.class, "java/Hero");
	 private Hero hero;
	 public HeroTransferable(Hero hero){
		 this.hero=hero;
	 }
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[]{HERO_DATA_FLAVOR};
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return flavor.equals(HERO_DATA_FLAVOR);
	}

	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
				return hero;
	}

}
