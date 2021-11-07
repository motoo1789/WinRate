import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class Preview extends JFrame{

	private JFrame frame;
	private BufferedImage image;
	boolean threadRunning;
	Rectangle bounds_start = getBounds();

	public Preview()
	{
        // 範囲を指定してキャプチャ
        Rectangle bounds = new Rectangle(100, 100, 400, 400);	//ウィンドウの初期状態

        setBounds(bounds);		//サイズを指定（ここでは初期状態のやつ↑）
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//×ボタンをつける
        setTitle("Preview");
        setRootPane(new ImageRootPane());

        JComponent content = (JComponent)getContentPane();
        content.setOpaque(false);		//パネルの背景透明・非透明

        //JLabel label = new JLabel(new ImageIcon(image));
        //getContentPane().add(label);

        setVisible(true); //initで一度初期状態を見せる


	}

	public void SetView(BufferedImage view) {

		// TODO 自動生成されたメソッド・スタブ
        image = view;	//範囲指定したやつをrobotでスクショ
        setVisible(true); //initで一度初期状態を見せる
        System.out.println("プニキ");
        repaint();
      
	}
	/////////////ウィンドウのイベント



	///
	//救世主↓ imageの描画?
	///
	class ImageRootPane extends JRootPane {
        public void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, this);
        }
    }



	public static void main(String[] args) {
	 	new Preview();
	 }


}
