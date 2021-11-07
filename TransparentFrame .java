import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TransparentFrame extends JFrame{

	public static void main(final String[] args) {
		//OSのウィンドウ装飾を無くして、Look&Feelの装飾にしておきます。
		JFrame.setDefaultLookAndFeelDecorated(true);

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TransparentFrame t = new TransparentFrame(args[0]);
				t.setVisible(true);
			}
		});
	}

	public TransparentFrame(String title) {
		super(title);

		//背景色を透明にします。
		//ウィンドウ装飾を無くしておかないとjre1.7からはエラーが発生します。
		setBackground(new Color(0,0,0,0));

		//jre1.7からisWindowTranslucencySupportedが追加されました。
		//以下の様にして透過に対応しているかどうか調べることができます。
//		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
//		GraphicsDevice gd = ge.getDefaultScreenDevice();
//		boolean supported = gd.isWindowTranslucencySupported(WindowTranslucency.PERPIXEL_TRANSLUCENT);

		setSize(400, 400);
		setDefaultCloseOperation(3);
	}

}