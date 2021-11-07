import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;

public class Capture3 extends JFrame implements ComponentListener, MouseListener{
	//private Preview pre;
	private TemplateMatching tm;
	private TemplateMatching_Leader tm_l;
	private LeaderShelf leaderShelf;
	private Player player;
	private int flag = 0;

	private Robot robot;
	private JFrame frame;
	private BufferedImage image;
	private BufferedImage image_Leader;
	Rectangle bounds_set1 = getBounds();
	Rectangle bounds_set2 = getBounds();
	boolean threadRunning;
	boolean threadRunning_Leader;

	//かり
	//	イテレータ = new playershell()
	public Capture3()
	{

		try {
            robot = new Robot();		//ロボット使えるようにする
        } catch (AWTException ex) {
            ex.printStackTrace();
            return;
        }

		//pre = new Preview();
		tm = new TemplateMatching();
		tm_l = new TemplateMatching_Leader();
		player = new Player();
		leaderShelf = new LeaderShelf(9);

		addComponentListener(this);//ウィンドウ移動イベント追加
        addMouseListener(this);	//マウスイベント追加
        // 範囲を指定してキャプチャ
        Rectangle bounds = new Rectangle(100, 100, 400, 400);	//ウィンドウの初期状態

        setTitle("YouWin-YouLossキャプチャ画面");
        setBounds(bounds);		//サイズを指定（ここでは初期状態のやつ↑）
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//×ボタンをつける

        setRootPane(new ImageRootPane());

        JComponent content = (JComponent)getContentPane();
        content.setOpaque(false);		//パネルの背景透明・非透明

        //JLabel label = new JLabel(new ImageIcon(image));
        //getContentPane().add(label);

        setVisible(true); //initで一度初期状態を見せる


	}

	public void copyScreen() {
		// TODO 自動生成されたメソッド・スタブ
        image = robot.createScreenCapture(bounds_set1);	//範囲指定したやつをrobotでスクショ
        //pre.SetView(image);
	}
	public void copyScreen_Leader() {
		// TODO 自動生成されたメソッド・スタブ
		image_Leader = robot.createScreenCapture(bounds_set2);	//範囲指定したやつをrobotでスクショ
        //pre.SetView(image);
	}

	public void set1() { flag++; setTitle("リーダー");}
	public void set2() {

	}

	/////////////ウィンドウのイベント
	@Override
	public void componentResized(ComponentEvent e) {	//	ウィンドウのサイズが変わったら
		//setVisible(false);
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void componentMoved(ComponentEvent e) {		//	ウィンドウが移動したら
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Rush");

	}

	@Override
	public void componentShown(ComponentEvent e) {		//	ウィンドウが表示されたら
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void componentHidden(ComponentEvent e) {		//	ウィンドウがかくれたら
		// TODO 自動生成されたメソッド・スタブ

	}

	////////////マウス
	@Override
	public void mouseClicked(MouseEvent e) {			//	クリックされたら
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void mousePressed(MouseEvent e) {			//	押され続けてたら
		// TODO 自動生成されたメソッド・スタブ

	}
	@Override
	public void mouseReleased(MouseEvent e) {			//	マウスを離したら
		// TODO 自動生成されたメソッド・スタブ
				setVisible(false);	//最初にフレームとかを隠すようにした

				Rectangle bounds = getBounds();		//	四角で範囲指定するために必要なやつ
		        Insets insets = getInsets();		//	フレーム内のサイズ？

		        bounds = new Rectangle(bounds.x + insets.left,
		        						bounds.y + insets.top,
		        						bounds.width - insets.left - insets.right,
		        						bounds.height - insets.top - insets.bottom);	//フレーム内の範囲
		        try {
					Thread.sleep(150);
				} catch (InterruptedException e2) {
					// TODO 自動生成された catch ブロック
					e2.printStackTrace();
				}
		        if(flag == 0) {
		        	image = robot.createScreenCapture(bounds);	//範囲指定したやつをrobotでスクショ
		        	bounds_set1 = bounds;
		        }
		        else if(flag == 1) {
		        	image_Leader = robot.createScreenCapture(bounds);	//範囲指定したやつをrobotでスクショ
		        	bounds_set2 = bounds;
		        }



//		        //JLabel label = new JLabel(new ImageIcon(image));	//イメージをラベルに入れる　いらない
//		        //getContentPane().add(label);	※addだと前のやつが残る

		        setVisible(true);	//隠したウィンドウを元に戻す
	}
	@Override
	public void mouseEntered(MouseEvent e) {			//	マウスがコンポネートに入ったら
		// TODO 自動生成されたメソッド・スタブ

	}
	@Override
	public void mouseExited(MouseEvent e) {				//	マウスがコンポネートからでたら
		// TODO 自動生成されたメソッド・スタブ

	}


	public void thread_start(){
		threadRunning = true;
		setVisible(false);	//最初にフレームとかを隠すようにした
		new Thread(() -> {
			while(threadRunning) {
				long interval = 50;
				long time = System.currentTimeMillis();
				time = System.currentTimeMillis() - time;
				copyScreen();
				tm.SetMat(image);
				if	(tm.Win_Maching()) {
					System.out.println("Win");
					leaderShelf.Win();
					player.Win(leaderShelf);
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				else if(tm.Loss_Maching()){
					System.out.println("Loss");
					leaderShelf.Loss();
					player.Loss(leaderShelf);
					try {
						Thread.sleep(20000);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
				if (time <= interval) {
					try {
						Thread.sleep(interval - time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}

	public void thread_start_Leader(){
		threadRunning_Leader = true;
		setVisible(false);	//最初にフレームとかを隠すようにした
		new Thread(() -> {
			while(threadRunning_Leader) {
				long interval = 50;
				long time = System.currentTimeMillis();
				time = System.currentTimeMillis() - time;
				copyScreen_Leader();
				tm_l.SetMat(image_Leader);
				leaderShelf.chngeindex(tm_l.Leader_Maching());
				System.out.println("leaderMaching!!");
				File outputfile = new File("image.jpg");
		        try {
					ImageIO.write(image_Leader, "jpg", outputfile);
				} catch (IOException e1) {
					// TODO 自動生成された catch ブロック
					e1.printStackTrace();
				}
				if (time <= interval) {
					try {
						Thread.sleep(interval - time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}).start();
	}
	///
	//救世主↓ imageの描画?
	///
	class ImageRootPane extends JRootPane {
        public void paintComponent(Graphics g) {
        	if(flag == 0)
        	{
        		g.drawImage(image, 0, 0, this);
        	}
        	else {
        		g.drawImage(image_Leader, 0, 0, this);
        	}
        }
    }

//	class Watcher extends Thread{
//		public synchronized void wakeup() {
//			notifyAll();
//		}
//
//		public void run() {
//			while(true) {
//				try {
//					setVisible(false);	//最初にフレームとかを隠すようにした
//
//					Thread.sleep(1000);
//					copyScreen();
//
//				} catch (InterruptedException e) {
//					// TODO 自動生成された catch ブロック
//					e.printStackTrace();
//				}
//
//			}
//		}
//	}

	public static void main(String[] args) {
	 	new Capture3();
	 }


}
