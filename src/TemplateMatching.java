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
	public TemplateMatching()
	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		loss = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss.bmp";
		win = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win.bmp";
		
		loss_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_loss_min.bmp";
		win_min = "C:\\Users\\pcuser\\Desktop\\WinRate\\result_win_min.bmp";
		
		youloss_min = "C:\\pleiades\\workspace\\WinRate2\\youloss_min.bmp";
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
