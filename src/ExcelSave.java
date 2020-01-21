
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSave extends AbstractSave{
	private final int maxsize = 16;
	private int Win[] = new int[8];
	private int Loss[] = new int[8];
	private Iterator it;

	static final String Input_DIR = "C:\\Users\\motoo\\Desktop\\WinRate\\";
	private FileInputStream in;
	private Workbook wb = null;
	private FileOutputStream out;

	public ExcelSave(Object leadershelf_save) throws IOException{
		LeaderShelf leaderShelf = (LeaderShelf) leadershelf_save;
		it = leaderShelf.iterator();
		while(it.hasNext()) {
			int index = it.returnIndex();
			Leader leader = (Leader) it.next();
			System.out.println(index);
			if(index == 8) break;	//配列のサイズは８なので途中でブレイク
			Win[index] = leader.WinRead();
			Loss[index] = leader.LossRead();
		}
	}

	@Override
	protected void open() {
		// TODO 自動生成されたメソッド・スタブ

		//変更するエクセルファイルを指定
		try {
			in = new FileInputStream(Input_DIR + "WinRate.xlsx");
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//既存のエクセルファイルを編集する
		try {
			wb = WorkbookFactory.create(in);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@Override
	protected void print() {
		int index = 0;
		Calendar cal = Calendar.getInstance();
		Date dt = new Date();

		// TODO 自動生成されたメソッド・スタブ

		//ファイルのシートを取得
		Sheet sheet = wb.getSheet("VEC");

		//0Vのセルにある最後に値が入っている行を取得
		Row row = sheet.getRow(0);	//	最後の行数ヲ示しているセルをしらべるために使うやつ
		Cell cell = row.getCell(21);	//　上に同じく
		int numericValue = (int) cell.getNumericCellValue();
		cell.setCellValue(numericValue + 1);

		//セルに値をセットしていく
		Row row_set = sheet.getRow(numericValue);
		//日付を最初に入れr
		Cell cell_set = row_set.getCell(0);
		cell_set.setCellValue(cal.get(Calendar.YEAR) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.DATE));

		for(int i = 1; i <= maxsize; i++) {
			int num = 0;	//入れる数字

			/////////////Winを入れるかLossを入れるかの判定
			if(i % 2 != 0) {
				num = Win[index];
			}
			else {
				num = Loss[index++];	//Loosの場合はindexを１つ加算
			}
			/////////////

			cell_set = row_set.getCell(i);
			//セルに勝敗を入れる
			cell_set.setCellValue(num);

			//ここからファイルの実際の書き込み
			out = null;
			try {
				out = new FileOutputStream(Input_DIR + "WinRate.xlsx");
			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//書き込み
			try {
				wb.write(out);
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		//最後の行の値を＋１
//		cell.setCellValue(numericValue);
//		out = null;
//		try {
//			out = new FileOutputStream(Input_DIR + "WinRate.xlsx");
//		} catch (FileNotFoundException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
//		//書き込み
//		try {
//			wb.write(out);
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
	}

	@Override
	protected void close() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			out.close();
			wb.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}


}
