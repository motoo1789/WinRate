import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TransparentFrame extends JFrame{

	public static void main(final String[] args) {
		//OS�̃E�B���h�E�����𖳂����āALook&Feel�̑����ɂ��Ă����܂��B
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

		//�w�i�F�𓧖��ɂ��܂��B
		//�E�B���h�E�����𖳂����Ă����Ȃ���jre1.7����̓G���[���������܂��B
		setBackground(new Color(0,0,0,0));

		//jre1.7����isWindowTranslucencySupported���ǉ�����܂����B
		//�ȉ��̗l�ɂ��ē��߂ɑΉ����Ă��邩�ǂ������ׂ邱�Ƃ��ł��܂��B
//		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
//		GraphicsDevice gd = ge.getDefaultScreenDevice();
//		boolean supported = gd.isWindowTranslucencySupported(WindowTranslucency.PERPIXEL_TRANSLUCENT);

		setSize(400, 400);
		setDefaultCloseOperation(3);
	}

}