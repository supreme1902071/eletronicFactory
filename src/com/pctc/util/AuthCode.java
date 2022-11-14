package com.pctc.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;


/**
 * ������֤��
 * @author Administrator
 *
 */
public class AuthCode {
	public static final int AUTHCODE_LENGTH=5;     //��֤��ĳ���
	public static final int SINGLECODE_WIDTH=15;   //������֤����
	public static final int SINGLECODE_HEIGHT=30;  //������֤��߶�
	public static final int SINGLECODE_GAP=4;      //������֤��֮����
	public static final int IMG_WIDTH=AUTHCODE_LENGTH*(SINGLECODE_WIDTH+SINGLECODE_GAP);
	public static final int IMG_HEIGHT=SINGLECODE_HEIGHT;  
	
	
	 // ������֤��
	public static String getAuthCode(){
		String anthCode="";
		for(int i=0;i<AUTHCODE_LENGTH;i++){
			anthCode+=new Random().nextInt(10);  //0��10
		}
		return anthCode;
	}
	
	
	public static BufferedImage getAuthImg(String authCode){
		
		//����ͼƬ�ĸߡ�������  
        //RGB���룺red��green��blue  
		BufferedImage image=new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_BGR);
		
		//�õ�ͼƬ�ϵ�һ������ 
		Graphics g=image.getGraphics();
		
		//���û��ʵ���ɫ������������ɫ
		g.setColor(Color.YELLOW);
		
		//�û��������һ�����Σ����ε����Ͻ����꣬����
		g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		
		//����������ɫ������д��
		g.setColor(Color.BLACK);
		
		//��������  ���塢������ʽ�ġ��ֺ�
		g.setFont(new Font("����",Font.PLAIN,SINGLECODE_HEIGHT+5));
		
		
		//�������
		char c;
		for(int i=0;i<authCode.toCharArray().length;i++){
			c=authCode.charAt(i);
			//����һ���ַ�����Ҫ�������ݣ���ʼ��λ�ã��߶�
			g.drawString(c+"", i*(SINGLECODE_WIDTH + SINGLECODE_GAP), IMG_HEIGHT);
		}
		
		
		//������
		Random random=new Random();
		for(int i=0;i<10;i++){
			int x=random.nextInt(IMG_WIDTH);
			int y=random.nextInt(IMG_HEIGHT);
			int x2=random.nextInt(IMG_WIDTH);
			int y2=random.nextInt(IMG_HEIGHT);
			
			g.drawLine(x, y, x2, y2);
		}
		return image;
	}
	
	
	
	
	
	
}
