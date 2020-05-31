package util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;


/*
 * 二维码生成工具类
 */
public class QrcodeUtil {

//	/*
//	 * 生成二维码图片
//	 */
//	public BufferedImage getqrcodeImg() {
//		BufferedImage bufferedImage = null;
//		boolean bs[][] = null;
//		int width = 150;
//		int height = 150;
//		// 创建一个画板
//		bufferedImage = new BufferedImage(width, height, 1);
//
//		// 获取绘图对象
//		Graphics2D graphics2d = bufferedImage.createGraphics();
//		// 设置背景色
//		graphics2d.setBackground(Color.white);
//
//		graphics2d.fillRect(0, 0, width, height);
//		// 设置前景色
//		graphics2d.setColor(Color.black);
//		for (int i = 0; i < bs.length; i++) {
//			for (int j = 0; j < bs.length; j++) {
//				if (bs[i][j]) {
//					graphics2d.fillRect(j * 3, i * 3, 3, 3);
//				}
//			}
//		}
//		return bufferedImage;
//	}

	public static int getqrcode(String ccc, String shop) {
		boolean bs[][] = null;
		BufferedImage bufferedImage = null;
		int width = 150;
		int height = 150;
		int out = 0;

		//创建文件夹
		File file=new File(shop);

		//创建Qrcode对象
		Qrcode qrcode = new Qrcode();

		try {
			// 将字符存入二维数组
			bs = qrcode.calQrcode(ccc.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置二维码编码方式
		qrcode.setQrcodeEncodeMode('B');
		//设置二维码排错率,排错率越高可存储的信息越少，但对二维码清晰度的要求越小
		qrcode.setQrcodeErrorCorrect('M');
		//设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
		qrcode.setQrcodeVersion(10);
		// 创建一个画板
		bufferedImage = new BufferedImage(width, height, 1);

		// 获取绘图对象
		Graphics2D graphics2d = bufferedImage.createGraphics();
		// 设置背景色
		graphics2d.setBackground(Color.white);
		//设置背景大小
		graphics2d.fillRect(0, 0, width, height);
		// 设置前景色
		graphics2d.setColor(Color.black);
		//遍历字节数组  输出内容> 二维码
		for (int i = 0; i < bs.length; i++) {
			for (int j = 0; j < bs.length; j++) {
				if (bs[i][j]) {
					graphics2d.fillRect(j * 3, i * 3, 3, 3);
				}
			}
		}

		try {
			//生成二维码QRCode图片  
			ImageIO.write(bufferedImage, "jpg", file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return out;
	}

}
