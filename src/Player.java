import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Player extends JFrame{
	String[] leader = {"エルフ","ロイヤル","ウィッチ","ドラゴン","ネクロ","ヴァンプ","ビショップ","ネメシス","トータル"};
	int maxsize = 9;
	//LeaderShelf leadershelf = new LeaderShelf(9);
	private JFrame frame;

	Rectangle bounds_start = getBounds();
	JLabel leader_label[] = new JLabel[maxsize];
	JLabel winloss_label[] = new JLabel[maxsize];
	JPanel p = new JPanel();

	public Player()
	{

		for(int i = 0; i < maxsize; i++) {
        	leader_label[i] = new JLabel();
        	leader_label[i].setText(leader[i]);
        	leader_label[i].setHorizontalAlignment(JLabel.CENTER);
        	leader_label[i].setFont(new Font("ＭＳ ゴシック", Font.BOLD, 24));
        	winloss_label[i] = new JLabel();
        	winloss_label[i].setText("0-0");
        	winloss_label[i].setHorizontalAlignment(JLabel.CENTER);
        	winloss_label[i].setFont(new Font("Arial", Font.PLAIN, 64));
        }


		// 範囲を指定してキャプチャ
        Rectangle bounds = new Rectangle(100, 100, 500, 500);	//ウィンドウの初期状態
        setTitle("勝敗表示");
        setBounds(bounds);		//サイズを指定（ここでは初期状態のやつ↑）
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//×ボタンをつける
        setVisible(true);

        p.setLayout(new GridLayout(6,3,5,5));
        for(int tmp = 0; tmp < maxsize / 3; tmp++)
        {
        	for(int i = 0; i < maxsize / 3; i++)
            {
            	p.add(leader_label[maxsize / 3 * tmp + i],BorderLayout.NORTH);
            }
            for(int i = 0; i < maxsize / 3; i++)
            {
            	p.add(winloss_label[maxsize / 3 * tmp + i],BorderLayout.NORTH);
            }
        }


        JComponent content = (JComponent)getContentPane();
        content.setOpaque(false);		//パネルの背景透明・非透明

        Container contentPane = getContentPane();
        contentPane.add(p, BorderLayout.CENTER);


	}

	public void Win(Object leadershelf_cap)
	{
		LeaderShelf leadershelf = (LeaderShelf) leadershelf_cap;
		Iterator it = leadershelf.iterator();

		while(it.hasNext()) {
			int index = it.returnIndex(); //itからどこをやってるかのindexをもらう
			Leader leader = (Leader)it.next();
			String win = Integer.toString(leader.WinRead());
			String loss = Integer.toString(leader.LossRead());
			winloss_label[index].setText(win + "-" + loss);
		}

		repaint();
	}

	public void Loss(Object leadershelf_cap)
	{
		LeaderShelf leadershelf = (LeaderShelf) leadershelf_cap;
		Iterator it = leadershelf.iterator();

		while(it.hasNext()) {
			int index = it.returnIndex(); //itからどこをやってるかのindexをもらう
			Leader leader = (Leader)it.next();
			String win = Integer.toString(leader.WinRead());
			String loss = Integer.toString(leader.LossRead());
			winloss_label[index].setText(win + "-" + loss);
		}
		repaint();
	}

//	public int WinRead()
//	{
//		return Win;
//	}
//
//	public int LossRead()
//	{
//		return Loss;
//	}

	public static void main(String[] args) {
	 	new Player();
	 }
}
