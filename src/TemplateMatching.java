import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatching {
	final int maxsize = 8;
	Mat image;
	Mat win_tmp;
	Mat loss_tmp;
	Mat result;
	private String loss;
	private String win;
	private String loss_min;
	private String win_min;
	private String youloss_min;
	private String youwin_min;

	Mat leader_image;
	Mat temp;

	private String elf = "C:\\pleiades\\workspace\\WinRate2\\elf.bmp";
	private String royal = "C:\\pleiades\\workspace\\WinRate2\\royal.bmp";
	private String witch = "C:\\pleiades\\workspace\\WinRate2\\witch.bmp";
	private String dragon = "C:\\pleiades\\workspace\\WinRate2\\dragon.bmp";
	private String nekura = "C:\\pleiades\\workspace\\WinRate2\\nekura.bmp";
	private String vampire = "C:\\pleiades\\workspace\\WinRate2\\vampire.bmp";
	private String bishop = "C:\\pleiades\\workspace\\WinRate2\\bishop.bmp";
	private String nemesis = "C:\\pleiades\\workspace\\WinRate2\\nemesis.bmp";


	public TemplateMatching()
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		loss = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss.bmp";
		win = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win.bmp";
		loss_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss_min.bmp";
		win_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win_min.bmp";
		//youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youloss_min.bmp";
		youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youloss_min.bmp";
		youwin_min = "C:\\pleiades\\workspace\\WinRate2\\youwin_min.bmp";

		win_tmp = Imgcodecs.imread(youwin_min, Imgcodecs.IMREAD_COLOR);
		loss_tmp = Imgcodecs.imread(youloss_min, Imgcodecs.IMREAD_COLOR);

		result = new Mat();

		temp = Imgcodecs.imread(elf, Imgcodecs.IMREAD_COLOR);;

	}

	public Mat BufferedImage_Mat(BufferedImage im)throws IOException {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    ImageIO.write(im, "jpg", byteArrayOutputStream);
	    byteArrayOutputStream.flush();
	    return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
	}

	public void SetMat(BufferedImage im)
	{
		try {
			image = BufferedImage_Mat(im);
			//mat = BufferedImage_Mat(im);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void SetMat_Leader(BufferedImage im)
	{
		try {
			leader_image = BufferedImage_Mat(im);
			//mat = BufferedImage_Mat(im);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public Boolean Win_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, win_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);

		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}

	public Boolean Loss_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, loss_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}

	public Boolean elf()
	{
		temp = Imgcodecs.imread(elf, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}

	public Boolean royal()
	{
		temp = Imgcodecs.imread(royal, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
	public Boolean witch()
	{
		temp = Imgcodecs.imread(witch, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
	public Boolean dragon()
	{
		temp = Imgcodecs.imread(dragon, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
	public Boolean nekura()
	{
		temp = Imgcodecs.imread(nekura, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
	public Boolean vampire()
	{
		temp = Imgcodecs.imread(vampire, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
	public Boolean bishop()
	{
		temp = Imgcodecs.imread(bishop, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
	public Boolean nemesis()
	{
		temp = Imgcodecs.imread(nemesis, Imgcodecs.IMREAD_COLOR);;
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
}

/*
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatching {
	Mat image;
	Mat win_tmp;
	Mat loss_tmp;
	Mat result;
	private String loss;
	private String win;
	private String loss_min;
	private String win_min;
	private String youloss_min;
	private String youwin_min;

	/////


	/////
	public TemplateMatching()
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		loss = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss.bmp";
		win = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win.bmp";

		loss_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss_min.bmp";
		win_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win_min.bmp";

		//youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youloss_min.bmp";
		youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youwin8.bmp";
		youwin_min = "C:\\pleiades\\workspace\\WinRate2\\youwin_min.bmp";

		win_tmp = Imgcodecs.imread(youwin_min, Imgcodecs.IMREAD_COLOR);
		loss_tmp = Imgcodecs.imread(youloss_min, Imgcodecs.IMREAD_COLOR);

		result = new Mat();
	}

	public Mat BufferedImage_Mat(BufferedImage im)throws IOException {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    ImageIO.write(im, "jpg", byteArrayOutputStream);
	    byteArrayOutputStream.flush();
	    return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
	}

	public void SetMat(BufferedImage im)
	{
		try {
			image = BufferedImage_Mat(im);
			//mat = BufferedImage_Mat(im);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public Boolean Win_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, win_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);

		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}

	public Boolean Loss_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, loss_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
}
*/

/*
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatching {
	final int maxsize = 8;
	Mat image;
	Mat win_tmp;
	Mat loss_tmp;
	Mat result;
	private String loss;
	private String win;
	private String loss_min;
	private String win_min;
	private String youloss_min;
	private String youwin_min;

	Mat leader_image;
	Mat temp;
	private String elf = "C:\\pleiades\\workspace\\WinRate2\\ドラゴン.bmp";


	public TemplateMatching()
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		loss = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss.bmp";
		win = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win.bmp";
		loss_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss_min.bmp";
		win_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win_min.bmp";
		//youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youloss_min.bmp";
		youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youwin8.bmp";
		youwin_min = "C:\\pleiades\\workspace\\WinRate2\\youwin_min.bmp";

		win_tmp = Imgcodecs.imread(youwin_min, Imgcodecs.IMREAD_COLOR);
		loss_tmp = Imgcodecs.imread(youloss_min, Imgcodecs.IMREAD_COLOR);

		result = new Mat();

		temp = Imgcodecs.imread(elf, Imgcodecs.IMREAD_COLOR);;

	}

	public Mat BufferedImage_Mat(BufferedImage im)throws IOException {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    ImageIO.write(im, "jpg", byteArrayOutputStream);
	    byteArrayOutputStream.flush();
	    return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
	}

	public void SetMat(BufferedImage im)
	{
		try {
			image = BufferedImage_Mat(im);
			//mat = BufferedImage_Mat(im);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void SetMat_Leader(BufferedImage im)
	{
		try {
			leader_image = BufferedImage_Mat(im);
			//mat = BufferedImage_Mat(im);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public Boolean Win_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, win_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);

		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}

	public Boolean Loss_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, loss_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}

	public Boolean elf()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(leader_image, temp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
}

/*ウィッチまでマッチングできた

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatching {
	Mat image;
	Mat win_tmp;
	Mat loss_tmp;
	Mat result;
	private String loss;
	private String win;
	private String loss_min;
	private String win_min;
	private String youloss_min;
	private String youwin_min;

	/////


	/////
	public TemplateMatching()
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		loss = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss.bmp";
		win = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win.bmp";

		loss_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss_min.bmp";
		win_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win_min.bmp";

		//youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youloss_min.bmp";
		youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youwin8.bmp";
		youwin_min = "C:\\pleiades\\workspace\\WinRate2\\youwin_min.bmp";

		win_tmp = Imgcodecs.imread(youwin_min, Imgcodecs.IMREAD_COLOR);
		loss_tmp = Imgcodecs.imread(youloss_min, Imgcodecs.IMREAD_COLOR);

		result = new Mat();
	}

	public Mat BufferedImage_Mat(BufferedImage im)throws IOException {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    ImageIO.write(im, "jpg", byteArrayOutputStream);
	    byteArrayOutputStream.flush();
	    return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
	}

	public void SetMat(BufferedImage im)
	{
		try {
			image = BufferedImage_Mat(im);
			//mat = BufferedImage_Mat(im);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public Boolean Win_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, win_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);

		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}

	public Boolean Loss_Maching()
	{
		Boolean Maching = false;
		Imgproc.matchTemplate(image, loss_tmp, result, Imgproc.TM_CCOEFF_NORMED);
		Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);
		for(int i = 0; i < result.rows(); i++)
		{
			for(int j = 0; j < result.cols(); j++)
			{
				if(result.get(i, j)[0] > 0)	Maching = true;
			}
		}

		return Maching;
	}
}
*/