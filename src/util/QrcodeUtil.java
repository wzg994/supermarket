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
 * ��ά�����ɹ�����
 */
public class QrcodeUtil {

//	/*
//	 * ���ɶ�ά��ͼƬ
//	 */
//	public BufferedImage getqrcodeImg() {
//		BufferedImage bufferedImage = null;
//		boolean bs[][] = null;
//		int width = 150;
//		int height = 150;
//		// ����һ������
//		bufferedImage = new BufferedImage(width, height, 1);
//
//		// ��ȡ��ͼ����
//		Graphics2D graphics2d = bufferedImage.createGraphics();
//		// ���ñ���ɫ
//		graphics2d.setBackground(Color.white);
//
//		graphics2d.fillRect(0, 0, width, height);
//		// ����ǰ��ɫ
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

		//�����ļ���
		File file=new File(shop);

		//����Qrcode����
		Qrcode qrcode = new Qrcode();

		try {
			// ���ַ������ά����
			bs = qrcode.calQrcode(ccc.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ö�ά����뷽ʽ
		qrcode.setQrcodeEncodeMode('B');
		//���ö�ά���Ŵ���,�Ŵ���Խ�߿ɴ洢����ϢԽ�٣����Զ�ά�������ȵ�Ҫ��ԽС
		qrcode.setQrcodeErrorCorrect('M');
		//�������ö�ά��ߴ磬ȡֵ��Χ1-40��ֵԽ��ߴ�Խ�󣬿ɴ洢����ϢԽ��
		qrcode.setQrcodeVersion(10);
		// ����һ������
		bufferedImage = new BufferedImage(width, height, 1);

		// ��ȡ��ͼ����
		Graphics2D graphics2d = bufferedImage.createGraphics();
		// ���ñ���ɫ
		graphics2d.setBackground(Color.white);
		//���ñ�����С
		graphics2d.fillRect(0, 0, width, height);
		// ����ǰ��ɫ
		graphics2d.setColor(Color.black);
		//�����ֽ�����  �������> ��ά��
		for (int i = 0; i < bs.length; i++) {
			for (int j = 0; j < bs.length; j++) {
				if (bs[i][j]) {
					graphics2d.fillRect(j * 3, i * 3, 3, 3);
				}
			}
		}

		try {
			//���ɶ�ά��QRCodeͼƬ  
			ImageIO.write(bufferedImage, "jpg", file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return out;
	}

}
