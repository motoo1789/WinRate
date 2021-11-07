import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class TemplateMatching_Leader {
	final int maxsize = 8;
	Mat image;
	Mat tmp[];
	Mat result;
	Mat temp;
	private String elf;
	private String royal;
//	private String witch;
//	private String dragon;
//	private String nekura;
//	private String vampire;
//	private String bishop;
//	private String nemesis;
	private String leader[];

	public TemplateMatching_Leader() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		tmp = new Mat[maxsize];
		leader = new String[maxsize];

		leader[0] = "C\\pleiades\\workspace\\WinRate2\\エルフ.bmp";
		leader[1] = "C\\pleiades\\workspace\\WinRate2\\ロイヤル.bmp";
		leader[2] = "C\\pleiades\\workspace\\WinRate2\\ウィッチ.bmp";
		leader[3] = "C\\pleiades\\workspace\\WinRate2\\ドラゴン.bmp";
		leader[4] = "C\\pleiades\\workspace\\WinRate2\\ネクロ.bmp";
		leader[5] = "C\\pleiades\\workspace\\WinRate2\\ヴァンプ.bmp";
		leader[6] = "C\\pleiades\\workspace\\WinRate2\\ヴィショップ.bmp";
		leader[7] = "C\\pleiades\\workspace\\WinRate2\\ネメシス.bmp";


		for(int i = 0; i < maxsize; i++)
		{
			tmp[i] = new Mat();
			tmp[i] = Imgcodecs.imread(leader[i], Imgcodecs.IMREAD_COLOR);
		}
		

		image = new Mat();
		result = new Mat();

		royal = "C\\pleiades\\workspace\\WinRate2\\無題.bmp";
		//elf = "C:\\pleiades\\workspace\\WinRate2\\youloss_min.bmp";
		/*elf = "C\\pleiades\\workspace\\WinRate2\\エルフ.bmp";
		royal = "C\\pleiades\\workspace\\WinRate2\\ロイヤル.bmp";
		witch = "C\\pleiades\\workspace\\WinRate2\\ウィッチ.bmp";
		dragon = "C\\pleiades\\workspace\\WinRate2\\ドラゴン.bmp";
		nekura = "C\\pleiades\\workspace\\WinRate2\\ネクロ.bmp";
		vampire = "C\\pleiades\\workspace\\WinRate2\\ヴァンプ.bmp";
		bishop = "C\\pleiades\\workspace\\WinRate2\\ヴィショップ.bmp";
		nemesis = "C\\pleiades\\workspace\\WinRate2\\ネメシス.bmp";
		*/
		temp = Imgcodecs.imread(royal, Imgcodecs.IMREAD_COLOR);

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

	public int Leader_Maching()
	{
		int index = 0;
		for(int num = 0; num < leader.length; num++)
		{
			System.out.println("oral");
			Imgproc.matchTemplate(image, temp, result, Imgproc.TM_CCOEFF_NORMED);
			Imgproc.threshold(result, result, 0.8, 1.0, Imgproc.THRESH_TOZERO);

			for(int i = 0; i < result.rows(); i++)
			{
				for(int j = 0; j < result.cols(); j++)
				{
					if(result.get(i, j)[0] > 0)	index = num;
				}
			}
		}
		return index;
	}
}
