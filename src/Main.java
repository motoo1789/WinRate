import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application
{

	Capture3 cap3;
	Preview pre;

	//kkk
	private Button open_bt;
	private Button set1_bt;
	private Button set2_bt;
	private Button start_bt;
	private Button preview_bt;

	private Text open_text = new Text("ウィンドウを開く");
	private Text winloss_text = new Text("勝敗のマッチング用");
	private Text leader_text = new Text("リーダー判定用");
	private Text start_text = new Text("マッチングスタート");



	public static void main(String[] args)
	{
		launch(args);

	}

	public void start(Stage stage)throws Exception
	{
		open_bt = new Button();
		set1_bt = new Button();
		set2_bt = new Button();
		start_bt = new Button();
		preview_bt = new Button();

		open_bt.setText("Open");
		set1_bt.setText("1つ目");
		set2_bt.setText("2つ目");
		start_bt.setText("Start");
		preview_bt.setText("preview");

		GridPane grid  = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);;
		grid.setVgap(10);

		grid.add(open_text, 1, 0);
		grid.add(winloss_text, 1, 1);
		grid.add(leader_text, 1, 2);
		grid.add(start_text, 1, 3);
		grid.add(open_bt,2,0);
		grid.add(set1_bt, 2, 1);
		grid.add(set2_bt, 2, 2);
		grid.add(start_bt, 2, 3);



		/*BorderPane bp = new BorderPane();

		VBox hb = new VBox();

		hb.getChildren().add(open_bt);
		hb.getChildren().add(start_bt);
		hb.getChildren().add(preview_bt);

		bp.setCenter(hb);
		/*
		bp.setRight(set_bt);
		bp.setCenter(start_bt);
		bp.setBottom(preview_bt);
		*/

		open_bt.setOnAction(new kyaputyaEventHandler_o());
		set1_bt.setOnAction(new kyaputyaEventHandler_1());
		set2_bt.setOnAction(new kyaputyaEventHandler_2());
		start_bt.setOnAction(new kyaputyaEventHandler_s());
		preview_bt.setOnAction(new kyaputyaEventHandler_p());

		Scene sc = new Scene(grid,300,300);

		stage.setScene(sc);
		stage.setTitle("メニュー");
		stage.show();
	}

	public class kyaputyaEventHandler_o implements EventHandler<ActionEvent>
	{


		@Override
		public void handle(ActionEvent event) {
			cap3 = new Capture3();
		}
	}

	public class kyaputyaEventHandler_1 implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) {
			cap3.set1();
		}
	}

	public class kyaputyaEventHandler_2 implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) {
			cap3.set2();

		}
	}

	public class kyaputyaEventHandler_s implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) {
			//cap3.copyScreen();
			cap3.thread_start();
			cap3.thread_start_Leader();
		}
	}

	public class kyaputyaEventHandler_p implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent event) {
			new Preview();

		}
	}

}
